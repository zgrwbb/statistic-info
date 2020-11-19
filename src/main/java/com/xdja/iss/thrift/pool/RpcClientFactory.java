package com.xdja.iss.thrift.pool;

import com.xdja.iss.thrift.datatype.ResStr;
import com.xdja.iss.thrift.stub.RPCManagerStub;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Socket;

/**
 * @author xdja
 */
public class RpcClientFactory implements PooledObjectFactory<RpcClient<RPCManagerStub.Client>> {
    private static final String OK = "OK";
    private static Logger log = LoggerFactory.getLogger(RpcClientFactory.class);
    private final String host;
    private final int port;
    private final int timeout;

    public RpcClientFactory(final String host, final int port, final int timeout) {
        super();
        this.host = host;
        this.port = port;
        this.timeout = timeout;
    }


    @Override
    public PooledObject<RpcClient<RPCManagerStub.Client>> makeObject() throws Exception {
        TSocket tsocket = new TSocket(this.host, this.port, this.timeout);
        TTransport transport = new TFramedTransport(tsocket);
        // 协议要和服务端一致
        TProtocol protocol = new TBinaryProtocol(transport);
        RPCManagerStub.Client stubClient = new RPCManagerStub.Client(protocol);
        RpcClient<RPCManagerStub.Client> rpcClient = new RpcClient<>(stubClient, transport, tsocket.getSocket());
        rpcClient.open();
        return new DefaultPooledObject<>(rpcClient);
    }

    @Override
    public void destroyObject(PooledObject<RpcClient<RPCManagerStub.Client>> pooledObject) {
        if (pooledObject == null) {
            return;
        }
        RpcClient<RPCManagerStub.Client> rpcClient = pooledObject.getObject();
        rpcClient.close();
    }

    @Override
    public boolean validateObject(PooledObject<RpcClient<RPCManagerStub.Client>> pooledObject) {
        if (pooledObject == null) {
            return false;
        }
        try {
            RpcClient<RPCManagerStub.Client> ci = pooledObject.getObject();
            if (!checkSocket(ci.getSocket())) {
                return false;
            }
            ResStr res = ci.getClient().echo(OK);
            return res.res == 200 && OK.equals(res.value);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void activateObject(PooledObject<RpcClient<RPCManagerStub.Client>> pooledObject) throws Exception {
        log.info("激活客户端");
        pooledObject = makeObject();
    }

    @Override
    public void passivateObject(PooledObject<RpcClient<RPCManagerStub.Client>> pooledObject) {
        log.info("反激活客户端");
        pooledObject = null;
    }


    public boolean checkSocket(Socket socket) {
        return socket != null
                && socket.isBound()
                && !socket.isClosed()
                && socket.isConnected()
                && !socket.isInputShutdown()
                && !socket.isOutputShutdown();
    }

}

package com.xdja.iss.thrift.client;

import com.xdja.iss.thrift.datatype.ResStr;
import com.xdja.iss.thrift.stub.RPCManagerStub;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.net.Socket;

@Slf4j
@Builder
public class ClientFactory extends BasePooledObjectFactory<RPCManagerStub.Client> {


    private final String host;
    private final int port;
    private final int timeout;

    /**
     * 创建一个对象实例
     */
    @Override
    @SuppressWarnings({"java:S2095"})
    public RPCManagerStub.Client create() {
        try {
            // 池化 所以现在不关, 关闭会导致失败
            TTransport transport = new TFramedTransport(new TSocket(host, port, timeout));
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            return new RPCManagerStub.Client(protocol);
        } catch (TTransportException e) {
            return null;
        }
    }

    /**
     * 包裹创建的对象实例，返回一个pooledobject
     */
    @Override
    public PooledObject<RPCManagerStub.Client> wrap(RPCManagerStub.Client client) {
        return new DefaultPooledObject<>(client);
    }

    @Override
    public boolean validateObject(PooledObject<RPCManagerStub.Client> p) {
        if (p == null) {
            return false;
        }
        RPCManagerStub.Client client = p.getObject();
        if (client == null) {
            return false;
        }
        ResStr res;
        try {
            res = client.echo("OK");
        } catch (TException e) {
            return false;
        }
        if (res == null) {
            return false;
        }
        return "OK".equals(res.value);
    }
}

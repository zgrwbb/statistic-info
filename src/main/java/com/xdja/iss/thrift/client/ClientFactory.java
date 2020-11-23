package com.xdja.iss.thrift.client;

import com.xdja.iss.thrift.stub.RPCManagerStub;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

@Log4j2
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
    public synchronized RPCManagerStub.Client create() {
        try {
            // 池化 所以现在不关, 关闭会导致失败
            TTransport transport = new TFramedTransport(new TSocket(host, port, timeout));
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            return new RPCManagerStub.Client(protocol);
        } catch (TTransportException e) {
            log.error("", e);
        }
        return null;

    }

    /**
     * 包裹创建的对象实例，返回一个pooledobject
     */
    @Override
    public PooledObject<RPCManagerStub.Client> wrap(RPCManagerStub.Client client) {
        return new DefaultPooledObject<>(client);
    }
}

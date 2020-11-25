package com.xdja.iss.thrift.pool;

import com.xdja.iss.thrift.stub.RPCManagerStub;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

@Slf4j
@Builder
public class ClientFactory extends BasePooledObjectFactory<RPCManagerStub.Client> {

    private final String host;
    private final int port;
    private final int timeout;

    @Override
    public RPCManagerStub.Client create() throws Exception {
        TTransport tTransport = new TFramedTransport(new TSocket(host, port, timeout));
        if (!tTransport.isOpen()) {
            tTransport.open();
        }
        TProtocol tProtocol = new TBinaryProtocol(tTransport);
        return new RPCManagerStub.Client(tProtocol);
    }

    @Override
    public PooledObject<RPCManagerStub.Client> wrap(RPCManagerStub.Client tTransport) {
        return new DefaultPooledObject<>(tTransport);
    }

    @Override
    public boolean validateObject(PooledObject<RPCManagerStub.Client> client) {
        return client.getObject().getInputProtocol().getTransport().isOpen();
    }

    @Override
    public void destroyObject(PooledObject<RPCManagerStub.Client> client) {
        if (client.getObject().getInputProtocol().getTransport().isOpen()) {
            client.getObject().getInputProtocol().getTransport().close();
        }
    }
}

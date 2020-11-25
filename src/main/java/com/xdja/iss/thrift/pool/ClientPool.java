package com.xdja.iss.thrift.pool;

import com.xdja.iss.thrift.stub.RPCManagerStub;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 * @author Created by wbb on 2020/11/20 18:37:36
 */
public class ClientPool extends GenericObjectPool<RPCManagerStub.Client> {



    public ClientPool(PooledObjectFactory<RPCManagerStub.Client> factory) {
        this(factory, new ClientConfig());
    }

    public ClientPool(PooledObjectFactory<RPCManagerStub.Client> factory, ClientConfig config) {
        super(factory, config);
    }
}

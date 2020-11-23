package com.xdja.iss.thrift.client;

import com.xdja.iss.thrift.stub.RPCManagerStub;
import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 * @author Created by wbb on 2020/11/20 18:37:36
 */
public class ClientPool extends GenericObjectPool<RPCManagerStub.Client> {

    public ClientPool(ClientFactory clientFactory) {
        super(clientFactory, new ClientConfig());
    }

    public ClientPool(ClientFactory clientFactory, ClientConfig clientConfig) {
        super(clientFactory, clientConfig);
    }
}

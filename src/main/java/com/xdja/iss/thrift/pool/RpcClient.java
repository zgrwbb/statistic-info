package com.xdja.iss.thrift.pool;

import org.apache.thrift.TServiceClient;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.net.Socket;

/**
 * @param <T>
 * @author xdja
 */
public class RpcClient<T extends TServiceClient> {
    private final TTransport transport;
    private final T client;
    private final Socket socket;

    RpcClient(T client, TTransport transport, Socket socket) {
        this.client = client;
        this.transport = transport;
        this.socket = socket;
    }

    public void open() throws TTransportException {
        transport.open();
    }

    public void close() {
        transport.close();
    }

    public T getClient() {
        return client;
    }

    Socket getSocket() {
        return socket;
    }
}

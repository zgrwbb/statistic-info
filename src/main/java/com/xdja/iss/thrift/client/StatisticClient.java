package com.xdja.iss.thrift.client;

import com.xdja.iss.thrift.datatype.ResStr;
import com.xdja.iss.thrift.pool.ClientFactory;
import com.xdja.iss.thrift.pool.ClientPool;
import com.xdja.iss.thrift.stub.RPCManagerStub;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wbb
 */
@Slf4j
@SuppressWarnings({"java:S112", "java:S1192", "java:S2696", "unused", "java:S1226", "java:S1854"})
public class StatisticClient {
    @Getter
    private final ClientPool pool;

    public StatisticClient(String host, Integer port, Integer timeout) {
        pool = new ClientPool(ClientFactory.builder().host(host).port(port).timeout(timeout).build());
    }

    /**
     * 查询业务信息
     *
     * @param ext ext
     * @return ResStr
     */
    @SneakyThrows
    public ResStr queryService(String ext) {
        RPCManagerStub.Client client = null;
        try {
            client = getClient();
            ResStr res = client.queryService(ext);
            log.trace("{}", res);
            return res;
        } finally {
            close(client);
        }
    }

    @SneakyThrows
    public RPCManagerStub.Client getClient() {
        return pool.borrowObject();
    }

    public void close(RPCManagerStub.Client client) {
        if (client == null) {
            return;
        }
        pool.returnObject(client);
    }

    /**
     * 查询链接信息
     *
     * @param serviceType 业务类型
     * @param ext         ext
     * @return ResStr
     */
    @SneakyThrows
    public ResStr queryConnection(int serviceType, String ext) {
        RPCManagerStub.Client client = null;
        try {
            client = getClient();
            ResStr res = client.queryConntrack(serviceType, ext);
            log.trace("{}", res);
            return res;
        } finally {
            close(client);
        }
    }

    /**
     * 查询链接详情
     *
     * @param serviceType 业务类型
     * @param proxyId     策略主键
     * @param ext         ext
     * @return ResStr
     */
    @SneakyThrows
    public ResStr queryDetail(int serviceType, int proxyId, String ext) {
        RPCManagerStub.Client client = null;
        try {
            client = getClient();
            ResStr res = client.queryDetail(serviceType, proxyId, ext);
            log.trace("{}", res);
            return res;
        } finally {
            close(client);
        }
    }
}

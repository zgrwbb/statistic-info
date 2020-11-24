package com.xdja.iss.thrift.client;

import com.xdja.iss.thrift.datatype.ResStr;
import com.xdja.iss.thrift.stub.RPCManagerStub;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wbb
 */
@Slf4j
@SuppressWarnings({"java:S112", "java:S1192", "java:S2696", "unused", "java:S1226", "java:S1854"})
public class StatisticClient {
    @Getter
    private static ClientPool pool;
    @Getter
    private final int timeout;
    @Getter
    private final String host;
    @Getter
    private final int port;

    public StatisticClient(String host, int port, int timeout) {
        this.host = host;
        this.port = port;
        this.timeout = timeout;
    }

    /**
     * 查询业务信息
     *
     * @param ext ext
     * @return ResStr
     */
    public ResStr queryService(String ext) {
        RPCManagerStub.Client client = null;
        try {
            client = pool.borrowObject();
            if (client != null) {
                ResStr res = client.queryService(ext);
                log.trace("{}", res);
                return res;
            }
        } catch (Exception e) {
            log.error("查询业务信息错误", e);
            return new ResStr().setRes(0);
        } finally {
            pool.returnObject(client);
        }
        return new ResStr().setRes(0);
    }

    /**
     * 查询链接信息
     *
     * @param serviceType 业务类型
     * @param ext         ext
     * @return ResStr
     */
    public ResStr queryConnection(int serviceType, String ext) {
        RPCManagerStub.Client client = null;
        try {
            client = pool.borrowObject();
            if (client != null) {
                ResStr res = client.queryConntrack(serviceType, ext);
                log.trace("{}", res);
                return res;
            }
        } catch (Exception e) {
            log.error("查询链接信息失败", e);
            return new ResStr().setRes(0);
        } finally {
            pool.returnObject(client);
        }
        return new ResStr().setRes(0);
    }

    /**
     * 查询链接详情
     *
     * @param serviceType 业务类型
     * @param proxyId     策略主键
     * @param ext         ext
     * @return ResStr
     */
    public ResStr queryDetail(int serviceType, int proxyId, String ext) {
        RPCManagerStub.Client client = null;
        try {
            client = pool.borrowObject();
            if (client != null) {
                ResStr res = client.queryDetail(serviceType, proxyId, ext);
                log.trace("{}", res);
                return res;
            }
        } catch (Exception e) {
            log.error("查询链接详情失败", e);
            return new ResStr().setRes(0);
        } finally {
            pool.returnObject(client);
        }
        return new ResStr().setRes(0);
    }

    public void init() {
        pool = new ClientPool(ClientFactory.builder().host(host).port(port).timeout(timeout).build());
    }

    public void destroy() {
        pool.close();
    }
}

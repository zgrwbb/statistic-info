package com.xdja.iss.thrift.client;

import com.xdja.iss.thrift.datatype.ResStr;
import com.xdja.iss.thrift.stub.RPCManagerStub;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 * @author wbb
 */
@Log4j2
@SuppressWarnings({"java:S112", "java:S1192", "java:S2696", "unused", "java:S1226", "java:S1854"})
public class StatisticClient {

    private static GenericObjectPool<RPCManagerStub.Client> pool;
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

    public static void main(String[] args) {
        StatisticClient statisticClient = new StatisticClient(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        statisticClient.init();
        for (int i = 0; i < Integer.parseInt(args[3]); i++) {
            Thread thread = new Thread(() -> {
                RPCManagerStub.Client client = null;
                try {
                    client = pool.borrowObject();
                    if (client != null) {
                        ResStr res = client.echo("OK");
                        log.info("{}", res);
                    }
                } catch (Exception e) {
                    log.error("", e);
                } finally {
                    pool.returnObject(client);
                }
            });
            thread.start();
        }
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
        ClientFactory clientFactory = ClientFactory.builder().host(host).port(port).timeout(timeout).build();
        pool = new ClientPool(clientFactory);
    }

    public void destroy() {
        pool.close();
    }
}

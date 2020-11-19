package com.xdja.iss.thrift.client;

import com.xdja.iss.thrift.datatype.ResStr;
import com.xdja.iss.thrift.pool.RpcClient;
import com.xdja.iss.thrift.pool.RpcClientFactory;
import com.xdja.iss.thrift.pool.RpcPool;
import com.xdja.iss.thrift.pool.RpcPoolConfig;
import com.xdja.iss.thrift.stub.RPCManagerStub;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lxl
 */
public class StatisticClient {
    private static final Logger log = LoggerFactory.getLogger(StatisticClient.class);
    private final int timeout;
    private final String host;
    private final int port;
    private RpcPool<RpcClient<RPCManagerStub.Client>> rpcstubpool = null;

    public StatisticClient(String host, int port, int timeout) {
        this.host = host;
        this.port = port;
        this.timeout = timeout;
    }

    /**
     * PMClient初始化
     *
     * @return 初始化成功返回true，失败返回false
     */
    public boolean init() {
        RpcClientFactory rcf = new RpcClientFactory(this.host, this.port, this.timeout);
        rpcstubpool = new RpcPool<>();
        return rpcstubpool.init(new RpcPoolConfig(), rcf);
    }

    private RpcClient<RPCManagerStub.Client> getServiceClient() {
        try {
            return rpcstubpool.getResource();
        } catch (Exception e) {
            rpcstubpool.returnBrokenResource(null);
            return null;
        }
    }

    /**
     * PMClient关闭
     */
    public void destroy() {
        if (rpcstubpool == null) {
            return;
        }
        try {
            rpcstubpool.destroy();
            rpcstubpool = null;
        } catch (Exception e) {
            log.error("", e);
        }
    }

    /**
     * 查询业务信息
     *
     * @param ext ext
     * @return ResStr
     */
    public ResStr queryService(String ext) {
        RpcClient<RPCManagerStub.Client> rc = getServiceClient();
        if (rc == null) {
            return new ResStr().setRes(0);
        }

        try {
            return rc.getClient().queryService(ext);
        } catch (TException e) {
            log.error("查询业务信息失败, ext: {}", ext);
            return new ResStr().setRes(0);
        }
    }

    /**
     * 查询链接信息
     *
     * @param serviceType 业务类型
     * @param ext         ext
     * @return ResStr
     */
    public ResStr queryConnection(int serviceType, String ext) {
        RpcClient<RPCManagerStub.Client> rc = getServiceClient();
        if (rc == null) {
            return new ResStr().setRes(0);
        }
        try {
            return rc.getClient().queryConntrack(serviceType, ext);
        } catch (TException e) {
            log.error("查询链接信息失败, serviceType: {}, ext: {}", serviceType, ext);
            return new ResStr().setRes(0);
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
    public ResStr queryDetail(int serviceType, int proxyId, String ext) {
        RpcClient<RPCManagerStub.Client> rc = getServiceClient();
        if (rc == null) {
            return new ResStr().setRes(0);
        }
        try {
            return rc.getClient().queryDetail(serviceType, proxyId, ext);
        } catch (TException e) {
            log.error("查询链接详情失败, serviceType: {}, proxyId: {},  ext: {}", serviceType, proxyId, ext);
            return new ResStr().setRes(0);
        }
    }
}

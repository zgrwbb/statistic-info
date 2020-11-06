package com.xdja.iss.thrift;

import com.xdja.iss.thrift.datatype.ResStr;
import com.xdja.iss.thrift.stub.RPCManagerStub;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据统计
 *
 * @author root
 */
public class StatisticClient {

    private static final Logger log = LoggerFactory.getLogger(StatisticClient.class);

    private RPCManagerStub.Client client = null;

    public StatisticClient() {

    }

    /**
     * 初始化
     *
     * @param serverHost PRC服务端地址
     * @param serverPort PRC服务端端口
     * @param timeout    超时时间
     */
    public StatisticClient(String serverHost, int serverPort, int timeout) {
        TTransport tTransport = new TFramedTransport(new TSocket(serverHost, serverPort, timeout));
        //协议要和服务端一致
        TProtocol protocol = new TBinaryProtocol(tTransport);
        client = new RPCManagerStub.Client(protocol);
        try {
            tTransport.open();
        } catch (TTransportException e) {
            log.error("链接统计RPC链接失败, host: {}, port: {}, timeout: {}", serverHost, serverPort, timeout);
        }
    }

    /**
     * 查询业务信息
     *
     * @param ext ext
     * @return ResStr
     */
    public ResStr queryService(String ext) {
        try {
            return client.queryService(ext);
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
        try {
            return client.queryConntrack(serviceType, ext);
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
        try {
            return client.queryDetail(serviceType, proxyId, ext);
        } catch (TException e) {
            log.error("查询链接详情失败, serviceType: {}, proxyId: {},  ext: {}", serviceType, proxyId, ext);
            return new ResStr().setRes(0);
        }

    }
}
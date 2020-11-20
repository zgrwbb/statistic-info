package com.xdja.iss.thrift.client;

import com.xdja.iss.thrift.datatype.ResStr;
import com.xdja.iss.thrift.stub.RPCManagerStub;
import lombok.extern.log4j.Log4j2;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @author lxl
 */
@Log4j2
@SuppressWarnings({"java:S112", "java:S2696", "unused", "java:S1226", "java:S1854"})
public class StatisticClient {

    private final int timeout;
    private final String host;
    private final int port;

    public StatisticClient(String host, int port, int timeout) {
        this.host = host;
        this.port = port;
        this.timeout = timeout;
    }

    public static void main(String[] args) {
        log.info("{}", (Object) args);
        try (TTransport transport = new TFramedTransport(new TSocket(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[1])))) {
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            RPCManagerStub.Client client = new RPCManagerStub.Client(protocol);
            log.info("{}", client.echo("OK"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询业务信息
     *
     * @param ext ext
     * @return ResStr
     */

    public ResStr queryService(String ext) {
        try (TTransport transport = new TFramedTransport(new TSocket(host, port, timeout))) {
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            RPCManagerStub.Client client = new RPCManagerStub.Client(protocol);
            return client.queryService(ext);
        } catch (TTransportException e) {
            log.error("", e);
            throw new RuntimeException("建立RPC链接失败");
        } catch (TException e) {
            log.error("查询业务信息失败, ext: {}", ext, e);
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
        try (TTransport transport = new TFramedTransport(new TSocket(host, port, timeout))) {
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            RPCManagerStub.Client client = new RPCManagerStub.Client(protocol);
            return client.queryConntrack(serviceType, ext);
        } catch (TTransportException e) {
            log.error("", e);
            throw new RuntimeException("建立RPC链接失败");
        } catch (TException e) {
            log.error("查询链接信息失败, serviceType: {}, ext: {}", serviceType, ext, e);
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
        try (TTransport transport = new TFramedTransport(new TSocket(host, port, timeout))) {
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            RPCManagerStub.Client client = new RPCManagerStub.Client(protocol);
            return client.queryDetail(serviceType, proxyId, ext);
        } catch (TTransportException e) {
            log.error("", e);
            throw new RuntimeException("建立RPC链接失败");
        } catch (TException e) {
            log.error("查询链接信息失败, serviceType: {}, proxyId: {} ext: {}", serviceType, proxyId, ext, e);
            return new ResStr().setRes(0);
        }
    }
}

package com.xdja.iss.thrift.client;

import com.xdja.iss.thrift.datatype.ResStr;
import com.xdja.iss.thrift.stub.RPCManagerStub;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Created by wbb on 2020/11/23 18:10:02
 */
@Slf4j
class StatisticClientTest {

    @Test
    void testRpc() {
        String[] args = {"11.12.115.104", "9527", "300000", "300"};
        StatisticClient statisticClient = new StatisticClient(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        statisticClient.init();
        RPCManagerStub.Client client = null;
        try {
            client = StatisticClient.getPool().borrowObject();
            if (client != null) {
                ResStr res = client.echo("OK");
                log.info("{}", res);
                assertEquals("OK", res.value);
            }
        } catch (Exception e) {
            log.error("", e);
        } finally {
            StatisticClient.getPool().returnObject(client);
        }
    }
}
package com.xdja.iss.thrift.client;

import com.xdja.iss.thrift.datatype.ResStr;
import com.xdja.iss.thrift.stub.RPCManagerStub;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Created by wbb on 2020/11/23 18:10:02
 */
@Slf4j
class StatisticClientTest {

    @Test
    @SneakyThrows
    void testRpc() {
        String[] args = {"11.12.115.145", "9527", "300000", "300"};
        StatisticClient statisticClient = new StatisticClient(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            new Thread(() -> {
                RPCManagerStub.Client client = null;
                try {
                    client = statisticClient.getClient();
                    if (client != null) {
                        ResStr res = client.echo("OK");
                        log.info("{}: {}", finalI, res);
                        assertEquals("OK", res.value);
                    }
                } catch (Exception e) {
                    log.error("", e);
                } finally {
                    statisticClient.close(client);
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(10000);
    }
}
package com.xdja.iss.thrift.pool;

import com.xdja.iss.thrift.stub.RPCManagerStub;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class ClientConfig extends GenericObjectPoolConfig<RPCManagerStub.Client> {
    public ClientConfig() {
        // 最大空闲数
        setMaxIdle(5);
        // 最小空闲数, 池中只有一个空闲对象的时候，池会在创建一个对象，并借出一个对象，从而保证池中最小空闲数为1
        setMinIdle(1);
        // 最大池对象总数
        setMaxTotal(10);
        // 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
        setMinEvictableIdleTimeMillis(30000);
        // 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
        setTimeBetweenEvictionRunsMillis(30000);
        // 在获取对象的时候检查有效性, 默认false
        setTestOnBorrow(true);
        // 在归还对象的时候检查有效性, 默认false
        setTestOnReturn(false);
        // 在空闲时检查有效性, 默认false
        setTestWhileIdle(true);
        // 最大等待时间， 默认的值为-1，表示无限等待。
        setMaxWaitMillis(5000);
        // 是否启用后进先出, 默认true
        setLifo(true);
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        setBlockWhenExhausted(true);
        // 每次逐出检查时 逐出的最大数目 默认3
        setNumTestsPerEvictionRun(3);
    }
}
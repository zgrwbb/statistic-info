package com.xdja.iss.thrift.pool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * 连接池配置
 * @author xdja
 */
public class RpcPoolConfig extends GenericObjectPoolConfig {

    public RpcPoolConfig() {
        // 最小空闲数, 池中只有一个空闲对象的时候，池会在创建一个对象，并借出一个对象，从而保证池中最小空闲数为1
        setMinIdle(1);
        // 最大空闲数
        setMaxIdle(5);
        // 最大池对象总数
        setMaxTotal(5);
        // 连接空闲的最小时间，达到此值后空闲连接将可能会被移除。负值(-1)表示不移除
        setMinEvictableIdleTimeMillis(5000);
        // 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
        setTimeBetweenEvictionRunsMillis(30000);
        // 在获取对象的时候检查有效性, 默认false
        setTestOnBorrow(true);
        // 在归还对象的时候检查有效性, 默认false
        setTestOnReturn(false);
        // 在空闲时检查有效性, 默认false
        setTestWhileIdle(false);
        // 最大等待时间， 默认的值为-1，表示无限等待。
        setMaxWaitMillis(5000);
        // 是否启用后进先出, 默认true
        setLifo(true);
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        setBlockWhenExhausted(true);
        // 每次逐出检查时 逐出的最大数目 默认3
        setNumTestsPerEvictionRun(-1);
    }

}
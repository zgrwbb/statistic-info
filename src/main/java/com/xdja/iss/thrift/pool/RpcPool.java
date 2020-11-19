package com.xdja.iss.thrift.pool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @param <T>
 * @author xdja
 */
public class RpcPool<T> {
    private static Logger log = LoggerFactory.getLogger(RpcPool.class);
    private GenericObjectPool<T> internalPool;
    private AtomicBoolean isInit = new AtomicBoolean(false);

    /**
     * 检测是否进行初始化
     */
    private boolean isInit() {
        return isInit.get();
    }

    /**
     * 初始化
     */
    public boolean init(final RpcPoolConfig poolConfig, PooledObjectFactory<T> factory) {
        isInit.set(true);
        if (this.internalPool != null) {
            try {
                destroy();
            } catch (Exception e) {
                return false;
            }
        }

        this.internalPool = new GenericObjectPool<>(factory, poolConfig);
        return true;
    }

    /**
     * 销毁对象池
     */
    public void destroy() {
        if (!isInit()) {
            return;
        }
        try {
            internalPool.close();
        } catch (Exception e) {
            log.error("", e);
        }
    }

    /**
     * 从对象池借用对象
     */
    public T getResource() {
        if (!isInit()) {
            return null;
        }
        try {
            return internalPool.borrowObject();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 归还异常的对象到对象池，对象池会直接销毁该对象
     */
    public void returnBrokenResource(final T resource) {
        if (!isInit()) {
            return;
        }
        if (resource == null) {
            return;
        }
        try {
            internalPool.invalidateObject(resource);
        } catch (Exception e) {
            log.error("", e);
        }

    }

    /**
     * 归还对象到对象池
     */
    public void returnResource(final T resource) {
        if (!isInit()) {
            return;
        }
        if (resource == null) {
            return;
        }
        try {
            internalPool.returnObject(resource);
        } catch (Exception e) {
        }
    }

}

package com.xdja.iss.thrift.exception;

/**
 * @author Created by wbb on 2020/11/23 9:24:47
 */
public class ServiceException extends RuntimeException{
    public ServiceException(String message) {
        super(message);
    }
}

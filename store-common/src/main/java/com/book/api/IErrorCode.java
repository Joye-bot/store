package com.book.api;

/**
 * 常用API返回对象接口
 *
 * @author nndmw
 * @date 2022/02/19
 */
public interface IErrorCode {

    /**
     * 获取返回码
     *
     * @return long
     */
    long getCode();

    /**
     * 获取返回信息
     *
     * @return {@link String}
     */
    String getMessage();
}

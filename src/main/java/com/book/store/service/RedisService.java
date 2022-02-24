package com.book.store.service;

/**
 * redis业务逻辑层
 * 对象合数组都以json形式进行存储
 *
 * @author nndmw
 * @date 2022/02/24
 */
public interface RedisService {

    /**
     * 存储数据
     *
     * @param key   key
     * @param value value
     */
    void set(String key, String value);

    /**
     * 获取数据
     *
     * @param key key
     * @return {@link String}
     */
    String get(String key);

    /**
     * 设置超期时间
     *
     * @param key    关键
     * @param expire 到期
     * @return boolean
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     *
     * @param key 关键
     */
    void remove(String key);

    /**
     * 自增操作
     *
     * @param key   关键
     * @param delta 自增步长
     * @return {@link Long}
     */
    Long increment(String key, long delta);
}

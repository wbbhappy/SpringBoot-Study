package com.lanhuigu.springboot.util;

import java.nio.charset.Charset;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
/**
 * Hash字典工具类
 * @author yihonglei
 */
public class HashRedisUtil {
    private static final Charset utf8 = Charset.forName("utf8");
    /**
     * hset方法
     * @author yihonglei
     * @param redis RedisTemplate模板
     * @param hkey  Hash表名
     * @param key   Hash表中的key,也就是Hash表的字段属性
     * @param value Hash表中字段属性对应的值
     */
    public static boolean hset(RedisTemplate<String, String> redis, final String hkey, final String key, final String value) {
        return redis.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                boolean b = connection.hSet(hkey.getBytes(utf8), key.getBytes(utf8), value.getBytes(utf8));
                return b;
            }
        });
    }
}

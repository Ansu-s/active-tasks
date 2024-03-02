package com.example.springredis;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisMap {
    private static final String redisHashKey = "redisKey";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, String> hashOperations;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    public void addToMap(String key, String value) {
        hashOperations.put(redisHashKey, key, value);
    }

    public String getValueFromMap(String key) {
        return hashOperations.get(redisHashKey, key);
    }


}

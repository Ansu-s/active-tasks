package com.example.springredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MapUsageExample {
    @Autowired
    RedisMap redisMap;
    public void mapExample(){
        redisMap.addToMap("myKey", "Ansu");
        System.out.println("Collected data from the map: " + redisMap.getValueFromMap("myKey"));
    }
}

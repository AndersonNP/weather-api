package com.nascimento.dio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RedisCleanupService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Scheduled(fixedRate = 15000)
    public  void clearRedisCache(){
        redisTemplate.getConnectionFactory().getConnection().flushDb();
    }

}

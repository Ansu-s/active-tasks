package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.Map;
import java.util.Set;

public class JedisClient {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        jedis.set("book:1", "Ikigai");
        jedis.set("book:2", "Java");
        jedis.set("book:3", "Redis");
        System.out.println(jedis);
        String redisOut = jedis.get("book:2");
        System.out.println(redisOut);

        jedis.lpush("Book:1", "B1");
        jedis.lpush("Book:2", "B2");

        String B1 = jedis.rpop("Book:1");
        System.out.println(B1);
        jedis.sadd("nicknames", "nickname#1");
        jedis.sadd("nicknames", "nickname#2");
        jedis.sadd("nicknames", "nickname#1");

        Set<String> nicknames = jedis.smembers("b");
        boolean exists = jedis.sismember("b", "book1");
        System.out.println(exists);

        jedis.hset("user#1", "name", "user1");
        jedis.hset("user#1", "job", "costumer");

        String name = jedis.hget("user#1", "name");

        Map<String, String> fields = jedis.hgetAll("user#1");
        String job = fields.get("job");
        System.out.println(name);
        System.out.println(job);

        Transaction transaction = jedis.multi();

        transaction.set("name", "user1");
        transaction.set("name11", "user2");
        transaction.sadd("name1", "user3", "done");
        transaction.spop("name11");
        transaction.exec();
        String host = "localhost";
        int port = 8095;
        Jedis jedis1 = new Jedis();
        jedis1.set("msg", "Hello");

        Response<String> response1;
        Response<String> response2;
        try {
            Pipeline pipeline = jedis.pipelined();

            pipeline.set("pipe-key", "value1");
            pipeline.set("pipe-key2", "value2");

            pipeline.sync();

            response1 = pipeline.get("pipe-key");
            response2 = pipeline.get("pipe-key2");
            jedis.close();

        } finally {
            jedis.close();
        }
        System.out.println("Response for key1: " + response1.get());
        System.out.println("Response for key2: " + response2.get());


    }
}

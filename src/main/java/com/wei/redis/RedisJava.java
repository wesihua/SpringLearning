package com.wei.redis;

import redis.clients.jedis.Jedis;

public class RedisJava {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("123.207.183.31",6379);
		jedis.auth("123");
		System.out.println("Connection to server sucessfully");
		System.out.println("Server is running: "+jedis.ping());
		
		jedis.set("username", "weisihua");
		System.out.println(jedis.get("username"));
	}
}

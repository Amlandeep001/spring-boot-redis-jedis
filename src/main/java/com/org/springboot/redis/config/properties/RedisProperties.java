package com.org.springboot.redis.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "redis.server")
@lombok.Value
public class RedisProperties
{
	String hostname;
	int port;
}

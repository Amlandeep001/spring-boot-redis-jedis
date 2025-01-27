package com.org.springboot.redis.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Configuration
@ConfigurationProperties(prefix = "redis.server")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RedisProperties
{
	String hostname;
	int port;
}

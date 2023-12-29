package com.org.springboot.redis.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Product")
public class Product implements Serializable
{
	private static final long serialVersionUID = -5147944771965982644L;

	@Id
	int id;
	String name;
	int qty;
	long price;
}

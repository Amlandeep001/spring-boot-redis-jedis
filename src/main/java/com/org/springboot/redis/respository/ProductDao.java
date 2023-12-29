package com.org.springboot.redis.respository;

import java.util.List;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.org.springboot.redis.entity.Product;

@Repository
public class ProductDao
{
	public static final String HASH_KEY = "Product";

	private final RedisTemplate template;

	public ProductDao(RedisTemplate template)
	{
		this.template = template;
	}

	public Product save(Product product)
	{
		template.opsForHash().put(HASH_KEY, product.getId(), product);
		return product;
	}

	public List<Product> findAll()
	{
		return template.opsForHash().values(HASH_KEY);
	}

	public Product findProductById(int id)
	{
		System.out.println("called findProductById() from DB");
		return (Product) template.opsForHash().get(HASH_KEY, id);
	}

	public String deleteProduct(int id)
	{
		template.opsForHash().delete(HASH_KEY, id);
		return "product removed !!";
	}
}

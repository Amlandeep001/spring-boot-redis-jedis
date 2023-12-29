package com.org.springboot.redis.controller;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.springboot.redis.entity.Product;
import com.org.springboot.redis.respository.ProductDao;

@RestController
@RequestMapping("/product")
public class RedisController
{
	private final ProductDao dao;

	public RedisController(ProductDao dao)
	{
		this.dao = dao;
	}

	@PostMapping
	public Product save(@RequestBody Product product)
	{
		return dao.save(product);
	}

	@GetMapping
	public List<Product> getAllProducts()
	{
		return dao.findAll();
	}

	@GetMapping("/{id}")
	@Cacheable(key = "#id", value = "Product", unless = "#result.price > 1000")
	public Product findProduct(@PathVariable int id)
	{
		return dao.findProductById(id);
	}

	@DeleteMapping("/{id}")
	@CacheEvict(key = "#id", value = "Product")
	public String remove(@PathVariable int id)
	{
		return dao.deleteProduct(id);
	}

}

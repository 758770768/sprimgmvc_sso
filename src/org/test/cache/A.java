package org.test.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author Administrator springcache.1 缓存测试类
 */
@Component
public class A {
	@Cacheable(value = "test")
	public String fn(String id) {
		System.out.println("没有走缓存");
		return id;
	}

	@CacheEvict(value = "test", allEntries = true)
	public void reload() {
	}
}

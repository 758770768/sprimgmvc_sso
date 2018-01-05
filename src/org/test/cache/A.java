package org.test.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author Administrator springcache.1 ���������
 */
@Component
public class A {
	@Cacheable(value = "test")
	public String fn(String id) {
		System.out.println("û���߻���");
		return id;
	}

	@CacheEvict(value = "test", allEntries = true)
	public void reload() {
	}
}

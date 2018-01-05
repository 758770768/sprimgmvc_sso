package org.test.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author Administrator springcache.1 缓存测试类
 */
@Component
public class A {

	/**
	 * @param id
	 * @return 添加缓存 value为对应的缓存名字在application.xml
	 * 中配置 key为存在缓存中的key 语法为springel取法
	 *         #加上参数或是对象属性
	 */
	@Cacheable(value = "test", key = "#id")
	public String fn(String id) {
		System.out.println("没有走缓存");
		return id;
	}

	/**
	 * @param id
	 *            缓存删除
	 */
	@CacheEvict(value = "test", key = "#id")
	public void deleteCacheById(String id) {
	}

	/**
	 * 缓存清空
	 */
	@CacheEvict(value = "test", allEntries = true)
	public void reload() {
	}
}

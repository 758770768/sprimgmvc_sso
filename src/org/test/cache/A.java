package org.test.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author Administrator springcache.1 ���������
 */
@Component
public class A {

	/**
	 * @param id
	 * @return ��ӻ��� valueΪ��Ӧ�Ļ���������application.xml
	 * ������ keyΪ���ڻ����е�key �﷨Ϊspringelȡ��
	 *         #���ϲ������Ƕ�������
	 */
	@Cacheable(value = "test", key = "#id")
	public String fn(String id) {
		System.out.println("û���߻���");
		return id;
	}

	/**
	 * @param id
	 *            ����ɾ��
	 */
	@CacheEvict(value = "test", key = "#id")
	public void deleteCacheById(String id) {
	}

	/**
	 * �������
	 */
	@CacheEvict(value = "test", allEntries = true)
	public void reload() {
	}
}

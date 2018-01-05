package org.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.test.cache.A;
import org.test.converter.StringToPerson;
import org.test.pojo.Person;
import org.test.pojo.User;

@Controller
@SessionAttributes("user")
public class TestController {

	@Value("${age}")
	private String age;
	@Value("100")
	private Integer width;

	@Value("${height}")
	private Integer height;

	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}

	@Resource
	private A a;

	@RequestMapping("/test{name}/{id}")
	// cookie��������
	public String test(@PathVariable("name") String name, @PathVariable("id") String id, HttpServletResponse response) {
		System.out.println(name + id);
		System.out.println("age:" + age + "width:" + width);
		Cookie cookie = new Cookie("user", "name");
		cookie.setPath("/");
		cookie.setDomain("localhost");
		response.addCookie(cookie);
		return "test";

	}

	@RequestMapping("/jsonDemo")
	@ResponseBody
	public User fun2(User user) {
		System.out.println(user);
		return user;
	}

	@RequestMapping("/errorDemo")
	public void fun3() {
		int i = 3 / 0;
	}

	@RequestMapping("/modelAttribute")
	public String fun4(@ModelAttribute("user") User user) {
		return "a";
	}

	@RequestMapping("/sessionTest")
	public String fun5() {
		return "s";
	}

	/**
	 * @param binder
	 *            StringToPerson.3.ע���Զ�������ת����
	 */
	/*
	 * @InitBinder public void init(WebDataBinder binder) {
	 * binder.registerCustomEditor(Person.class, new StringToPerson()); }
	 */

	/**
	 * StringToPerson.4��������ת��
	 */
	@RequestMapping("/propertyConverter")
	public void fn1(@RequestParam(value = "person", required = false) Person person) {
		System.out.println(person);
	}

	/**
	 * String2PersonConverter.3��������ת��
	 */
	@RequestMapping("/string2PersonConverter")
	public void fn2(@RequestParam(value = "person", required = false) Person person) {
		System.out.println(person);
	}

	/**
	 * multipartResolver.2�ļ��ϴ�����
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/multipartResolver")
	public String fn2(MultipartFile mFile, HttpServletRequest request, Map<String, String> map) throws IOException {
		String oFileName = mFile.getOriginalFilename();
		String type = oFileName.substring(oFileName.lastIndexOf("."));
		String fileName = System.currentTimeMillis() + "." + type;
		String path = "D:/apache-tomcat-7.0.81-windows-x86/apache-tomcat-7.0.81/webapps/image";
		File file = new File(path, fileName);
		// �����ļ��ĸ���
		FileUtils.copyInputStreamToFile(mFile.getInputStream(), file);
		map.put("result", "successful" + file.getName());
		map.put("path", file.getName());
		return "redirect:/index.jsp";
	}

	/**
	 * springcache.3���Ի���
	 */
	@RequestMapping("/springcache")
	public String fn3(String id) {
		String i = a.fn(id);
		System.out.println("springcache:" + i);
		return "a";
	}

	/**
	 * springcache.3���Ի���ɾ��
	 */
	@RequestMapping("/springcacheDelete")
	public String fn4(String id) {
		a.deleteCacheById(id);
		System.out.println("springcache���:" + id);
		return "a";
	}

}

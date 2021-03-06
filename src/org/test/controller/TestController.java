package org.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.test.cache.A;
import org.test.pojo.Person;
import org.test.pojo.Person2;
import org.test.pojo.Person3;
import org.test.pojo.User;

@Controller
@SessionAttributes("user") // 标注会话属性
public class TestController {

	// 从配置文件取值
	@Value("${age}")
	private String age;
	@Value("100")
	private Integer width;

	@Value("${height}")
	private Integer height;

/*	// 配置sessionAttribute使用
	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}*/

	// 动态注入
	@Resource
	private A a;

	// 请求映射
	@RequestMapping("/test{name}/{id}")
	// cookie
	public String test(@PathVariable("name") String name, @PathVariable("id") String id, HttpServletResponse response) {
		System.out.println(name + id);
		System.out.println("age:" + age + "width:" + width);
		Cookie cookie = new Cookie("user", "name");
		cookie.setPath("/");
		cookie.setDomain("localhost");
		response.addCookie(cookie);
		return "test";

	}

	/**
	 * oliver 2018年1月13日 springmvc_sso 返回json
	 */
	@RequestMapping("/jsonDemo")
	@ResponseBody
	public User fun2(User user) {
		System.out.println(user);
		return user;
	}

	/**
	 * oliver 2018年1月13日 springmvc_sso 错误映射
	 */
	@RequestMapping("/errorDemo")
	public void fun3() {
		int i = 3 / 0;
	}

	/*@RequestMapping("/modelAttribute")
	public String fun4(@ModelAttribute("user") User user) {
		return "a";
	}*/

	@RequestMapping("/sessionTest")
	public String fun5() {
		return "s";
	}

	/**
	 * @param binder
	 * 
	 *            StringToPerson.3.
	 */
	/*
	 * @InitBinder public void init(WebDataBinder binder) {
	 * binder.registerCustomEditor(Person.class, new StringToPerson()); }
	 */

	/**
	 * StringToPerson.4
	 */
	@RequestMapping("/propertyConverter")
	public void fn1(@RequestParam(value = "person", required = false) Person person) {
		System.out.println(person);
	}

	/**
	 * String2PersonConverter.3
	 */
	@RequestMapping("/string2PersonConverter")
	public void fn2(@RequestParam(value = "person", required = false) Person person, String people) {
		System.out.println(person + ":people:" + people);
	}

	/**
	 * multipartResolver.2
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

		FileUtils.copyInputStreamToFile(mFile.getInputStream(), file);
		map.put("result", "successful" + file.getName());
		map.put("path", file.getName());
		return "redirect:/index.jsp";
	}

	/**
	 * springcache.3
	 */
	@RequestMapping("/springcache")
	public String fn3(String id) {
		String i = a.fn(id);
		System.out.println("springcache:" + i);
		return "a";
	}

	/**
	 * springcache.3
	 */
	@RequestMapping("/springcacheDelete")
	public String fn4(String id) {
		a.deleteCacheById(id);
		System.out.println("springcache:" + id);
		return "a";
	}

	/**
	 * ajax 返回json
	 */
	@RequestMapping("/ajaxBack")
	@ResponseBody
	public Person fn4(Person person) {
		System.out.println(person);
		return person;
	}

	/**
	 * ajax返回jsontest02
	 */
	@RequestMapping("/ajaxBack1")
	@ResponseBody
	public List<Object> fn5(Person person) {
		ArrayList<Object> ar = new ArrayList<>();
		ar.add(person);
		ar.add(person);
		return ar;

	}

	/**
	 * ajax返回jsontest02
	 */
	@RequestMapping("/ajaxList")
	@ResponseBody
	public List<Person2> fn5(@RequestBody ArrayList<Person2> pl) {
		System.out.println(pl);
		return pl;

	}

	/**
	 * String2Person3转换测试
	 */
	@RequestMapping("/person3")
	@ResponseBody
	public Person3 fn5(Person3 person) {
		System.out.println(person);
		return person;

	}

	/**
	 * aop测试
	 */
	@RequestMapping("/aopTest")
	public String fn6() {
		System.out.println("thank you very much");
		return "aop";
	}

}

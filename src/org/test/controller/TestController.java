package org.test.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.pojo.User;

@Controller
public class TestController {

	@Value("${age}")
	private String age;
	@Value("100")
	private Integer width;

	@Value("${height}")
	private Integer height;

	@RequestMapping("/test{name}/{id}")
	//cookieøÁ”Ú«Î«Û
	public String test(@PathVariable("name") String name, @PathVariable("id") String id,HttpServletResponse response) {
		System.out.println(name + id);
		System.out.println("age:" + age + "width:" + width);
		Cookie cookie = new Cookie("user","name");
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

}

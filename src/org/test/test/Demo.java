package org.test.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.test.pojo.User;

public class Demo {

	 public static void main(String[] args) {
		 ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("org/test/conf/application.xml");
		 User user = (User) ac.getBean("user");
		 //user.setUname("abc");
		System.out.println(user);
	}
	
}

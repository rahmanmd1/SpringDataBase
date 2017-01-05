package org.learn.test;

import org.learn.beans.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPropertiesFile {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("org/learn/beans/beans.xml");
		User user =  (User) context.getBean("user");
		System.out.println("user: "+ user.toString());
	}

}

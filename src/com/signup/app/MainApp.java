package com.signup.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.signup.dao.InfUser;
import com.signup.model.User;


public class MainApp 
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		InfUser user = (InfUser) context.getBean("userDao");
		User dummy = new User();
		dummy.setFirstName("Saurabh");
		dummy.setLastName("Tax");
		dummy.setMobileNo("9898909098");
		dummy.setEmailId("sab@g.com");
		dummy.setLocation("Pune");
		user.saveUser(dummy);
		
		System.out.println(user.viewUser());
		((AbstractApplicationContext) context).close();
	}

}

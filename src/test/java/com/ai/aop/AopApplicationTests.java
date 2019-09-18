package com.ai.aop;

import com.ai.aop.aspectj.annotation.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	UserService userService;

//	@Test
//	public void testMyProxyBeanFactory(){
//		String xmlPath = "applicationContext.xml";
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(xmlPath);
//		UserService userService = (UserService) ctx.getBean("userService1");
//		userService.addUser();
//		userService.updateUser();
//		userService.deleteUser();
//	}
//
//	@Test
//	public void testMyProxyBeanFactory2(){
//		String xmlPath = "applicationContext.xml";
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(xmlPath);
//		UserService userService = (UserService) ctx.getBean("proxyService");
//		userService.addUser();
//		userService.updateUser();
//		userService.deleteUser();
//	}
//
//	@Test
//	public void testSpringProxyFactoryBean(){
//		String xmlPath = "applicationContext.xml";
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(xmlPath);
//		UserService userService = (UserService) ctx.getBean("userService");
//		userService.addUser();
//		userService.updateUser();
//		userService.deleteUser();
//	}
//
//	@Test
//	public void testAspectJ(){
//		String xmlPath = "applicationContext.xml";
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(xmlPath);
//		UserService userService = (UserService) ctx.getBean("userServiceImpl");
//		userService.addUser();
//		userService.updateUser();
//		userService.deleteUser();
//	}

	@Test
	public void testAspectJAnnotation(){
		String xmlPath = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(xmlPath);
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}

}

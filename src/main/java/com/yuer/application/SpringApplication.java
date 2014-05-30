package com.yuer.application;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;
import com.yuer.domain.User;
import com.yuer.service.UserService;

public class SpringApplication {

	private static ApplicationContext context;

	public static void main(String args[]) throws SQLException, InterruptedException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DruidDataSource druidDataSource = (DruidDataSource) context.getBean("dataSource");
		System.out.println(druidDataSource.toString());

		UserService userService = (UserService) context.getBean("userService");
		List<User> userList = userService.findAll();
		for (User u : userList) {
			System.out.println(u.toString());
		}
	}
}

package com.yuer.application;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yuer.domain.User;

/**
 * 怎么添加事务
 */
public class Application {

	private static SqlSessionFactory sessionFactory;

	public static void main(String[] args) throws IOException, InterruptedException {

		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sessionFactory.openSession();
		User user = session.selectOne("com.yuer.persistence.UserMapper.get", 213);

		Thread.sleep(5 * 1000);

		System.out.println(user);
		System.out.println("----------------------------");

		List<User> userList = session.selectList("com.yuer.persistence.UserMapper.selectAll");
		for (User u : userList) {
			System.out.println(u.toString());
		}

		session.close();
	}

	public static SqlSession getBatchSqlSession() {
		return sessionFactory.openSession(ExecutorType.BATCH, false);
	}

	public static void closeSession(SqlSession sqlSession) {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
}
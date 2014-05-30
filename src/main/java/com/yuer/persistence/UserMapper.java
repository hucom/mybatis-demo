package com.yuer.persistence;

import java.util.List;

import com.yuer.domain.User;

public interface UserMapper {
	void insert(User user);

	/**
	 * 也可以这样写，就不需要在xml里面写了
	 * 
	 * @param id
	 * @return
	 */
	User get(Integer id);

	List<User> selectAll();
}

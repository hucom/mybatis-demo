package com.yuer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuer.domain.User;
import com.yuer.persistence.UserMapper;

/**
 * @author zhuc
 * @create 2013-3-11 下午1:19:03
 */
@Service("userService")
// @Transactional(value = "isap", rollbackFor = Exception.class)
public class UserService extends BaseMySqlService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * @param id
	 * @return
	 */
	public User get(Integer id) {
		return userMapper.get(id);
	}

	/**
	 * @return
	 */
	public List<User> findAll() {
		return userMapper.selectAll();
	}

}

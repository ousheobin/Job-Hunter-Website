package cn.gcu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gcu.dao.UserDao;
import cn.gcu.entity.UserEntity;
import cn.gcu.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	UserDao userDao;

	@Override
	@Transactional
	public void addUser(UserEntity user) {
		userDao.save(user);
	}

	@Override
	@Transactional
	public void deleteUser(UserEntity user) {
		userDao.delete(user);
	}

	@Override
	@Transactional
	public void updateUser(UserEntity user) {
		userDao.update(user);
	}

	@Override
	public UserEntity getUserById(String userId) {
		return userDao.get(userId);
	}

	@Override
	public UserEntity getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}

}

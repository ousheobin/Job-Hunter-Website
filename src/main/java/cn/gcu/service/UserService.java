package cn.gcu.service;

import cn.gcu.entity.UserEntity;

public interface UserService {
	
	public void addUser(UserEntity user);
	
	public void deleteUser(UserEntity user);
	
	public void updateUser(UserEntity user);
	
	public UserEntity getUserById(String userId);
	
	public UserEntity getUserByUserName(String userName);

}

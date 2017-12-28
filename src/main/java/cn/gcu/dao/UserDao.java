package cn.gcu.dao;

import cn.gcu.entity.UserEntity;

public interface UserDao extends BaseDao<UserEntity,String> {
	
	public UserEntity getUserByUserName(String userName);

}

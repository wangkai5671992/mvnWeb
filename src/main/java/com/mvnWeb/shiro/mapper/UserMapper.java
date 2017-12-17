package com.mvnWeb.shiro.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mvnWeb.shiro.model.Sys_user;

@Repository
public interface UserMapper {
	
	/**
	 * 查询所有用户
	 * @return 用户列表
	 */
	List<Sys_user> selectAll();
}

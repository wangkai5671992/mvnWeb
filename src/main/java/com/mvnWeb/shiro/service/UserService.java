package com.mvnWeb.shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvnWeb.shiro.mapper.UserMapper;
import com.mvnWeb.shiro.model.Sys_user;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	public Sys_user authenticate(Sys_user sys_user) {
		return userMapper.selectOne(sys_user);
	}
}

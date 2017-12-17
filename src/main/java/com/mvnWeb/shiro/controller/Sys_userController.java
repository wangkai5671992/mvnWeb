package com.mvnWeb.shiro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mvnWeb.shiro.mapper.UserMapper;
import com.mvnWeb.shiro.model.Sys_user;

@Controller
public class Sys_userController {
	@Autowired
	UserMapper userMapper;

	@RequestMapping("/userList")
	@ResponseBody
	public List<Sys_user> userList() {
		return userMapper.selectAll();
	}
}

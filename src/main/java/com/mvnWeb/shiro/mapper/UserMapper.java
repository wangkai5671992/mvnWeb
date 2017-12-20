package com.mvnWeb.shiro.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mvnWeb.shiro.model.Sys_user;

@Repository
public interface UserMapper {
	
	/**
	 * ��ѯ�����û�
	 * @return �û��б�
	 */
	List<Sys_user> selectAll();
	
	/**
	 * ��ѯ�����û�
	 * @param sys_user
	 * @return
	 */
	Sys_user selectOne(Sys_user sys_user);
}

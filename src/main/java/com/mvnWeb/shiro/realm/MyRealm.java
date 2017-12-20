package com.mvnWeb.shiro.realm;

import java.util.ArrayList;
import java.util.List;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.mvnWeb.shiro.model.Sys_user;
import com.mvnWeb.shiro.service.UserService;

public class MyRealm extends AuthorizingRealm {

	@Autowired
	UserService userServie;

	// 设置realm的名称
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	// 用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = String.valueOf(token.getPrincipal());
		String password = new String((char[]) token.getCredentials());
		final Sys_user authenticatedUser = userServie.authenticate(new Sys_user(username, password));
		if (authenticatedUser == null) {
			throw new AuthenticationException("用户名或密码错误");
		}
		return new SimpleAuthenticationInfo(username, password, this.getName());
	}

	// 用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		// 从 principals获取主身份信息
		// 将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
		// String userCode = (String) principals.getPrimaryPrincipal();

		// 根据身份信息获取权限信息
		// 连接数据库...
		// 模拟从数据库获取到数据
		List<String> permissions = new ArrayList<String>();
		permissions.add("user:create");// 用户的创建
		permissions.add("items:add");// 商品添加权限
		// ....

		// 查到权限数据，返回授权信息(要包括 上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		simpleAuthorizationInfo.addStringPermissions(permissions);

		return simpleAuthorizationInfo;
	}

}

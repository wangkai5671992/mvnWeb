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

	// ����realm������
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	// ������֤
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = String.valueOf(token.getPrincipal());
		String password = new String((char[]) token.getCredentials());
		final Sys_user authenticatedUser = userServie.authenticate(new Sys_user(username, password));
		if (authenticatedUser == null) {
			throw new AuthenticationException("�û������������");
		}
		return new SimpleAuthenticationInfo(username, password, this.getName());
	}

	// ������Ȩ
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		// �� principals��ȡ�������Ϣ
		// ��getPrimaryPrincipal��������ֵתΪ��ʵ������ͣ����ϱߵ�doGetAuthenticationInfo��֤ͨ����䵽SimpleAuthenticationInfo��������ͣ���
		// String userCode = (String) principals.getPrimaryPrincipal();

		// ���������Ϣ��ȡȨ����Ϣ
		// �������ݿ�...
		// ģ������ݿ��ȡ������
		List<String> permissions = new ArrayList<String>();
		permissions.add("user:create");// �û��Ĵ���
		permissions.add("items:add");// ��Ʒ���Ȩ��
		// ....

		// �鵽Ȩ�����ݣ�������Ȩ��Ϣ(Ҫ���� �ϱߵ�permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// ���ϱ߲�ѯ����Ȩ��Ϣ��䵽simpleAuthorizationInfo������
		simpleAuthorizationInfo.addStringPermissions(permissions);

		return simpleAuthorizationInfo;
	}

}

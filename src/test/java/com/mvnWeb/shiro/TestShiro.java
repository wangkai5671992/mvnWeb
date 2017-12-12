package com.mvnWeb.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class TestShiro {
	@Test
	public void testShiro() {
//		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
//		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-authenticator-all-success.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
			subject.login(token);
			System.out.println("登录成功");
			PrincipalCollection principalCollection = subject.getPrincipals();
			for (Object object : principalCollection.asList()) {
				System.out.println(object);
			}
		} catch (Exception e) {
			System.out.println("登录失败");
			e.printStackTrace();
		}
		subject.logout();
	}
}

package com.mvnWeb.shiro.authenticate;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class AuthenticationTest {
	@Test
	public void LoginAndOut() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhangsan", "123456");
		try {
			subject.login(usernamePasswordToken);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean authenticated = subject.isAuthenticated();
		System.out.println("是否验证通过====>" + authenticated);
		
		subject.logout();
		
		boolean authenticated2 = subject.isAuthenticated();
		System.out.println("是否验证通过====>" + authenticated2);
	}
}

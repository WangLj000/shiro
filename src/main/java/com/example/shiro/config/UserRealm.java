package com.example.shiro.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author Wanglongjiang
 * @version 1.0
 * @date 2023/10/2 8:47
 */
public class UserRealm extends SimpleAccountRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("doGetAuthenticationInfo 认证");
        UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
        String password = "123456";
        String username = "wang";
        if (!passwordToken.getUsername().equals(username))
            return null;// 抛出UnknownAccountException
        return new SimpleAuthenticationInfo("",password,"");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("doGetAuthenticationInfo");
        return null;
    }
}

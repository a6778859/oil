package com.oil.upms.client;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class MyShiro extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 登陆认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

//        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
//        //查出是否有此用户
//        User user=userService.findByName(token.getUsername());
//        if(user!=null){
//            //若存在，将此用户存放到登录认证info中
//            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
//        }
        return null;
    }
}

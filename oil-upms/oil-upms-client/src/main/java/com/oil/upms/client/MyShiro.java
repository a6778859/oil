package com.oil.upms.client;

import com.oil.upms.dao.model.Admin;
import com.oil.upms.rpc.api.UpmsApiService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class MyShiro extends AuthorizingRealm {
    @Autowired
    UpmsApiService upmsApiService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录时输入的用户名
        String loginName = (String) principalCollection.fromRealm(getName()).iterator().next();
        //到数据库查是否有此对象
        Admin user = upmsApiService.selectForUser(loginName);
        if (user != null) {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合
            Set<String> set = new HashSet<String>();
            set.add("admin");
            info.setRoles(set);
            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
            //      List<Role> roleList=user.getRoleList();
            // for (Role role : roleList) {
//            List<String> list2=new ArrayList<String>();
//            list2.add("1212")
//            info.addStringPermissions(user.getRoleId()+"");
            //   }
            return info;
        }
        return null;
    }

    /**
     * 登陆认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //UsernamePasswordToken对象用来存放提交的登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //查出是否有此用户
        Admin user = upmsApiService.selectForUser(token.getUsername());
        if (user == null) {
            throw new UnknownAccountException();
        }
        if (!user.getUserpassword().equals(String.valueOf(token.getPassword()))) {
            throw new UnknownAccountException();
        }
        if (user.getLockstate() != 1) {
            throw new LockedAccountException();
        }

        //若存在，将此用户存放到登录认证info中
        return new SimpleAuthenticationInfo(user.getUsername(), user.getUserpassword(), getName());


    }
}

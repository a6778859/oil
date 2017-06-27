<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
12121221
    <shiro:hasRole name="admin">admin角色登录显示此内容</shiro:hasRole>
        <shiro:hasRole name="admin2">admin2角色登录显示此内容</shiro:hasRole>
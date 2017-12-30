<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Java Jest Sample</title>
    <meta charset="utf-8" >
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/webapp/static/style/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/webapp/static/style/main.css"/>
</head>
<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a href='<spring:url value="/" htmlEscape="true"/>' class="brand">elasticsearch jest 简单例子</a>

            <div class="nav-collapse">
                <ul class="nav">
                    <li><a href='<spring:url value="/" htmlEscape="true"/>'>首页</a></li>
                    <li><a href='<spring:url value="/search/create" htmlEscape="true"/>'>创建索引</a></li>
                    <li><a href='<spring:url value="/about" htmlEscape="true"/>'>关于</a></li>
                </ul>
                <ul class="nav pull-right">
                    <li class="divider-vertical"></li>
                    <form action='<spring:url value="/search/search" htmlEscape="true"/>' method="get" class="navbar-search pull-left">
                        <input type="text" placeholder="Search" class="search-query span2" name="id">
                    </form>
                </ul>
            </div>
            <!-- /.nav-collapse -->
        </div>
    </div>
    <!-- /navbar-inner -->
</div>
<div class="container">


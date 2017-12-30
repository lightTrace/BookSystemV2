<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>添加图书</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>图书管理系统 - 添加图书</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li><a href="<%=appPath%>/book/list">首页</a></li>
                <li class="active"><a href="<%=appPath%>/book/detail/1003">图书具体信息</a></li>
                <li class="disabled"><a href="#">信息</a></li>
            </ul>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/add" method="POST">

            <P style="padding: 30px 0px 10px; position: relative;">
                <SPAN class="u_logo"></SPAN>
                <INPUT id="bookId" name="bookId" class="ipt" type="text"
                       placeholder="请输入书号" value="${book.bookId}">
            </P>
            <P style="position: relative;">
                <SPAN class="p_logo"></SPAN>
                <INPUT id="name" name="name" class="ipt" type="text"
                       placeholder="请输入书名" value="${book.name }">
            </P>
            <P style="position: relative;">
                <SPAN class="p_logo"></SPAN>
                <INPUT id="number" name="number" class="ipt" type="text"
                       placeholder="请输入书页数" value="${book.number }">
            </P>
            <P style="position: relative;">
                <SPAN class="p_logo"></SPAN>
                <INPUT id="detail" name="detail" class="ipt" type="text"
                       placeholder="请输入书描述" value="${book.detail }">
            </P>
            <DIV
                    style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
                <P style="margin: 0px 35px 20px 45px;">
                    <SPAN style="float: left;">图书管理系统</SPAN>
                    <span><font color="red" id="error">${errorInfo }</font></span>
                    <SPAN
                            style="float: right;">
						<input type="submit"
                               style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;"
                               value="添加" />
					</SPAN>
                </P>
            </DIV>
        </DIV>
    </form>
</div>

<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
</body>
</html>

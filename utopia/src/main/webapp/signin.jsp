<%@ page import="java.net.URLEncoder" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html lang="zh-CN">
<%
    String ret = request.getParameter("ret");
    if(StringUtils.isNotBlank(ret)) {
        ret = URLEncoder.encode(ret);
    } else {
        ret = "";
    }
%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/favicon.ico">

    <title>登录</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap3.3.5/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

	<%
		String name = "";		//装账号
		String password = "";		//装密码
		String check = "";		//选中状态
		//从客户端中取出对应的Cookie，装进文本框中！
		Cookie[] cookies = request.getCookies();//取出客户端所有的Cookie
		if(cookies != null && cookies.length > 0){
			//取出cookie中对应的账号和密码信息
			//cookie对象只提供单取键的方法：getName()
			//cookie对象只提供单取值的方法：getValues()
			for(int i = 0; i < cookies.length; i++){
				if("nameCookie".equals(cookies[i].getName())){
					name = cookies[i].getValue();
					check = "checked";
				}
				
				if("passwordCookie".equals(cookies[i].getName())){
					password = cookies[i].getValue();
				}
			}
		}
	%>
<body>


<div class="container">
    <form class="form-signin" action="/login.do?ret=<%=ret%>" method="post">
        <h2 class="form-signin-heading">请登录</h2>
        <label for="inputEmail" class="sr-only">用户名</label>
        <input type="text" id="inputEmail" class="form-control" placeholder="username" name="username" value="<%=name %>"/>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" value="<%=name %>"/>
        <input type="checkbox" name="rememberMe" value="111" id="rememberMe" <%=check %>/>七天免登录
        <br/>
        <br/>
       	 请输入验证码：<input type="text" name="code">
		<img src="ImgServlet" onclick="refresh(this)"/>
		<div class="checkbox" style="color: red;">${error}</div>
		<br>
		<button class="btn btn-lg btn-primary btn-block" type="submit">登 陆</button>
    </form>
</div>
	
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="js/ie10-viewport-bug-workaround.js"></script>
</body>

<script type="text/javascript">
	function refresh(element) {
		//加入随机数的目的为了避免因为缓存机制的原因，导致请求路径相同而页面不刷新的问题
		element.src = "ImgServlet?r=" + Math.random();
	}
</script>

</html>

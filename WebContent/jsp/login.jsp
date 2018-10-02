<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<%
    String path = request.getContextPath();
   
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
 <base href=" <%=basePath%>">
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />

<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />

<!--[if IE]>
<script src="js/html5.jsp"></script>
<![endif]-->
<style type="text/css">
 
</style>
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>欢迎你
						    <% String str=(String) request.getAttribute("msg");
						   if(str!=null){
						%>
						    <%=str %>
						    <%} %> 
						</h3>
						<form action="UserServlet" method= "post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="uname" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="psw" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="reg"> 
							  <a  class="a1" href="jsp/register.jsp">注册</a>
							</div>
							<div class="mb2"><a class="act-but submit" href="javascript:document.forms[0].submit();" style="color: #FFFFFF">登录</a></div>

						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
		<script src="js/demo-1.js"></script>
	
	</body>
</html>
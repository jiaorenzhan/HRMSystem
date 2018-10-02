<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String path = request.getContextPath();
 String basePath =request.getScheme() + "://" +request.getServerName()+":" +request.getServerPort()
         + path +"/";

%>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
 <base href=" <%=basePath%>">
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
						<form action="RegisterServlet" method= "post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="uname" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="psw" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>						
							<div class="mb2"><input class="in" type="submit" value ="注册"></<input></div>
							
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
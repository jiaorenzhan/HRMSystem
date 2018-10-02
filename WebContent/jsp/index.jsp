<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   
<html>
	
	<head>
 <%
    String path = request.getContextPath();
   
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
 <base href=" <%=basePath%>">
		<title>首页</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>

	<body>
		<!-- 页面头部 -->
		
<table width="950" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="80" bgcolor="#FFFFFF">
			<img src="img/bannal.jpg" width="950"
				height="80">
		</td>
	</tr>
	<tr>
		<td height="24" align="right" bgcolor="#FFFFFF">
			<a href="jsp/index.jsp">首页</a>
			<a href="DeptViewServlet">部门查询</a>
			<a href="JobsViewServlet">职务查询</a>
			<a href="EmpViewServlet">员工查询</a>			
			<a href="logout.jsp">退出登陆</a> </td>
	</tr>
	<tr>
		<td height="24" align="right" bgcolor="#0099CC">
			当前用户：admin 身份：
			
				管理员
			
			
		</td>
	</tr>
</table>

		<!-- 页面内容 -->
		<table border="0" width="950" height="350" bgcolor="#ffffff" align="center">
			<tr>
				<td align="center">
					您已经登陆到XXX人力资源管理系统，请使用
				</td>
			</tr>
		</table>

		<!-- 页面底部 -->
		
<table width="950" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td><hr></td>
  </tr>
  <tr>
    <td align="center">©版权所有</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
	</body>
</html>
<%@page import="java.util.List"%>
<%@page import="javaBean.Jobs"%>
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
		<title>职务数据</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<script type="text/javascript">
			//****************-删除确认***************
			function del(job_id) {
				//弹出确认框
				var flag = window.confirm("你确定要删除" + job_id + "号职务吗?");
								
				//如果单击确定，则执行DelJobsServlet，并且传入职务编号
				if (flag) {
					alert("删除成功");
					location.href = "JobsViewServlet.html";
				}
			}
		</script>
	</head>

	<body>
	<%
	    List<Jobs> list=(List<Jobs>) request.getAttribute("cro");
	%>
		<!-- 页面头部 -->
		<table width="950" border="0" align="center" cellpadding="0"
	cellspacing="0">
          <tr>
            <td height="80" bgcolor="#FFFFFF"><img src="img/bannal.jpg" width="950"
				height="80"> </td>
          </tr>
          <tr>
            <td height="24" align="right" bgcolor="#FFFFFF">
            <a href="jsp/index.jsp">首页</a> 
            <a href="DeptViewServlet">部门查询</a> 
            <a href="JobsViewServlet">职务查询</a> 
            <a href="EmpViewServlet">员工查询</a> <a href="jsp/logout.jsp">退出登陆</a> </td>
          </tr>
          <tr>
            <td height="24" align="right" bgcolor="#0099CC"> 当前用户：admin 身份：
              
              管理员 </td>
          </tr>
        </table>
		<!-- 页面内容 -->
		<table border="0" width="950" height="350" bgcolor="#ffffff"
			align="center">
			
			<tr>
				<td align="center" valign="top">
					<table width="90%" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						<tr>
							<th width="16%" height="24" align="center" bgcolor="#FFCC00">
								职务编号
							</th>
							<th width="21%" height="24" align="center" bgcolor="#FFCC00">
								职务名称
							</th>
							<th width="23%" height="24" align="center" bgcolor="#FFCC00">
								最低工资
							</th>
							<th width="24%" height="24" align="center" bgcolor="#FFCC00">
								最高工资
							</th>
							<th width="16%" height="24" align="center" bgcolor="#FFCC00">
								操作
							</th>
						</tr>

						<!-- 显示职务数据 -->
				     		<% 
		             	for(Jobs s: list){
		                	%>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getJid() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getJname() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									￥<%=s.getMinwage() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									￥<%=s.getMaxwage() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<a href="FindJobsByName?jid=<%=s.getJid()%>">修改</a>
									<a href="DeleteJobServlet?jid=<%=s.getJid()%>">删除</a>								</td>
							</tr>
						
						
							<%} %>
						
					</table>
					<p>
						<a href="jsp/AddJobs.jsp">增加新职务种类</a>					</p>
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
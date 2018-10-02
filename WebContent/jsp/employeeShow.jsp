<%@page import="javaBean.Employee"%>
<%@page import="java.util.List"%>
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
		<title>员工数据</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<script type="text/javascript">
			//****************-删除确认***************
			function del(employee_id) {
				//弹出确认框
				var flag = window.confirm("你确定要删除" + employee_id + "号员工吗?");
				//如果单击确定，则执行DelEmpServlet，并且传入员工编号
				if (flag) {
					alert("删除成功");
					location.href = "EmpViewServlet.html";
				}
			}
		</script>
	</head>

	<body>
	<%
	   List<Employee> list = ( List<Employee>)  request.getAttribute("cro");
	%>
		<!-- 页面头部 -->
		<table width="950" border="0" align="center" cellpadding="0"
	cellspacing="0">
          <tr>
            <td height="80" bgcolor="#FFFFFF"><img src="img/bannal.jpg" width="950"
				height="80"> </td>
          </tr>
          <tr>
            <td height="24" align="right" bgcolor="#FFFFFF"><a href="jsp/index.jsp">首页</a> <a href="DeptViewServlet">部门查询</a>
             <a href="JobsViewServlet">职务查询</a> 
             <a href="EmpViewServlet">员工查询</a> 
             <a href="jsp/logout.jsp">退出登陆</a> </td>
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
					<table width="98%" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						<tr>
							<td width="7%" height="24" bgcolor="#FFCC00">
								员工编号
							</td>
							<td width="11%" height="24" bgcolor="#FFCC00">
								员工姓名
							</td>
							<td width="16%" height="24" bgcolor="#FFCC00">
								邮箱
							</td>
							<td width="16%" height="24" bgcolor="#FFCC00">
								电话
							</td>
							<td width="12%" height="24" bgcolor="#FFCC00">
								入职时间
							</td>
							<td width="9%" height="24" bgcolor="#FFCC00">
								职务
							</td>
							<td width="9%" height="24" bgcolor="#FFCC00">
								工资
							</td>
							<td width="7%" height="24" bgcolor="#FFCC00">
								部门
							</td>
							<td width="13%" height="24" bgcolor="#FFCC00">
								操作
							</td>
						</tr>
							<%
		                for(Employee s: list){ 
	 	                   %>
	 						<tr>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getEid() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
								    <%=s.getEname() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getEmail() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getTel() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getEdate() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getJob() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getWage() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=s.getDepart() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<a href="FindEmpById?eid=<%=s.getEid()%>">修改</a>
									<a href="DeleteEmpServlet?eid=<%=s.getEid()%>">删除</a>
									<a href="PhotoViewServlet" target="_blank">照片</a>								</td>
							</tr>
						<%
						}%>
							
					</table>

					<!-- 分页显示用界面 -->
					<table width="95%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="24" align="center">
								共4条数据，每页显示9条，
								共1页，当前是第1页
							</td>
						</tr>
						<tr>
							<td height="24" align="center">
								<a href="?pagenum=1">首页</a>
								<a href="?pagenum=0">上页</a>
								<a href="?pagenum=2">下页</a>
								<a href="?pagenum=1">末页</a>
							</td>
						</tr>
						<tr>
							<td height="24" align="center">
								
									
									
										<font color="red"><b>1</b>
										</font>
									
								
							</td>
						</tr>
					</table>
					<p>
						<a href="jsp/AddEmp.jsp">增加新员工</a>					</p>
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
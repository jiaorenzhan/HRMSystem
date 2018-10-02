<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
    String path = request.getContextPath();
   
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
 <base href=" <%=basePath%>">
<script type="text/javascript">
	var num = 10;

	function jump(){
		num --;
		var s1 = document.getElementById("s1");
		s1.innerHTML = num;		
		if (num <= 0)
			location.href = "jsp/login.jsp";		
	}

	window.setInterval("jump()",1000);
</script>
<p>
已经退出当前登陆，<span id="s1">10</span>秒后跳转到登陆页
<a href="jsp/login.jsp">单击此处到登陆页</a>
</p>
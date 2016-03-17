<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <base href="<%=basePath%>">
    
    <title>管理员注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/style.css">
<script language="javascript">
function check(form)
{
	if (form.username.value=="")
    {
        alert("请填写用户名");
        form.username.focus();
        return false;
    }
    if (form.password.value.length<2)
    {
        alert("密码不能少于2个字符");
        form.password.focus();
        return false;
    }
    if (form.password.value!=form.repassword.value)
    {
        alert("两次密码不同");
        form.repassword.focus();
        return false;
    }
	
	}

</script>

  </head>
  
<body style="text-align:center">
<div id="body">
 <div id="header">

  <h1>禹州市神安运输有限公司</h1>

  </div>
  <div id="left"> </div>
  <div id="right">
	<!-- 提交请求参数的表单 -->
   
	<form name ="form1" action="register.action" method="post"
	 onsubmit="return check(form1)">
		<table align="center" id="table">
	<tr>
		<td><img alt="" src="img/login2.png"></td>
			
				<td>管理员注册</td>
		</tr>
			<tr>
				<!-- 用户名的表单域 -->
					<td>用户名：</td>
					<td><input type="text"   name="username" />
				</td>
			</tr>
			<tr>
				<!-- 密码的表单域 -->
				<td>密&nbsp;&nbsp;码：</td><td><input type="password"  name="password" />
				</td>
			</tr>
		<tr>
				<!-- 密码的表单域 -->
				<td>确认密码：</td><td><input type="password" name="repassword" />
				</td>
			</tr>
			<!-- 验证的表单域 
			<tr>
				
				<td>验证码：</td><td><input type="text" class="loginform_input_validationCode" name="validationCode"  />
				<img class="validationCode_img" src="/ValidationCode" >
				</td>
			</tr>-->
		
			<tr align="center">
			<td></td>
				<td align="center">
				<input type="submit"   value="确认" />
				<input type="reset"  value="重置" /></td>
		</tr>
		</table>
	</form>
		</div>
		</div>
  </body>
</html>

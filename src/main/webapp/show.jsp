<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>禹州市神安运输有限公司</title>
    <style type="text/css">
    	table {
			border-collapse: collapse;
		}
    </style>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  <script>
function openWin(url,width,height){
var phxWin=window.open(url,'','width='+width+',height='+height+'');
phxWin.moveTo((screen.width-width)/2,(screen.height-height)/2);
window.opener.location.reload();
window.close();
}
</script>
  </head>
  
<body style="text-align:center">
<div id="body">
<div id="header-2"> <a href="showuser.action">运输信息管理</a>
&nbsp;&nbsp;<a href="index.jsp">首页</a>
</div>
 <div id="header-1">



   
  <h1>禹州市神安运输有限公司</h1>


  
  </div>
  <div id="left"> </div>
  <div id="right">
    <form >
    <table align="center" id="table1">
    	<tr bgcolor="#cccc00">
    		<td align="center">编号</td>
    		<td align="center">管理员</td>
    		<td align="center">密码</td>
    		<td colspan="2" align="center">操作</td>
    	</tr>
    	<s:iterator value="userlist" >
    	<tr>
    		<td align="center"><s:property value="id" /></td>
    		<td align="center"><s:property value="username" /></td>
    		<td align="center">&nbsp;<s:property value="password" /></td>
    		<td align="center">
    		<a href="#" onClick="openWin('update.jsp?id=<s:property value='id' />&username=<s:property value='username'/>',400,300)" >
    		修改账号
    		</a></td>
    		<td align="center"><a href="delete.action?id=<s:property value='id' />" onclick="return confirm('您确定删除吗？')">删除账号</a></td>
    	</tr>
    	</s:iterator>
    </table>
    </form>
    
    </div>
 </div>
  </body>
</html>

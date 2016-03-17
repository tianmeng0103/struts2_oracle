<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
<link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
<body style="text-align:center">
<div id="body">
<div id="header-2"> <a href="show.action">账号管理中心</a>
&nbsp;&nbsp;<a href="index.jsp">首页</a></div>
 <div id="header-1">


  <h1>禹州市神安运输有限公司</h1>

  </div>
  
   <div id="left"> </div>
  <div id="right">
  <a href="add.jsp">添加车主信息</a>
  
   <form action="">
    <table align="center" id="table2">
    	<tr bgcolor="#cccc00">
    		<td align="center">编号</td>
    		<td align="center">车主姓名</td>
    		<td align="center">车牌号</td>
    		<td align="center">发动机号</td>
    		<td align="center">车架号</td>
    		<td align="center">入户时间</td>
    		<td align="center">车型</td>
    		<td align="center">车长</td>
    		<td align="center">险种</td>
    		<td align="center">保险公司</td>
    		<td align="center">保险截止日期</td>
    		<td align="center">状态</td>
    		<td align="center">下次二维</td>
    		<td align="center">状态</td>
    		<td align="center">营运证审验时间</td>
    		<td align="center">状态</td>
    		<td align="center">行车证审验时间</td>
    		<td align="center">状态</td>
    		<td align="center">联系电话</td>
    		<td colspan="2" align="center">操作</td>
    	</tr>
    	<s:iterator value="userlist" >
    	<tr>
    		<td align="center"><s:property value="id" /></td>
    		<td align="center"><s:property value="username" /></td>
    		<td align="center"><s:property value="carnumber" /></td>
    		<td align="center"><s:property value="enginenumber" /></td>
    		<td align="center"><s:property value="framenumber" /></td>
    		<td align="center"><s:property value="registerdate" /></td>
    		<td align="center"><s:property value="cartype" /></td>
    		<td align="center"><s:property value="carlength" /></td>
    		<td align="center"><s:property value="insurance" /></td>
    		<td align="center"><s:property value="insurancefirm" /></td>
    		<td align="center"><s:property value="cutoffdate" /></td>
    		<td align="center"><s:property value="cutoffstatus" /></td>
    		<td align="center"><s:property value="nextservicedate" /></td>
    		<td align="center"><s:property value="nextservicestatus" /></td>
    		<td align="center"><s:property value="licensedate" /></td>
    		<td align="center"><s:property value="licensestatus" /></td>
    		<td align="center"><s:property value="drivelicensedate" /></td>
    		<td align="center"><s:property value="drivelicensestatus" /></td>
    		<td align="center"><s:property value="phone" /></td>
    		<td align="center"><a href="updateuser.jsp?id=<s:property value='id' />
    		&username=<s:property value='username'/>" >修改账号</a></td>
    		<td align="center"><a href="deleteuser.action?id=<s:property value='id' />" onclick="return confirm('您确定删除吗？')">删除账号</a></td>
    	</tr>
    	</s:iterator>
    </table>
    </form>
  
  
  
  </div>
  
  
  
    </div>
  </body>
</html>

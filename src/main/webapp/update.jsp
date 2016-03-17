<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>update.jsp</title>
<script type="text/javascript">
function tijiao(){
	window.dialogArguments.window.location = window.dialogArguments.window.location; 
	self.close();
}
</script>
  </head>
  
  <body>
    <s:form action="update" method="post" id="myform">
    	<s:hidden name="id" value="%{#parameters.id}" />
		<s:textfield name="username" label="UserName" value="%{#parameters.username}"/>
		<s:password name="password" label="Password" />
		<s:submit value="更新" method="update" onclick="tijiao()"/>
    </s:form>
  </body>
</html>

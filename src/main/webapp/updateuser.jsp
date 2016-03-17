<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加车主信息</title>
       <script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
    
  </head>
  
  <body>
 <form  action="updateuser.action" method="post">
		<table align="center" >
	<tr>
		<td></td>
			
				<td>车主姓名：</td><td><s:hidden name="id" value="%{#parameters.id}" />
	       	<s:textfield name="username"  value="%{#parameters.username}"/>
				</td>
		</tr>
			<tr>
				
				<td>车牌号码：：</td><td><input type="text" name="carnumber" />
				</td>
			</tr>
			<tr>
				
				<td>发动机号：</td><td><input type="text" name="enginenumber" />
				</td>
			</tr>
		 	<tr>
				
				<td>车架号：</td><td><input type="text" name="framenumber" />
				</td>
			</tr>
		 
		 	<tr>
				
				<td>入户时间：</td><td><input class="Wdate" type="text" onClick="WdatePicker()" width='270px' name="registerdate" />
				</td>
			</tr>
		 <tr>
				
				<td>车型：</td><td><input type="text" name="cartype" />
				</td>
			</tr>
		 
		 	<tr>
				
				<td>车长：</td><td><input type="text" name="carlength" />
				</td>
			</tr>
		 
		 	<tr>
				
				<td>险种：</td><td><input type="text" name="insurance"/>
				</td>
			</tr>
		 
		 	<tr>
				
				<td>保险公司：</td><td><input type="text" name="insurancefirm" />
				</td>
			</tr>
		 
		 	<tr>
				
				<td>保险截止日期：</td><td><input class="Wdate" type="text" onClick="WdatePicker()" width='270px' name="cutoffdate" />
				</td>
			</tr>
		 
		 	<tr>
				
				<td>下次二维日期：</td><td><input class="Wdate" type="text" onClick="WdatePicker()" width='270px'name="nextservicedate" />
				</td>
			</tr>
		 
		 
		 	<tr>
				
				<td>营运证审验日期：</td><td><input class="Wdate" type="text" onClick="WdatePicker()" width='270px' name="licensedate" />
				</td>
			</tr>
				<tr>
				
				<td>行车证审验日期：</td><td><input class="Wdate" type="text" onClick="WdatePicker()" width='270px'  name="drivelicensedate"  />
				</td>
			</tr>
				<tr>
				
				<td>手机号码：</td><td><input type="text" name="phone"/>
				</td>
		
			<tr align="center">
			<td></td>
				<td align="center"><input type="submit" value="更新"
					name="method:update1" />
					<input  type="reset"  value="重置"/>
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>
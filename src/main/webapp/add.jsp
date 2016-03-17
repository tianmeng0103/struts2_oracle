<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>


  <head>
 
    <script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>

   
   <script language="javascript">
function check(form)
{
	if (form.username.value=="")
    {
        alert("请填写用户名");
        form.username.focus();
        return false;
    }
    if (form.carnumber.value.length<6)
    {
        alert("车牌号不能少于6位");
        form.carnumber.focus();
        return false;
    }
    if (form.enginenumber.value=="")
    {
        alert("发动机号不能为空");
        form.enginenumber.focus();
        return false;
    }
    if (form.framenumber.value.length!=17)
    {
        alert("车架号不等于17位！！");
        form.framenumber.focus();
        return false;
    }
    if (form.cartype.value=="")
    {
        alert("车型不能为空");
        form.cartype.focus();
        return false;
    }
    if (form.carlength.value=="")
    {
        alert("车长不能为空");
        form.carlength.focus();
        return false;
    }
    if (form.phone.value.length!=11)
    {
        alert("手机号不等于11位");
        form.phone.focus();
        return false;
    }
    if (form.cutoffdate.value=="")
    {
        alert("保险截止时间不能为空");
        form.cutoffdate.focus();
        return false;
    }
    if (form.licensedate.value=="")
    {
        alert("营运证验审时间不能为空");
        form.licensedate.focus();
        return false;
    }
 
    if (form.nextservicedate.value=="")
    {
        alert("二维时间不能为空");
        form.nextservicedate.focus();
        return false;
    }
    if (form.drivelicensedate.value=="")
    {
        alert("行车证验审时间不能为空");
        form.drivelicensedate.focus();
        return false;
    }
	}

</script>
   
    <title>添加车主信息</title>
  </head>
  
  <body>
 <form name="form1" action="adduser.action" method="post" onsubmit="return check(form1)">
		<table align="center" >
	<tr>
	
			
				<td>车主姓名：</td><td><input type="text" name="username"  />
				</td>
		</tr>
			<tr>
				
				<td>车牌号码：</td><td><input type="text" name="carnumber"  />
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
				
				<td>入户时间：</td><td> <input class="Wdate" type="text" onClick="WdatePicker()" width='270px' name="registerdate">
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
				
				<td>险种：</td><td><input type="text" name="insurance" />
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
				
				<td>下次二维日期：</td><td><input class="Wdate" type="text" onClick="WdatePicker()" width='270px' name="nextservicedate" />
				</td>
			</tr>
		 
		 
		 	<tr>
				
				<td>营运证审验日期：</td><td><input class="Wdate" type="text" onClick="WdatePicker()" width='270px' name="licensedate" />
				</td>
			</tr>
				<tr>
				
				<td>行车证审验日期：</td><td><input class="Wdate" type="text" onClick="WdatePicker()" width='270px' name="drivelicensedate" />
				</td>
			</tr>
				<tr>
				
				<td>手机号码：</td><td><input type="text" name="phone" />
				</td>
			</tr>
			
		 
			<tr align="center">
			<td></td>
				<td align="center"><input type="submit" value="添加"/>
					<input  type="reset"  value="重置"/>
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>
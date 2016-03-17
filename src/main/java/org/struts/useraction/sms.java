package org.struts.useraction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.TimerTask;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
//import org.struts.beans.UserBean;

import com.sina.sae.util.SaeUserInfo;

public class sms extends TimerTask{
	
	   /**
		 * 建立数据库连接
		 * 
		 * @return
		 */
		private static Connection getConn() {
			/*String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String username1 = "scott";
			String password = "19910103";
			Connection conn = null;
			try {
				Class.forName(driver);
				// new oracle.jdbc.driver.OracleDriver();
				conn = DriverManager.getConnection(url, username1, password);
				// log.info("connect success");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
*/
			String url = "jdbc:mysql://localhost:3306/test";	 // 数据库连接字符串
			String username = "root";	 // 数据库用户名
			String password = "1991";
//			String url ="jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_shenanmsg";
//			String username = SaeUserInfo.getAccessKey();
//		 // 数据库用户名
//			String password = SaeUserInfo.getSecretKey();

			Connection conn = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");	 // 加载数据库驱动，注册到驱动管理器
					 // 数据库密码
			 conn = DriverManager.getConnection(url,username,password);
				// 创建Connection连接
				// 判断数据库连接是否为空
				if(conn != null){
				System.out.println("数据库连接成功！");	 // 输出连接信息
			//	conn.close();	 // 关闭数据库连接
				}else{
				System.out.println("数据库连接失败！");	 // 输出连接信息
				}
				} catch (ClassNotFoundException e) {
				e.printStackTrace();
				} catch (SQLException e) {
				e.printStackTrace();
				}
			return conn;
		}

	
		
	  @Override  
	    public void run(){  
	        // TODO Auto-generated method stub  
		  Connection conn = getConn();
			String sql = "SELECT * FROM USERS ORDER BY id";
			PreparedStatement pstmt;
			
		
			  
			try {
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
				
					int i=rs.getInt("id");
					String name=rs.getString("username");
					Date cutoffdate=rs.getDate("cutoffdate");
					Date nextservicedate =rs.getDate("nextservicedate");
					Date licensedate =rs.getDate("licensedate");
					Date drivelicensedate=rs.getDate("drivelicensedate");
					String phone=rs.getString("phone");
					String status1=rs.getString("cutoffstatus");
					String status2=rs.getString("nextservicestatus");
					String status3=rs.getString("licensestatus");
					String status4=rs.getString("drivelicensestatus");
					// System.out.println("cutoffdate"+cutoffdate.getTime());
					// System.out.println(System.currentTimeMillis());
					Calendar now = Calendar.getInstance();
					Calendar cld = Calendar.getInstance();
					System.out.println("年: " + now.get(Calendar.YEAR));  
			        System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + ""); 
			        cld.setTime(cutoffdate);
			    	System.out.println("年："+cld.get(Calendar.YEAR));
					System.out.println("月："+(cld.get(Calendar.MONTH)+1));
					 System.out.println(status1);
					if(status1.equals("0"))
					{
						if((now.get(Calendar.YEAR)==cld.get(Calendar.YEAR))&&(now.get(Calendar.MONTH) + 1==cld.get(Calendar.MONTH)+1))
						{
							
							//sendsms1(name,phone,cutoffdate);
							//String statu="1";
							String sql1="update users set cutoffstatus ='0' where id='"+ i + "'";
							PreparedStatement pstmt1;
							try {
								pstmt1= conn.prepareStatement(sql1);
					            //System.out.println(registerdate);
								int j = pstmt1.executeUpdate();
								System.out.println("update resutl: " + j);

								pstmt1.close();
								//conn.close();
								}
							catch (SQLException e) {
								e.printStackTrace();}
							
							
							
						}
						else {
							
							 System.out.println("短信发送失败！");
						}
					}else { System.out.println("status！");}
					
					
					if(status2=="0")
					{
						if(System.currentTimeMillis()==(nextservicedate.getTime()-1000*60*60*24*15))
						{
							
							//sendsms2(name,phone,nextservicedate);
							
							String sql2="update users set nextservicestatus = '1' where id='"+ i + "'";
							PreparedStatement pstmt1;
							try {
								pstmt1 = conn.prepareStatement(sql2);
					            //System.out.println(registerdate);
								int j = pstmt1.executeUpdate();
								System.out.println("update result2: " + j);

								pstmt1.close();
								//conn.close();
								}
							catch (SQLException e) {
								e.printStackTrace();}
							
						}
					}
					if(status3=="0")
					{
						if(System.currentTimeMillis()==(licensedate.getTime()-1000*60*60*24*15))
						{
							
						//	sendsms3(name,phone,licensedate);
							
							String sql3="update users set licensestatus = '1' where id='"+ i + "'";
							PreparedStatement pstmt1;
							try {
								pstmt1 = conn.prepareStatement(sql3);
					            //System.out.println(registerdate);
								int j = pstmt1.executeUpdate();
								System.out.println("update resut3: " + j);

								pstmt1.close();
								//conn.close();
								}
							catch (SQLException e) {
								e.printStackTrace();}
							
						}
					}
					if(status4=="0")
					{
						if(System.currentTimeMillis()==(drivelicensedate.getTime()-1000*60*60*24*15))
						{
					//sendsms4(name,phone,drivelicensedate);
							
							String sql4="update users set drivelicensestatus = '1' where id='"+ i + "'";
							PreparedStatement pstmt1;
							try {
								pstmt1 = conn.prepareStatement(sql4);
					            //System.out.println(registerdate);
								int j = pstmt1.executeUpdate();
								System.out.println("update result4: " + j);

								pstmt1.close();
								//conn.close();
								}
							catch (SQLException e) {
								e.printStackTrace();}
							
							
						}
					}
					
				}
				} catch (SQLException e) {
					e.printStackTrace();
				} /*catch (HttpException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
			  
	     try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	          
	         } 
	public void sendsms1(String username,String phone,Date cutoffdate) throws HttpException, IOException
	{
		
		
	HttpClient client = new HttpClient();
	PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn"); 
	post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
	NameValuePair[] data1 ={ new NameValuePair("Uid", "tianmeng"),
			                new NameValuePair("Key", "b832bffbe38f2e344fe7"),
	                        new NameValuePair("smsMob",phone),
	                        new NameValuePair("smsText","亲爱的'"+username+"'，您的保险'"+cutoffdate+"' 就到期了")};
	
	post.setRequestBody(data1);
	
	client.executeMethod(post);
	Header[] headers = post.getResponseHeaders();
	int statusCode = post.getStatusCode();
	System.out.println("statusCode:"+statusCode);
	for(Header h : headers)
	{
	System.out.println(h.toString());
	}
	String result = new String(post.getResponseBodyAsString().getBytes("utf-8")); 
	System.out.println(result); //打印返回消息状态


	post.releaseConnection();}
	public void sendsms2(String username,String phone,Date nextservicedate) throws HttpException, IOException
	{
		
		
	HttpClient client = new HttpClient();
	PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn"); 
	post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
	
	NameValuePair[] data2 ={ new NameValuePair("Uid", "tianmeng"),
            new NameValuePair("Key", "b832bffbe38f2e344fe7"),
            new NameValuePair("smsMob",phone),
            new NameValuePair("smsText","亲爱的'"+username+"'，您的下次二维时间 '"+nextservicedate+"' 快到了")};

	post.setRequestBody(data2);

	
	client.executeMethod(post);
	Header[] headers = post.getResponseHeaders();
	int statusCode = post.getStatusCode();
	System.out.println("statusCode:"+statusCode);
	for(Header h : headers)
	{
	System.out.println(h.toString());
	}
	String result = new String(post.getResponseBodyAsString().getBytes("utf-8")); 
	System.out.println(result); //打印返回消息状态


	post.releaseConnection();}
	public void sendsms3(String username,String phone,Date licensedate) throws HttpException, IOException
	{
		
		
	HttpClient client = new HttpClient();
	PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn"); 
	post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码

	NameValuePair[] data3 ={ new NameValuePair("Uid", "tianmeng"),
            new NameValuePair("Key", "b832bffbe38f2e344fe7"),
            new NameValuePair("smsMob",phone),
            new NameValuePair("smsText","亲爱的'"+username+"'，您的营运证审验日期'"+licensedate+"' 快到了")};

	post.setRequestBody(data3);

	client.executeMethod(post);
	Header[] headers = post.getResponseHeaders();
	int statusCode = post.getStatusCode();
	System.out.println("statusCode:"+statusCode);
	for(Header h : headers)
	{
	System.out.println(h.toString());
	}
	String result = new String(post.getResponseBodyAsString().getBytes("utf-8")); 
	System.out.println(result); //打印返回消息状态


	post.releaseConnection();}
	public void sendsms4(String username,String phone,Date drivelicensedate) throws HttpException, IOException
	{
		
		
	HttpClient client = new HttpClient();
	PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn"); 
	post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
	
	NameValuePair[] data4 ={ new NameValuePair("Uid", "tianmeng"),
            new NameValuePair("Key", "b832bffbe38f2e344fe7"),
            new NameValuePair("smsMob",phone),
            new NameValuePair("smsText","亲爱的'"+username+"'，您的行车证审验日期'"+drivelicensedate+"' 快到了")};
	
	post.setRequestBody(data4);
	
	client.executeMethod(post);
	Header[] headers = post.getResponseHeaders();
	int statusCode = post.getStatusCode();
	System.out.println("statusCode:"+statusCode);
	for(Header h : headers)
	{
	System.out.println(h.toString());
	}
	String result = new String(post.getResponseBodyAsString().getBytes("utf-8")); 
	System.out.println(result); //打印返回消息状态


	post.releaseConnection();}
}

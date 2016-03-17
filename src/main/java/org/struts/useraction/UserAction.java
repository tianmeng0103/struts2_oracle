package org.struts.useraction;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.struts.beans.AdminBean;
import org.struts.beans.UserBean;


import com.opensymphony.xwork2.ActionSupport;
import com.sina.sae.util.SaeUserInfo;

public class UserAction extends ActionSupport {

	private static Log log = LogFactory.getLog(UserAction.class);

	private int id;
	private String username;
	private String carnumber;
	private String enginenumber;
	private String framenumber;
	private  Date registerdate;
	private String cartype;
	private String carlength;
    private String insurance;
    private String insurancefirm;
   
	private Date cutoffdate;
    private Date nextservicedate;
    private Date licensedate;
    private Date drivelicensedate;
    private String phone;

    private String cutoffstatus;
    private String nextservicestatus;
    private String licensestatus;
    private String drivelicensestatus;
    
	


	private List<UserBean> userlist;




public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}



public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}


	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getEnginenumber() {
		return enginenumber;
	}

	public void setEnginenumber(String enginenumber) {
		this.enginenumber = enginenumber;
	}

	public String getFramenumber() {
		return framenumber;
	}

	public void setFramenumber(String framenumber) {
		this.framenumber = framenumber;
	}

	public Date getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public String getCarlength() {
		return carlength;
	}

	public void setCarlength(String carlength) {
		this.carlength = carlength;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public Date getCutoffdate() {
		return cutoffdate;
	}

	public void setCutoffdate(Date cutoffdate) {
		this.cutoffdate = cutoffdate;
	}
	 public String getInsurancefirm() {
			return insurancefirm;
		}

		public void setInsurancefirm(String insurancefirm) {
			this.insurancefirm = insurancefirm;
		}

	public Date getNextservicedate() {
		return nextservicedate;
	}

	public void setNextservicedate(Date nextservicedate) {
		this.nextservicedate = nextservicedate;
	}

	public Date getLicensedate() {
		return licensedate;
	}

	public void setLicensedate(Date licensedate) {
		this.licensedate = licensedate;
	}

	public Date getDrivelicensedate() {
		return drivelicensedate;
	}

	public void setDrivelicensedate(Date drivelicensedate) {
		this.drivelicensedate = drivelicensedate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCutoffstatus() {
		return cutoffstatus;
	}

	public void setCutoffstatus(String cutoffstatus) {
		this.cutoffstatus = cutoffstatus;
	}

	public String getNextservicestatus() {
		return nextservicestatus;
	}

	public void setNextservicestatus(String nextservicestatus) {
		this.nextservicestatus = nextservicestatus;
	}

	public String getLicensestatus() {
		return licensestatus;
	}

	public void setLicensestatus(String licensestatus) {
		this.licensestatus = licensestatus;
	}

	public String getDrivelicensestatus() {
		return drivelicensestatus;
	}

	public void setDrivelicensestatus(String drivelicensestatus) {
		this.drivelicensestatus = drivelicensestatus;
	}





	public List<UserBean> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<UserBean> userlist) {
		this.userlist = userlist;
	}

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
		}*/
		String url = "jdbc:mysql://localhost:3306/test";	 // 数据库连接字符串
		String username = "root";	 // 数据库用户名
		String password = "1991";
//		String url ="jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_shenanmsg";
//		String username = SaeUserInfo.getAccessKey();
//	 // 数据库用户名
//		String password = SaeUserInfo.getSecretKey();

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

	/**
	 * 用户名与密码匹配检查
	 * 
	 * @return 结果标识 字符串 success 表示匹配成功 UserNotExist表示用户不存在 error 表示匹配失败
	 */
	

	/*private UserBean query(int id) {
		log.info("my query...");
		Connection conn = getConn();
		String sql = "select * from users where id='" + id + "'";
		PreparedStatement pstmt;
		UserBean user = new UserBean();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setId(id);
				user.setUsername(rs.getString("username"));
				user.setCarnumber(rs.getString("carnumber"));
				user.setEnginenumber(rs.getString("enginenumber")); 
				user.setFramenumber(rs.getString("framenumber"));  
				user.setRegisterdate(rs.getDate("registerdate")); 
			    user.setCartype(rs.getString("cartype"));	
			    user.setCarlength(rs.getString("carlength"));
				user.setInsurance(rs.getString("insurance"));
				user.setInsurance(rs.getString("insurancefirm"));
			    user.setCutoffdate(rs.getDate("cutoffdate"));
			    user.setNextservicedate(rs.getDate("nextservicedate"));
			    user.setLicensedate(rs.getDate("licensedate"));
			    user.setDrivelicensedate(rs.getDate("drivelicensedate"));
			    user.setPhone(rs.getString("phone"));
			
				System.out.println("myquery: name: " + rs.getString("username")
						);
			}

			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}
*/


	/**
	 * 查看所有用户
	 * 
	 * @return List<UserBean> list
	 */
	private List<UserBean> findAllUser() {
		log.info("get all user info ...");
		List<UserBean> list = new ArrayList<UserBean>();
		UserBean user;
		Connection conn = getConn();
		String sql = "select * from users order by id";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new UserBean();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setCarnumber(rs.getString("carnumber"));
				user.setEnginenumber(rs.getString("enginenumber")); 
				user.setFramenumber(rs.getString("framenumber"));  
				user.setRegisterdate(rs.getDate("registerdate")); 
			    user.setCartype(rs.getString("cartype"));	
			    user.setCarlength(rs.getString("carlength"));
				user.setInsurance(rs.getString("insurance"));
				user.setInsurancefirm(rs.getString("insurancefirm"));
			    user.setCutoffdate(rs.getDate("cutoffdate"));
			    user.setCutoffstatus(rs.getString("cutoffstatus"));
			    user.setNextservicedate(rs.getDate("nextservicedate"));
			    user.setNextservicestatus(rs.getString("nextservicestatus"));
			    user.setLicensedate(rs.getDate("licensedate"));
			    user.setLicensestatus(rs.getString("licensestatus"));
			    user.setDrivelicensedate(rs.getDate("drivelicensedate"));
			    user.setDrivelicensestatus(rs.getString("drivelicensestatus"));   
			    user.setPhone(rs.getString("phone"));
			  
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 将注册信息添加到数据库表 users
	 * 
	 * @param username
	 * @param password
	 * @return
	 */

	private int insert(String username, String carnumber, String enginenumber, String framenumber,
		Date registerdate,String cartype,String carlength,String insurance,String insurancefirm,Date cutoffdate,Date nextservicedate,
		Date licensedate,Date drivelicensedate, String phone) {
		Connection conn = getConn();
		int i = 0;
		String sql = "insert into users (username,carnumber, enginenumber, framenumber,registerdate,cartype,carlength,insurance, insurancefirm,cutoffdate,cutoffstatus,nextservicedate,nextservicestatus,licensedate,licensestatus,drivelicensedate,drivelicensestatus, phone) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			// Statement stat = conn.createStatement();
			pstmt.setString(1, username);
			pstmt.setString(2, carnumber);
			pstmt.setString(3, enginenumber);
			pstmt.setString(4, framenumber);
			pstmt.setDate(5, registerdate);
			pstmt.setString(6,  cartype);
			pstmt.setString(7,  carlength);
			pstmt.setString(8, insurance);
			pstmt.setString(9, insurancefirm);
			pstmt.setDate(10, cutoffdate); 
			pstmt.setString(11,"0");
			pstmt.setDate(12, nextservicedate);
			pstmt.setString(13,"0");
			pstmt.setDate(14, licensedate);
			pstmt.setString(15,"0");
			pstmt.setDate(16, drivelicensedate);
			pstmt.setString(17,"0");
			pstmt.setString(18, phone);
			
			i = pstmt.executeUpdate();
			System.out.println("insert resutl: " + i);
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	/*private static int myUpdate(int id, String carnumber, String enginenumber, String framenumber,
			Date registerdate,String cartype,String carlength,String insurance,String insurancefirm ,Date cutoffdate,Date nextservicedate,
			Date licensedate,Date drivelicensedate, String phone) {
		Connection conn = getConn();
		int i = 0;
		
		String sql = "update users set carnumber='" + carnumber + "',enginenumber='" + enginenumber + "',framenumber='" + framenumber + "',registerdate='" + registerdate+ "',cartype='" + cartype+ "',"
				+ "carlength='" + carlength + "',insurance='" + insurance + "',insurancefirm='" + insurancefirm + "',cutoffdate='" + cutoffdate + "',nextservicedate='" + nextservicedate + "',licensedate='" + licensedate+ "',drivelicensedate='" + drivelicensedate+ "',phone='" + phone+ "' where id='"+ id + "'";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
            System.out.println(registerdate);
			i = pstmt.executeUpdate();
			System.out.println("update resutl: " + i);

			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}*/


	public String update1() throws Exception {
		log.info("id="+id);
	 //	UserBean user=query(id);
		
		//if (null!=user){
			//myUpdate(id,user.getCarnumber(),user.getEnginenumber(),user.getFramenumber(),user.getRegisterdate(),user.getCartype(),user.getCarlength(),
			//	user.getInsurance(),user.getInsurancefirm(), user.getCutoffdate(),user.getNextservicedate(),user.getLicensedate(),user.getDrivelicensedate(),user.getPhone());
		//setUsername(user.getUsername());
	
		//log.info("username="+username);
		
		//return "success";
		//}else{
		//return "error";
		//}
		Connection conn = getConn();
		int i = 0;
		
		//String sql = "update users set carnumber='" + carnumber + "',enginenumber='" + enginenumber + "',framenumber='" + framenumber + "',registerdate=to_date('" + registerdate+ "','yyyy-mm-dd'),cartype='" + cartype+ "',"
		//		+ "carlength='" + carlength + "',insurance='" + insurance + "',insurancefirm='" + insurancefirm + "',cutoffdate=  to_date('" + cutoffdate + "', 'yyyy-mm-dd'),nextservicedate=to_date('" + nextservicedate + "','yyyy-mm-dd'),licensedate=to_date('" + licensedate+ "','yyyy-mm-dd'),drivelicensedate=to_date('" + drivelicensedate+ "','yyyy-mm-dd'),phone='" + phone+ "' where id='"+ id + "'";
		
		String sql = "update users set carnumber='" + carnumber + "',enginenumber='" + enginenumber + "',framenumber='" + framenumber + "',registerdate='" + registerdate+ "',cartype='" + cartype+ "',"
				+ "carlength='" + carlength + "',insurance='" + insurance + "',insurancefirm='" + insurancefirm + "',cutoffdate= '" + cutoffdate + "',nextservicedate='" + nextservicedate + "',licensedate='" + licensedate+ "',drivelicensedate='" + drivelicensedate+ "',phone='" + phone+ "' where id='"+ id + "'";
		System.out.println(sql);
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
            System.out.println(registerdate);
			i = pstmt.executeUpdate();
			System.out.println("update resutl: " + i);

			pstmt.close();
			conn.close();
			return "success";
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}
      
		
		
	}


	/**
	 * register.action
	 * 
	 * @return
	 * @throws Exception
	 */

	public String insert1()  throws Exception{
		
//		String username1=getUsername();
//		Date registerdate1=getRegisterdate();
//		Date cutoffdate1=getCutoffdate();
//		Date nextservicedate1=getNextservicedate();
//		Date licensedate1=getLicensedate();
//		Date drivelicensedate1=getDrivelicensedate();
		//java.text.SimpleDateFormat timeformat = new java.text.SimpleDateFormat( "yyyy-MM-dd"); 
		//java.util.Date registerdate= timeformat.parse(registerdate);
		//java.util.Date cutoffdate= timeformat.parse( request.getParameter(" cutoffdate"));
		//java.util.Date nextservicedate= timeformat.parse( request.getParameter("nextservicedate"));
		//java.util.Date licensedate= timeformat.parse(request.getParameter("licensedate"));
		
	//	java.util.Date drivelicensedate= timeformat.parse(request.getParameter("drivelicensedate"));
		
		//java.sql.Date registerdate1=new java.sql.Date(registerdate.getTime());
	//	java.sql.Date cutoffdate1=new java.sql.Date(cutoffdate.getTime());
	//	java.sql.Date nextservicedate1=new java.sql.Date(nextservicedate.getTime());
	//	java.sql.Date licensedate1=new java.sql.Date(licensedate.getTime());
	//	java.sql.Date drivelicensedate1=new java.sql.Date(drivelicensedate.getTime());
		//String username =request.getParameter("username");
//		String carnumber1 = getCarnumber();
//		String enginenumber1 = getEnginenumber();
//		String framenumber1 = getFramenumber();
//	
//		String cartype1 = getCartype();
//		String carlength1 =getCarlength();
//		String insurance1 =getInsurance();
//	   String insurancefirm1=getInsurancefirm();
//	    String phone1 = getPhone();
//		
		
		
		
		
		int i = insert(username,carnumber, enginenumber, framenumber,
				registerdate,cartype,carlength,insurance,insurancefirm, cutoffdate,
				nextservicedate,licensedate,drivelicensedate, phone);
		if (i != 0)
			return "success";
		else
			return "error";
	}

	public String show1() throws Exception {
		log.info("show.action...");
		userlist = findAllUser();
		if (userlist.size() > 0)
			return "success";
		else
			return "error";
	}



	public String delete1() throws Exception {
		Connection conn = getConn();
		int i = 0;
		System.out.println("id=" + id);
		String sql = "delete users where id ='" + id + "'";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);

			i = pstmt.executeUpdate();
			System.out.println("delete resutl: " + i);

			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i > 0)
			return "success";
		else
			return "error";
	}
}

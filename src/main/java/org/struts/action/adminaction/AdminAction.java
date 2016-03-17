package org.struts.action.adminaction;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.struts.beans.AdminBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//import com.sina.sae.util.SaeUserInfo;
import com.sina.sae.util.SaeUserInfo;

public class AdminAction extends ActionSupport {
	
	private static Log log = LogFactory.getLog(AdminAction.class);

	private int id;
	private String username;
	private String password;
	

	

	private List<AdminBean> userlist;
	private Map session;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AdminBean> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<AdminBean> userlist) {
		this.userlist = userlist;
	}

	/**
	 * �������ݿ�����
	 * 
	 * @return
	 */
	private static Connection getConn() {
		/*String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "scott";
		String password = "19910103";
		Connection conn = null;
		try {
			Class.forName(driver);
			// new oracle.jdbc.driver.OracleDriver();
			conn = DriverManager.getConnection(url, username, password);
			// log.info("connect success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		String url = "jdbc:mysql://localhost:3306/test";	 // ���ݿ������ַ���
		String username = "root";	 // ���ݿ��û���
		String password = "1991";
//		String url ="jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_shenanmsg";
//		String username = SaeUserInfo.getAccessKey();
//	 // ���ݿ��û���
//		String password = SaeUserInfo.getSecretKey();
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");	 // �������ݿ�������ע�ᵽ����������
				 // ���ݿ�����
		 conn = DriverManager.getConnection(url,username,password);
			// ����Connection����
			// �ж����ݿ������Ƿ�Ϊ��
			if(conn != null){
			System.out.println("���ݿ����ӳɹ���");	 // ���������Ϣ
		//	conn.close();	 // �ر����ݿ�����
			}else{
			System.out.println("���ݿ�����ʧ�ܣ�");	 // ���������Ϣ
			}
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			} catch (SQLException e) {
			e.printStackTrace();
			}

		return conn;
	}

	/**
	 * �û���������ƥ����
	 * 
	 * @return �����ʶ �ַ��� success ��ʾƥ��ɹ� UserNotExist��ʾ�û������� error ��ʾƥ��ʧ��
	 */
	private String userCheck() {
		log.info("user checking...");
		String name = null;
		String pass = null;
		Connection conn = getConn();
		String sql = "select * from admin where username='" + username + "'";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				name = rs.getString("username");
				pass = rs.getString("password");

			}

			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (name == null)// ��֤�û����Ƿ����
			return "UserNotExist";
		else if (name.equals(username) && pass.equals(password))// ��֤��¼�û����������Ƿ�ƥ��

			return "success";
		else
			return "error";

	}

	private AdminBean query(int id) {
		log.info("my query...");
		Connection conn = getConn();
		String sql = "select * from admin where id='" + id + "'";
		PreparedStatement pstmt;
		AdminBean user = new AdminBean();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setId(id);
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				System.out.println("myquery: name: " + rs.getString("username")
						+ " \tpassword: " + rs.getString("password"));
			}

			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	/**
	 * �鿴�����û�
	 * 
	 * @return List<AdminBean> list
	 */
	private List<AdminBean> findAllUser() {
		log.info("get all user info ...");
		List<AdminBean> list = new ArrayList<AdminBean>();
		AdminBean user;
		Connection conn = getConn();
		String sql = "select * from  admin order by id";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new AdminBean();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ��ע����Ϣ��ӵ����ݿ�� users
	 * 
	 * @param username
	 * @param password
	 * @return
	 */

	private int insert(String username, String password) {
		Connection conn = getConn();
		int i = 0;
		String sql = "insert into admin (username,password) values(?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			// Statement stat = conn.createStatement();
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			i = pstmt.executeUpdate();
			System.out.println("insert resutl: " + i);
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	private static int myUpdate(int id, String newPass) {
		Connection conn = getConn();
		int i = 0;
		String sql = "update admin set password='" + newPass + "' where id='"
				+ id + "'";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);

			i = pstmt.executeUpdate();
			System.out.println("update resutl: " + i);

			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	/**
	 * login.action
	 * 
	 * @return
	 * @throws Exception
	 */

	public String login() throws Exception {
		log.info("login.action...");
		
		
		
		if (userCheck().equals("success")) {
			ActionContext.getContext().getSession()
					.put("username", getUsername());
//			String name=getUsername();
//			String password=getPassword();
//			
//			Cookie user = new Cookie("user",name+"-"+password);
		
			return SUCCESS;
		} else if (userCheck().equals("UserNotExist"))
			return "UserNotExist";
		else
			return ERROR;

	}

	/**
	 * register.action
	 * 
	 * @return
	 * @throws Exception
	 */

	public String register() throws Exception {
		String name = getUsername();
		String pass = getPassword();
		
		int i = insert(name, pass);
		if (i != 0)
			return "success";
		else
			return "error";
	}

	public String show() throws Exception {
		log.info("show.action...");
		userlist = findAllUser();
		if (userlist.size() > 0)
			return "success";
		else
			return "error";
	}

	public String update() throws Exception {
		log.info("id="+id);
		AdminBean user=query(id);
		if (null!=user){
		setUsername(user.getUsername());
		log.info("username="+username);
	     myUpdate(id,password);
		
		return "success";
		}
		else return "error";
	}

	public String delete() throws Exception {
		Connection conn = getConn();
		int i = 0;
		System.out.println("id=" + id);
		String sql = "delete admin where id ='" + id + "'";
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

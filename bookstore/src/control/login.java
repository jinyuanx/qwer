package control;

import java.sql.*;

import model.User;

public class login {

	public int ask(String id,String pwd) {
		
		ConnectSql sql = new ConnectSql();
		if (id.equals("sa")) {
			try {
				Connection conn = sql.getConn("my_test", "admin");

				String u = null;
				String p = null;
				Statement st = conn.createStatement();
				String s = "select * from admin";
				ResultSet rs = st.executeQuery(s);
				while (rs.next()) {
					u = rs.getString("id");
					p = rs.getString("password");
					if (u.equals(id) && p.equals(pwd)) {
						/*String index = "admin.jsp?username=" + URLEncoder.encode(id, "utf-8");
						out.println("管理员登陆成功！2s后跳转到<a href=" + index + ">后台管理</a>");
						response.addHeader("refresh", "2;URL=admin.jsp?username=" + URLEncoder.encode(id, "utf-8"));*/
						rs.close();
						conn.close();
						return 1;
					}
					
					
				}
				rs.close();
				conn.close();
				//out.println("用户名或密码错误");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(id.substring(0, 2).equals("sj")){
			try {
				Connection conn = sql.getConn("my_test", "store");
				String u = null;
				String p = null;
				Statement st = conn.createStatement();
				String s = "select * from store";
				ResultSet rs = st.executeQuery(s);
				while (rs.next()) {
					u = rs.getString("id");
					p = rs.getString("password");
					if (u.equals(id) && p.equals(pwd)) {
						/*String index = "index.jsp?username=" + URLEncoder.encode(id, "utf-8");
						out.println("商家登陆成功！2s后跳转到<a href=" + index + ">商家页面</a>");
						response.addHeader("refresh", "2;URL=store.jsp?username=" + URLEncoder.encode(id, "utf-8"));*/
						rs.close();
						conn.close();
						return 2;
					}
					
					
				}
				rs.close();
				conn.close();
				//out.println("用户名或密码错误");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				Connection conn = sql.getConn("my_test", "user");
				String u = null;
				String p = null;
				Statement st = conn.createStatement();
				String s = "select * from user";
				ResultSet rs = st.executeQuery(s);
				while (rs.next()) {
					u = rs.getString("id");
					p = rs.getString("password");
					if (u.equals(id) && p.equals(pwd)) {
						/*String index = "index.jsp?username=" + URLEncoder.encode(id, "utf-8");
						out.println("用户登陆成功！2s后跳转到<a href=" + index + ">欢迎页</a>");
						response.addHeader("refresh", "2;URL=index.jsp?username=" + URLEncoder.encode(id, "utf-8"));*/
						rs.close();
						conn.close();
						return 3;
					}
					
					
				}
				rs.close();
				conn.close();
				//out.println("用户名或密码错误");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}

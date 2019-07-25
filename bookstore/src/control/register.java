package control;

import java.sql.*;

import model.User;

public class register {
	
	public boolean add(User user,String id) {
		
		PreparedStatement pst = null;
		ConnectSql sql = new ConnectSql();
		
		if(id.substring(0, 2).equals("sj")){
			try{
				Connection conn = sql.getConn("my_test", "store");
				
				String u = null;
				Statement st = conn.createStatement();
				String s = "insert into store (id,password,email,name,age,sex,money) values (?,?,?,?,?,?,?)";
				String ss = "select * from store";
				ResultSet rs = st.executeQuery(ss);
				boolean flag = false;
				while (rs.next()) {
					u = rs.getString("id");
					if(u.equals(id)){
						flag = true;
						break;
					}
				}
				if(!flag){
					pst=conn.prepareStatement(s);
					pst.setString(1,user.getId());
					pst.setString(2,user.getPassword());
					pst.setString(3,user.getEmail());
					pst.setString(4,user.getName());
					pst.setString(5,user.getAge());
					pst.setString(6,user.getSex());
					pst.setString(7, user.getMoney());
					pst.executeUpdate();
					/*String index = "login.jsp?username=" + URLEncoder.encode(id, "utf-8");
					out.println("注册成功！2s后跳转到<a href=" + index + ">登陆界面</a>");
					response.addHeader("refresh", "2;URL=login.jsp?username=" + URLEncoder.encode(id, "utf-8"));*/
					rs.close();
					conn.close();
					return true;
				}else{
					/*out.println("当前账号已经注册过了");
					String index = "register.jsp?username=" + URLEncoder.encode(id, "utf-8");
					out.println("注册失败！2s后跳转到<a href=" + index + ">注册界面</a>");
					response.addHeader("refresh", "2;URL=register.jsp?username=" + URLEncoder.encode(id, "utf-8"));*/
					rs.close();
					conn.close();
					return false;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else {
			try{
				Connection conn = sql.getConn("my_test", "user");
				
				String u = null;
				Statement st = conn.createStatement();
				String s = "insert into user (id,password,email,name,age,sex,money) values (?,?,?,?,?,?,?)";
				String ss = "select * from user";
				ResultSet rs = st.executeQuery(ss);
				boolean flag = false;
				while (rs.next()) {
					u = rs.getString("id");
					if(u.equals(id)){
						flag = true;
						break;
					}
				}
				if(!flag){
					pst=conn.prepareStatement(s);
					pst.setString(1,user.getId());
					pst.setString(2,user.getPassword());
					pst.setString(3,user.getEmail());
					pst.setString(4,user.getName());
					pst.setString(5,user.getAge());
					pst.setString(6,user.getSex());
					pst.setString(7, user.getMoney());
					pst.executeUpdate();
					/*String index = "login.jsp?username=" + URLEncoder.encode(id, "utf-8");
					out.println("注册成功！2s后跳转到<a href=" + index + ">登陆界面</a>");
					response.addHeader("refresh", "2;URL=login.jsp?username=" + URLEncoder.encode(id, "utf-8"));*/
					rs.close();
					conn.close();
					return true;
				}else{
					/*out.println("当前账号已经注册过了");
					String index = "register.jsp?username=" + URLEncoder.encode(id, "utf-8");
					out.println("注册失败！2s后跳转到<a href=" + index + ">注册界面</a>");
					response.addHeader("refresh", "2;URL=register.jsp?username=" + URLEncoder.encode(id, "utf-8"));*/
					rs.close();
					conn.close();
					return false;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
}
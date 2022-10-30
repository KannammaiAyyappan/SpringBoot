package com.gavs.springboot.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeDao {
	 public int addEmp(Employee e) {
		 {
		 try{
			 String MYSQL_DRIVERNAME = "com.mysql.cj.jdbc.Driver";
			    String MYSQL_CONNECTION_URL = "jdbc:mysql://localhost:3306/kajal";
			    Connection con = null;
			        String strUserName = "root";
			        String strPassword = "admin";
			        java.util.Properties p = new java.util.Properties();
			        p.put("user", strUserName);
			        p.put("password", strPassword);
			        String driverName = MYSQL_DRIVERNAME;
			        Class.forName(driverName);
			        String url = MYSQL_CONNECTION_URL;
			         con = DriverManager.getConnection(url, p);
			        PreparedStatement st = con.prepareStatement("INSERT INTO pin VALUES(?,?)");            
			        st.setInt(1,e.getId());
			        st.setString(2,e.getName());
			        int r = st.executeUpdate();
			        return r;
		 }
		 catch (Exception err) {
			 err.printStackTrace();
			 return 0;
		 } 
		 finally {
		 }
		 }
	 }
public Employee findEmployee(Employee det) {
	ResultSet rs = null;
	Employee Details=null;
	try {
		String sql = "SELECT ID,NAME FROM PIN WHERE ID=?";
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, det.getId());
		rs = ps.executeQuery();
		while(rs.next()) {
			Details = new Employee();
			Details.setId(rs.getInt(1));
			Details.setName(rs.getString(2));
		}
		
		return Details;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	} finally {
			try {
				getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
private Connection getConnection() {
	String MYSQL_DRIVERNAME="com.mysql.cj.jdbc.Driver";
	String MYSQL_CONNECTION_URL="jdbc:mysql://localhost:3306/kajal";
	String strUserName="root";
    String strPassword="admin";
    try {
		Class.forName(MYSQL_DRIVERNAME);
		return DriverManager.getConnection(MYSQL_CONNECTION_URL,strUserName,strPassword);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		return null;
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
}
public int modifyEmployee(Employee emp) {
	try {
		String sql = "UPDATE `pin` SET `NAME` = ? WHERE (`ID` = ?);";
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getId());
		int res = ps.executeUpdate();
		return res;
	} catch (Exception e) {
		return 0;
	}finally {
		if(getConnection()!=null) {
		}
			try {
				getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

public int deleteEmployee(Employee emp) {
	try {
		String sql = "DELETE FROM pin WHERE ID=?";
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, emp.getId());
		return ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
		return 0;
	} finally {
			try {
				getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}



		
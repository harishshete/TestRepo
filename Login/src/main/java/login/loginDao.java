package login;

import java.sql.*;

public class loginDao {
	
	public String check(String password) throws SQLException 
	{
		String url = "jdbc:mysql://localhost:3306/users";
				  //  jdbc:mysql://localhost:3306/harish
		String query ="select user_name from userdata where password = ?";
		
		
		
		Connection con = DriverManager.getConnection(url, "root", "root");
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, password);
		
		System.out.println("this statement is executed");
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		String name = rs.getString(1);
		
		System.out.println(name);
		
		con.close();
		ps.close();
		
		return name;
	
		
		
	
		
		
	}

}

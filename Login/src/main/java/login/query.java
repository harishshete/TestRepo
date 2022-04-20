package login;


import java.sql.*;

public class query {
	
	public String check(String password) throws SQLException 
	{
		String url = "jdbc:mysql://localhost:3306/users";
					 
		String query ="select user_name from userdata where password = ?";
		
		Connection con = DriverManager.getConnection(url, "root", "root");
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, password);
		
		System.out.println("this statement is executed");
		
		ResultSet rs = ps.executeQuery();
		String name = rs.getString("user_name");
		
		System.out.println(name);
		
		
		
		con.close();
		ps.close();
		
		return name;
		
		
		
	}

}

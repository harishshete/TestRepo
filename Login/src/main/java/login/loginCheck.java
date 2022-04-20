package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginCheck
 */
@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	loginData ld = new loginData();
	
	loginDao ld1 = new loginDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		String temp = null;
		
		ld.setUsername(uname);
		ld.setPassword(pass);
		
		
		
		
		
		
		/*
		System.out.println(ld.getUsername());
		System.out.println( ld.getPassword());
		
		String pas = ld.getPassword();
		*/
		
		
		
		PrintWriter out = response.getWriter();
		
		
		try {
			temp = ld1.check(pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(temp != null)
		{
			response.sendRedirect("success.jsp");
		}
		else
		{
			out.println("Wrong Credentails");
			
		}
		
		System.out.println(temp); 
		
	
		
		//String pas = ld.getPassword();
		
	
	/*
	boolean test = false;
	try {
		test = ld1.check(pass);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
		try {
			if(test)
			{
				response.sendRedirect("success.jsp");
				
				System.out.print("User Authentication done successfully..!");
			}
			else
			{
				out.println("Wrong Credentails");
				System.out.print("wrong credentails");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
	}

}

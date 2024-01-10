package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Emp;
import com.dao.EmpDao;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		
		Emp em=EmpDao.getEmployeeById(id);
		  pw.print("<form  action='UpdateController' method='post'> ");
		    
			pw.print("<table>");
			
			pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+em.getId()+"'/></td></tr>");  
			pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+em.getName()+"'/></td></tr>");
		   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='"+em.getEmail()+"'/></td></tr>");
		   	pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone' value='"+em.getPhone()+"'/></td></tr>");
			pw.print("<tr><td>Password:</td> <td><input type='text' name='phone' value='"+em.getPassword()+"'/></td></tr>");
		  
			
		    pw.print("<tr><td><input type='submit' value='Update'/></td></tr>"); 
		    
		   	pw.print("</table>");
			
			pw.print("</form>");
		
		
		
		
	}

}

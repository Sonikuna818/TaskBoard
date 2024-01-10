package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Emp;
import com.dao.EmpDao;


@WebServlet("/AllEmployeeInfo")
public class AllEmployeeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AllEmployeeInfo() 
    {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	    response.setContentType("text/html");
	    PrintWriter pw=response.getWriter();
	    
	    List<Emp> list=   EmpDao.getAllEmployee();
	    
	    pw.print("<table border='1px solid black' width='100%'>");
	    
	    pw.print("<tr> <th>Id</th> <th>Name</th> <th>Email</th> <th>Phone</th> <th>Password</th> <th>Edit</th> <th>Delete</th> </tr>");
	    
	    
	    for(Emp e:list)
	    {
	    	//pw.print("<tr> <td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPhone()+"</td><td>"+e.getPassword()+"</td><td>"+"<a href=EditController?id="+e.getId()+">Edit</a></td><yd>"+"<a href='EditController?id="+e.getId()+">Delete</a></td></tr>");
	    	 pw.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPhone()+"</td><td>"+e.getPassword()+"</td><td>"+"<a href='EditController?id="+e.getId()+"'> Edit </a></td><td>"+"<a href='EditController?id="+e.getId()+"'> Delete </a></td></tr>" );
			    
	    }
	    
	    
	    pw.print("</table>");
	
	}

}

package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Emp;
import com.dao.EmpDao;

@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateController() {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		int id =Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String pwd=request.getParameter("pwd");
		
		Emp e =new Emp();
		e.setId(id);
		e.setName(name);
		e.setEmail(email);
		e.setPhone(phone);
		e.setPassword(pwd);

		int status =EmpDao.updateEmp(e);
		if(status>0)
		{
			pw.print("<script>alert('Data has been updated')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("AllEmployeeInfo");
			rd.include(request, response);
		}
		
	}

}

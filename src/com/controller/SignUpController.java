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
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignUpController() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		
		 String name=request.getParameter("name");
		  String email=request.getParameter("email");
		  String phone=request.getParameter("phone");
		  String pwd=request.getParameter("pwd");
		  Emp e1=new Emp(name, email, phone, pwd);
			 
			 int status=EmpDao.addEmp(e1);
			  
			 if(status>0) {
				 pw.print("Your data has been successfully inserted");
			 }else {
				 pw.print("Sorry something went wrong");
			 }
			 
		
		  
		  
	}

}

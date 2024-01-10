package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bo.Emp;

public class EmpDao 
{
	public static Connection getConnection() 
	{
		Connection con=null;
		try 
		{
			 Class.forName("com.mysql.cj.jdbc.Driver");
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","12345");
		   			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public static int addEmp(Emp e1)
	{
		int status=0;
		
		try 
		{
          Connection con= EmpDao.getConnection();
          String sql="insert into resgister(name,email,phone,password) values(?,?,?,?)";
          
          PreparedStatement ps =con.prepareStatement(sql);
          ps.setString(1, e1.getName());
          ps.setString(2, e1.getEmail());
          ps.setString(3, e1.getPhone());
          ps.setString(4, e1.getPassword());
          
          status=ps.executeUpdate();
          
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static List<Emp> getAllEmployee()
	{
		List<Emp> list=new ArrayList<Emp>();
		
		try 
		{
			Connection con =EmpDao.getConnection();
			String sql="Select * from resgister ";
			
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Emp e=new Emp();
				
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPhone(rs.getString(4));
				e.setPassword(rs.getString(5));
				
				list.add(e);
			}	
		} catch (Exception e)
		{
			e.printStackTrace();	
		}
		return list;
	}
	
	public static boolean userLogin(String email,String pwd)
	{
		boolean status =false;
		
		try 
		{
			Connection con =EmpDao.getConnection();
			
			String sql="select * from resgister where email=? and  password=?";
			
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static Emp getEmployeeById(int id)
	{
		Emp e1=new Emp();
		try 
		{
			Connection con=EmpDao.getConnection();
			String sql="select * from resgister where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				e1.setId(rs.getInt(1));
				e1.setName(rs.getString(2));
				e1.setEmail(rs.getString(3));
				e1.setPhone(rs.getString(4));
				e1.setPassword(rs.getString(5));
				
			}
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return e1;
	}
	
	public static int updateEmp(Emp e1)
	{
		int status=0;
		
		try
		{
			Connection con=EmpDao.getConnection();
			String sql="update resgister set name=?,email=?,phone=?,password=? where id=?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, e1.getName());
			ps.setString(2, e1.getEmail());
			ps.setString(3, e1.getPhone());
			ps.setString(4, e1.getPassword());
			ps.setInt(5, e1.getId());
			
			status =ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return status;
	}
	
}

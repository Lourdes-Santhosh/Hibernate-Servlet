package com.lourdes.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lourdes.conn.HibernateUtil;
import com.lourdes.dao.EmpDao;
import com.lourdes.entity.Emp;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String department = req.getParameter("department");
		String salary = req.getParameter("salary");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Emp emp = new Emp(name, department, salary, email, password);
		System.out.println(emp);
		
		EmpDao dao = new EmpDao(HibernateUtil.getSessionFactory());
		boolean isInserted = dao.saveEmp(emp);
		
		HttpSession session = req.getSession();
		
		if(isInserted) {
			session.setAttribute("msg", "Emp Registered Successfully");
			System.out.println("Inserted Successfully");
		} else {
			session.setAttribute("msg", "Emp Not Registered");
			System.out.println("Not Inserted");
		}
		
		resp.sendRedirect("index.jsp");
	}
	
	
}

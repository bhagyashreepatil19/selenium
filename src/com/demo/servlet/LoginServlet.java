package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.model.Product;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/authenticate")
public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		LoginService ls=new LoginServiceImpl();
		String role=ls.validateUser(uname,pass);
		if(role.equals("admin")) {
			HttpSession sess=request.getSession();
			if(sess.isNew()) {
				sess.setAttribute("user", uname);  //Object
				sess.setAttribute("role", role);
			}
			
			RequestDispatcher rd =request.getRequestDispatcher("showprod");
			rd.forward(request,response);
		}
		else {
			out.println("<h3>Pls enter credential</h3>");
			RequestDispatcher rd =request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}
}








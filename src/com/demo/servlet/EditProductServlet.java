package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.model.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


@WebServlet("/editproduct")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession sess=request.getSession();
		
		String uname=(String) sess.getAttribute("user");
		String role=(String) sess.getAttribute("role");
		if((role.equals("admin")) && (uname!=null) ) {
			int pid=Integer.parseInt(request.getParameter("pid"));
			ProductService ps=new ProductServiceImpl();
			Product prod=ps.findByID(pid);
			request.setAttribute("prod", prod);
			RequestDispatcher rd=request.getRequestDispatcher("editproduct.jsp");
			rd.forward(request, response);
		}
		else {
			out.println("<h3>Pls enter credential</h3>");
			RequestDispatcher rd =request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		
	}

	
}

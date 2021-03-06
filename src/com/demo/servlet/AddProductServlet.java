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

@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess=request.getSession();
		String role=(String) sess.getAttribute("role");
		String uname=(String) sess.getAttribute("user");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if((role.equals("admin")) && (uname!=null)) {
			int pid=Integer.parseInt(request.getParameter("id"));
			String nm=request.getParameter("nm");
			int qty=Integer.parseInt(request.getParameter("qty"));
			double price=Double.parseDouble(request.getParameter("price"));
			int cid=Integer.parseInt(request.getParameter("cid"));
			Product p=new Product(pid,nm,qty,price,cid);
			ProductService ps=new ProductServiceImpl();
			boolean ans=ps.addProduct(p);
			RequestDispatcher rd=request.getRequestDispatcher("showprod");
			rd.forward(request, response);
		}
		else {
			out.println("<h3>Pls enter credential</h3>");
			RequestDispatcher rd =request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		
	}

}

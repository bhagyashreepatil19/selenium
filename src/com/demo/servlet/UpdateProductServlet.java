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

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/updateprod")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess=request.getSession();
		PrintWriter out=response.getWriter();
		String uname=(String) sess.getAttribute("user");
		String role=(String) sess.getAttribute("role");
		if((role.equals("admin")) && (uname!=null) ) {
				
				int pid=Integer.parseInt(request.getParameter("id"));
				String nm=request.getParameter("nm");
				int qty=Integer.parseInt(request.getParameter("qty"));
				double price=Double.parseDouble(request.getParameter("price"));
				int cid=Integer.parseInt(request.getParameter("cid"));
				Product p=new Product(pid,nm,qty,price,cid);
				ProductService ps=new ProductServiceImpl();
				boolean ans=ps.updateProductById(p);
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

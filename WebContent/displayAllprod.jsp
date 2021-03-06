<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border='2'>
<tr><th>Id</th><th>Name</th><th>Quantity</th><th>Price</th><th>Action</th>
<c:forEach var="p" items="${plist}"> 

<tr>
<td>${p.pid}</td>
<td>${p.pname}</td>
<td>${p.qty}</td>
<td>${p.price}</td>
<td><a href="editproduct?pid=${p.pid}">edit</a>/<a href="delproduct?pid=${p.pid}">delete</a>
</tr>

</c:forEach>

</table>
<a href='addproduct.jsp'>Add product</a>
<a href="logout">Logout</a>
</body>
</html>
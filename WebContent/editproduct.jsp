<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="updateprod">
		Product id= <input type="text" name="id" value="${prod.pid}" readonly>
		Name <input type="text" name="nm" value="${prod.pname}">
		Quantity <input type="text" name="qty" value="${prod.qty}">
		Price <input type="text" name="price" value="${prod.price}">
		Category <input type="text" name="cid" value="${prod.cid}">
		<button type="submit" name="btn">Update product</button>
	</form>
</body>
</html>
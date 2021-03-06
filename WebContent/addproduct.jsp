<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addproduct" method="get"> 
Product ID : <input type="text" name="id">
Product Name: <input type="text" name="nm">
Product qty : <input type="text" name="qty">
Product price : <input type="text" name="price">
Product category : <select name="cid">
                     <option value='1'>fruits</option>
                     <option value='2'>chocolates</option>
                     <option value='3'>vegetables</option>
                  </select>
 <input type="submit" name="btn" value="Add Product">
</form>
</body>
</html>
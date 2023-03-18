<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
 <%@page import="com.simplilearn.demo.POJO.*" %>
    <%@page import="java.nio.file.Files" %>
    <%@page import="java.io.File" %>
      <%@page import="java.util.Base64.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<style>
h1 {
  text-align: center;
  font-family:verdana;
  font-size:300%;
  color:#006400;
}
body {
  background-color:rgb(255, 255, 128);
}
a:hover {
  background-color: lightgreen;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
  <%String path2="D:/Project image/Pharmacy.png";
byte[] images2=Files.readAllBytes(new File(path2).toPath());
byte[] encodeBase642 = Base64.getEncoder().encode(images2);
String base64Encoded2 = new String(encodeBase642, "UTF-8");
%>
<img alt="img" src="data:image/jpg;base64,<%=base64Encoded2%>" width="100" height="100" />
<h1 ><b><i>List of Products</i></b></h1>
<h3><a href="insertmedicine.jsp">Insert Product</a></h3>
<h3><a href="Logout.jsp">Logout</a></h3>
  </div>
</nav>

<%@include file="searchmedicine.jsp" %>&nbsp 


<%List<Medicine> list=(List<Medicine>)request.getAttribute("list");%>

<table class="table table-hover">
<tr><th>Id</th><th>Image</th><th>Name</th><th>Description</th><th>Category</th><th>Brand</th><th>Availability</th><th>Price</th><th>Action</th></th></tr>
<%for(Medicine m:list){ %>
<tr><td><%=m.getId()%></td>
<td><%String path=m.getImage();
byte[] images=Files.readAllBytes(new File(path).toPath());
byte[] encodeBase64 = Base64.getEncoder().encode(images);
String base64Encoded = new String(encodeBase64, "UTF-8");
%>
<img alt="img" src="data:image/png;base64,<%=base64Encoded%>" width="100" height="100"/>
</td>
<td><%=m.getName() %></td>
<td><%=m.getDescription()%></td>
<td><%=m.getCategory()%></td>
<td><%=m.getBrand()%></td>
<td><%=m.getAvailability() %></td>
<td><%=m.getPrice()%></td>
<td>
<form action="updatemedicine.jsp">
<input type="hidden" name="id" value=<%=m.getId() %>>
<div style="text-align:center">
<button type="submit" class="btn btn-success">Update</button>
</div>
</form>
<br>
<form action="deletemedicine.jsp">
<input type="hidden" name="id" value=<%=m.getId() %>>
<div style="text-align:center">
<button type="submit" class="btn btn-danger">Delete</button>
</div>
</form>
</td>
</tr>
<%}%>

</table>
</body>
</html>
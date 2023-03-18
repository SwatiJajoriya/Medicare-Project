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
<h1 ><b><i>List Of Users</i></b></h1>

<h3><a href="showmedicinetouser1.jsp">Product List</a></h3>
<h3><a href="Logout.jsp">Logout</a></h3>
  </div>
</nav>
<h1><b><i></i></b></h1><br><br>
<%List<User> e=(List<User>)request.getAttribute("list"); %>
<table  class="table table-hover">
<tr><th>User_ID</th><th>First_Name</th><th>Last_Name</th><th>Email</th><th>Username</th><th>Password</th><th>Action</th></tr>
<%for(User es:e){%>
<tr><td><%=es.getUid()%></td><td><%=es.getU_fname()%></td><td><%=es.getU_lname()%></td><td><%=es.getEmail()%></td><td><%=es.getUusername()%></td><td><%=es.getUpassword()%></td>
<td>
<form action="deleteuser">
<input type="hidden" name="fid" value=<%=es.getUid() %>>
<div style="text-align:center">
<button type="submit" class="btn btn-primary">Delete User</button>
</div>
</form></td></tr>
<%}%>
</table>
</body>
</html>
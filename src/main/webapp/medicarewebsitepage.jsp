<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
     <%@page import="java.nio.file.Files" %>
    <%@page import="java.io.File" %>
    <%@page import="java.util.Base64.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<style>
body {
  background-color:rgb(255, 255, 128);
}
a:hover {
  background-color: lightgreen;
}
h1 {
  text-align: center;
  font-family:verdana;
  font-size:300%;
  color:Crimson;
 background-color:hsla(0, 100%, 50%, 0.1);
}
h3{
text-align: center;
  font-family:verdana;
  font-size:300%;
  color:Crimson;
 background-color:hsla(0, 100%, 50%, 0.1);
}
h4 {
  text-align: center;
}
</style>
</head>
<title>Medicare Website</title>
<body>

<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
  <%String path="D:/Project image/Pharmacy.png";
byte[] images=Files.readAllBytes(new File(path).toPath());
byte[] encodeBase64 = Base64.getEncoder().encode(images);
String base64Encoded = new String(encodeBase64, "UTF-8");
%>
<img alt="img" src="data:image/jpg;base64,<%=base64Encoded%>" width="100" height="100" />
<h3><i><b> Welcome To Medicare</b></i></h3>
 <a href="adminlogin.jsp">Admin</a>
<a href="userlogin.jsp">User</a>
<a href="Logout.jsp">Logout</a>
  </div>
</nav>
<h4><i><b>Single Step Online Pharmacy</b></i></h4>
<%String path1="D:/Project image/Medicare.png";
byte[] images1=Files.readAllBytes(new File(path1).toPath());
byte[] encodeBase641 = Base64.getEncoder().encode(images1);
String base64Encoded1 = new String(encodeBase641, "UTF-8");
%>
<img alt="img" src="data:image/jpg;base64,<%=base64Encoded1%>" width="100%" height="100%"/>
</body>
</html>
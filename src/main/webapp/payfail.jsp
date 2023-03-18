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
h2 {
  text-align: center;
  font-family:verdana;
  font-size:300%;
  color:#006400;
}
a:hover {
  background-color: lightgreen;
}
body {
  background-color:rgb(255, 255, 128);
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
  <%String path="D:/Project image/Pharmacy.png";
byte[] images=Files.readAllBytes(new File(path).toPath());
byte[] encodeBase64 = Base64.getEncoder().encode(images);
String base64Encoded = new String(encodeBase64, "UTF-8");
%>
<img alt="img" src="data:image/jpg;base64,<%=base64Encoded%>" width="100" height="100" />
<div class="text-center"><h2>SORRY!!</h2></div>

<div class="margin-left=5"><h3><a href="Logout.jsp">Logout</a></h3></div>
  </div>
</nav>
<h1><i>Transaction Failed...Low Balance!!</i></h1>
</body>
</html>
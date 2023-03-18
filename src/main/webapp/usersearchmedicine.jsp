<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  background-color: rgb(255, 255, 128);
}
.pull-right {
    float: right;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar bg-light">
  <div class="container-fluid">
    <form action="usersearchmedicine">
<input type="text" name="keyword" placeholder="Search" style="vertical-align:bottom"/>&nbsp;
<button type="submit" class="btn btn-primary" >Search </button>&nbsp;
</form> 
  </div>
</nav>

<nav class="navbar bg-light" class="float-right">
  <div class="container-fluid"  >
 <form action="userfiltermedicine">
<input type="text" name="keyword" placeholder="by category or brand" />&nbsp;
<button type="submit" class="btn btn-primary" >FilterBy</button>
</form>
</div>
</nav>

<div class="container-fluid">
 <form action="usersortmedicine">
               <select size="0" name="list">
                   <option value="">By Price</option>
                   <option value="Asc">low to high</option>
                   <option value="Desc">high to low</option>
              </select>
           <button type="submit" class="btn btn-primary" >SortBy</button>	
               </form>
       </div>
   
<form action="showmedicinetouser1.jsp">
<button type="submit" class="btn btn-primary">Product List</button>
</form> 
</body>
</html>
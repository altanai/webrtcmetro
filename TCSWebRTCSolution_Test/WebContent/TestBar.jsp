<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function prog()
{
	//alert("in funct");
   var x = document.getElementById("indicator");
   for (var i=0;i<100;i++){
   x.style.width=i+"%";
   }
   //x.style.width="90%";
}
</script>
</head>
<body>
<button onclick="prog();">Click me</button>
	<div style="width:300px;padding:2px;background-color:blue;border:1px solid black;text-align:center">
         <div style="width:0px;height:15px;background-color:green;" id="indicator" name="indicator"></div>
    </div>
</body>
</html>
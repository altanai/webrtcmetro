<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table bgcolor= "black" align="center"><tr> <th align="left"><tr><td align="center">
<a href="<%=request.getContextPath() %>/CallServlet"><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/CALL1%20(2).jpg" alt="CALL"  width="150" height="40"/></a>
<a href="<%=request.getContextPath() %>/ReadCustomizeInterestServlet?action=viewcustomizeinterest">&nbsp;&nbsp;<img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/EDITINTEREST1.jpg" alt="EDIT INTEREST" width="150" height="40"></a>
<a href="<%=request.getContextPath() %>/advertisment/CallStart.jsp">&nbsp;&nbsp;<img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/ENDCALL1.jpg" alt="END CALL" width="150" height="40"></a></td></tr>
</table>

</body>
</html>
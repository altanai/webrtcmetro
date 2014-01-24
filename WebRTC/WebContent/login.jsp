<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>

<body>
<s:form action="loginUser">
	

		<s:textfield name="sipuri" label="User Name" />
		<s:textfield name="password" label="Password " />
		
		<s:submit />
	
</s:form>


</body>
</html>
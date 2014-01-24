<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Email Page</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
<s:form action="saveOrUpdateUser">
   <s:push value="email">
	<s:textfield sipuri="sipuri" label="Sip URI" />
	<s:textfield sipuri="gmail" label="Gmail" />
	<s:textfield sipuri="facebook" label="Facebook" />
	<s:textfield sipuri="yahoomail" label="Yahoo Mail" />
	<s:textfield sipuri="twitter" label="Twitter" />
	<s:submit />
	</s:push>
</s:form>

<s:if test="emailList.size() > 0">
	<div class="content">

	<table class="emailTable" cellpadding="5px">
		<tr class="even">
			<th>Sip URI</th>
			<th>Gmail</th>
			<th>Facebook</th>
			<th>Yahoo Mail</th>
			<th>Twitter</th>
		</tr>
		<s:iterator value="emailList" status="emailStatus">
			<tr
				class="<s:if test="#emailStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="sipuri" /></td>
				<td><s:property value="facebook" /></td>
				<td><s:property value="yahoomail" /></td>
				<td><s:property value="twitter" /></td>
				
				<td><s:url id="editURL" action="editUser">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{editURL}">Edit</s:a></td>
				<td><s:url id="deleteURL" action="deleteUser">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
				
			</tr>
		</s:iterator>
	</table>

	</div>
</s:if>
</body>
</html>
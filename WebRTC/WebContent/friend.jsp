<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friend Page</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
<s:form action="addFriend">
	<s:textfield name="sipuri" label="Sipurui" />
	<s:textfield name="friend" label="Friend" />
	<s:submit />
</s:form>

<s:if test="friendList.size() > 0">
	<div class="content">
	<table class="friendTable" cellpadding="5px">
		<tr class="even">
			<th>Name</th>
			<th>Friend</th>
		</tr>
		<s:iterator value="friendList" status="friendStatus">
			<tr
				class="<s:if test="#friendStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="sipuri" /></td>
				<td><s:property value="friend" /></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
</body>
</html>
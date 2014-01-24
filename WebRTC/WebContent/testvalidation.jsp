<%@ taglib prefix="s" uri="/struts-tags" %>

<s:actionerror/>

<s:form action="register">
<s:textfield name="name" label="Name"></s:textfield>
<s:password name="password" label="Password"></s:password>
<s:submit value="register"></s:submit>
 
</s:form>
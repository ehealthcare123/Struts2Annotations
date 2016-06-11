<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Employee Form</title>
</head>

<body>

   <s:form action="login" method="post">
      <s:textfield name="name" label="Name" size="20" />
      <s:password name="password" label="Password" size="20" />
      <s:submit name="submit" label="Submit" align="center" />
   </s:form>

<a href="<s:url action="register"/>">Registrieren</a>
<a href="echo.xhtml">WebSocketTest</a>

<script src="JSsources/WebSocketHandler.js" type="application/javascript"></script>
</body>
</html>
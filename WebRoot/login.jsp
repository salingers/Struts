<%@ page language="java" import="java.util.*"   pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�ϥΪ̵n�J</title>
	</head>

	<body>
		<div align="right">
			<s:a href="register.jsp">
				<font color="blue"><h5>
						�٥��n���H�I���n��
					</h5> </font>
			</s:a>
		</div>
		<div style="color: #7FFF00">
			<s:form action="login" method="post">
				<s:textfield name="username" label="�㸹"></s:textfield>
				<s:password name="password" label="�K�X"></s:password>
				
				<s:submit value="�n��"></s:submit>
			</s:form>
		</div>

	</body>
</html>

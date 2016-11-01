<%@ page language="java" import="java.util.*"   pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>使用者登入</title>
	</head>

	<body>
		<div align="right">
			<s:a href="register.jsp">
				<font color="blue"><h5>
						還未登錄？點擊登錄
					</h5> </font>
			</s:a>
		</div>
		<div style="color: #7FFF00">
			<s:form action="login" method="post">
				<s:textfield name="username" label="賬號"></s:textfield>
				<s:password name="password" label="密碼"></s:password>
				
				<s:submit value="登陸"></s:submit>
			</s:form>
		</div>

	</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>�n�����\</title>
<script language='javascript' type='text/javascript'>
	var secs = 5; //�˭p�ɪ����     
	var URL;
	
	function Load(url)
	{
		URL = url;
		
		for (var i = secs; i >= 0; i--)
		{
			window.setTimeout('doUpdate(' + i + ')', (secs - i) * 1000);
		}
	}
	
	function doUpdate(num)
	{
		document.getElementById('ShowDiv').innerHTML = '�N�b' + num
				+ '���۰ʸ��D��n�J����';
		if (num == 0)
		{
			window.location = URL;
		}
	}
</script>
</head>

<body>
	<center>
		<h1>
			<font color="red" align="center">���߱z�A�n�����\�I�I</font>
		</h1>
		<br />
		<div id="ShowDiv"></div>
		<script language="javascript">
			Load("http://localhost:8080/struts2login/login.jsp");
		</script>
		<s:a href="/struts2login/login.jsp">
			<font color="blue"><h5>��ʵn�J�H</h5> </font>
		</s:a>
	</center>
</body>
</html>

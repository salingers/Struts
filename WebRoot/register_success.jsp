<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登錄成功</title>
<script language='javascript' type='text/javascript'>
	var secs = 5; //倒計時的秒數     
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
		document.getElementById('ShowDiv').innerHTML = '將在' + num
				+ '秒後自動跳躍到登入頁面';
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
			<font color="red" align="center">恭喜您，登錄成功！！</font>
		</h1>
		<br />
		<div id="ShowDiv"></div>
		<script language="javascript">
			Load("http://localhost:8080/struts2login/login.jsp");
		</script>
		<s:a href="/struts2login/login.jsp">
			<font color="blue"><h5>手動登入？</h5> </font>
		</s:a>
	</center>
</body>
</html>

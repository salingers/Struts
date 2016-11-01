<%@ page language="java" import="java.util.*"  pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>使用者登錄</title>
		<script type="text/javascript">
    	function shuaxin(obj) {
        var shijian = new Date().getTime();
        obj.src="imageAction.action?d="+shijian;
   		}
  </script>
	</head>

	<body>

		<h1 align="center">
			使用者登錄
		</h1>
		<div align="center">
			<s:fielderror cssStyle="color:red"></s:fielderror>
			<s:actionerror cssStyle="color:red"></s:actionerror>
			<br>
			<s:form action="register" theme="simple" method="post">
				<table width="50%" border="0" style="width: 501px; height: 342px;">
					<tr>
						<td align="right">
							賬號：
						</td>

						<td width=20>
							<s:textfield name="username"></s:textfield>
						</td>

						<td>
							<font color="red" align="left">
								<h6>
									*必填
								</h6>
							</font>
						</td>
					</tr>

					<tr>
						<td align="right">
							密碼：
						</td>
						<td>
							<s:password name="password"></s:password>
						</td>

						<td>
							<font color="red" align="left"><h6>
									*必填
								</h6>
							</font>
						</td>
					</tr>



					<tr>
						<td align="right">
							重復密碼：
						</td>
						<td>
							<s:password name="repassword"></s:password>
						</td>
						<td>
							<font color="red" align="left"><h6>
									*必填
								</h6>
							</font>
						</td>
					</tr>

					<tr>
						<td align="right">
							性別：
						</td>
						<td>
							<input type="radio" name="sex" value="0" checked />
							男
							<input type="radio" name="sex" value="1" />
							女
						</td>
					</tr>

					<tr>
						<td align="right">
							電子信箱：
						</td>

						<td>
							<s:textfield name="email"></s:textfield>
						</td>

						<td>
							<font color="red" align="left"><h6>
									*必填
								</h6>
							</font>
						</td>
					</tr>
					<tr>
						<td align="right">
							驗證碼：
						</td>
						<td>
							<s:textfield name="validate"></s:textfield>
						</td>
						<td>
							<img src="imageAction" align="left" alt="點擊圖片"
								onClick="shuaxin(this)" />
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
							<s:submit value="傳送"></s:submit>
							<s:reset value="重設"></s:reset>
						</td>
					</tr>
				</table>
			</s:form>
		</div>
	</body>
</html>

<%@ page language="java" import="java.util.*"  pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�ϥΪ̵n��</title>
		<script type="text/javascript">
    	function shuaxin(obj) {
        var shijian = new Date().getTime();
        obj.src="imageAction.action?d="+shijian;
   		}
  </script>
	</head>

	<body>

		<h1 align="center">
			�ϥΪ̵n��
		</h1>
		<div align="center">
			<s:fielderror cssStyle="color:red"></s:fielderror>
			<s:actionerror cssStyle="color:red"></s:actionerror>
			<br>
			<s:form action="register" theme="simple" method="post">
				<table width="50%" border="0" style="width: 501px; height: 342px;">
					<tr>
						<td align="right">
							�㸹�G
						</td>

						<td width=20>
							<s:textfield name="username"></s:textfield>
						</td>

						<td>
							<font color="red" align="left">
								<h6>
									*����
								</h6>
							</font>
						</td>
					</tr>

					<tr>
						<td align="right">
							�K�X�G
						</td>
						<td>
							<s:password name="password"></s:password>
						</td>

						<td>
							<font color="red" align="left"><h6>
									*����
								</h6>
							</font>
						</td>
					</tr>



					<tr>
						<td align="right">
							���_�K�X�G
						</td>
						<td>
							<s:password name="repassword"></s:password>
						</td>
						<td>
							<font color="red" align="left"><h6>
									*����
								</h6>
							</font>
						</td>
					</tr>

					<tr>
						<td align="right">
							�ʧO�G
						</td>
						<td>
							<input type="radio" name="sex" value="0" checked />
							�k
							<input type="radio" name="sex" value="1" />
							�k
						</td>
					</tr>

					<tr>
						<td align="right">
							�q�l�H�c�G
						</td>

						<td>
							<s:textfield name="email"></s:textfield>
						</td>

						<td>
							<font color="red" align="left"><h6>
									*����
								</h6>
							</font>
						</td>
					</tr>
					<tr>
						<td align="right">
							���ҽX�G
						</td>
						<td>
							<s:textfield name="validate"></s:textfield>
						</td>
						<td>
							<img src="imageAction" align="left" alt="�I���Ϥ�"
								onClick="shuaxin(this)" />
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
							<s:submit value="�ǰe"></s:submit>
							<s:reset value="���]"></s:reset>
						</td>
					</tr>
				</table>
			</s:form>
		</div>
	</body>
</html>

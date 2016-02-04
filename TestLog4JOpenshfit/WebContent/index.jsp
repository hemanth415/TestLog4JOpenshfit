<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload with Servlet 3.0</title>
</head>
<body>
	<form action="loggingEx" method="post">
		<div align="center">
			<table align="left" width="30%">
				<tr>
					<td colspan="1"><h1>Logging Example In OpenShift</h1></td>
				</tr>
				<tr>
					<td>Log Folder Location On Server:  <%=System.getenv("OPENSHIFT_DATA_DIR")%></td>
				</tr>
				<tr>
					<td colspan="1"><input value="Test" type="submit" /></td>
				</tr>
				<tr>
					<td colspan="1"><textarea name="log" rows="20" cols="100">${log}</textarea></td>
				</tr>

			</table>

		</div>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Permissions</title>
</head>
<body>
	<h2>GetAccessToken API Test Page</h2>
	<form method="post" action="GetAccessToken">
		<%
			String query = request.getQueryString();
			Map map = new HashMap();
			try {
				StringTokenizer stTok = new StringTokenizer(query, "&");
				while (stTok.hasMoreTokens()) {
					StringTokenizer stInternalTokenizer = new StringTokenizer(
							stTok.nextToken(), "=");
					if (stInternalTokenizer.countTokens() == 2) {
						map.put(stInternalTokenizer.nextToken(),
								stInternalTokenizer.nextToken());
					}
				}
			} catch (Exception e) {
				//left on purpose
			}

			if (map != null) {
				Iterator iterator = map.entrySet().iterator();
				while (iterator.hasNext()) {
					Map.Entry elem = (Map.Entry) iterator.next();
		%><table>
			<tr>
				<td><%=elem.getKey()%>:</td>
				<td align="left"><input type="text" name="txtbox"
					value=<%=elem.getValue()%>></td>
			</tr>
		</table>
		<%
			}
			}
			if (map.size() == 0) {
		%>
		<div class="params">
			<div class="param_name">verification_code</div>
			<div class="param_value">
				<input type="text" name="verCode" size="50" maxlength="260" value="" /><br />
			</div>
		</div>
		<div class="params">
			<div class="param_name">request_token</div>
			<div class="param_value">
				<input type="text" name="reqToken" size="50" maxlength="260"
					value="" /><br />
			</div>
		</div>
		<%
			}
		%>
		<input type="submit" name="GenerateBtn" value="GetAccessToken">
		<br /> <a href="index.html">Home</a>
	</form>
</body>
</html>
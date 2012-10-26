<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PayPal SDK - GetAccessToken</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h3>GetAccessToken</h3>
			<div id="apidetails">GetAccessToken API operation is used to
				obtain an access token for a set of permissions.</div>
		</div>
		<form method="POST" action="GetAccessToken">
			<div id="request_form">
				<%
					String query = request.getQueryString();
					Map<String, String> map = new HashMap<String, String>();
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
							Map.Entry<String, String> elem = (Map.Entry) iterator
									.next();
				%><table class="params">
					<tr>
						<td class="param_name"><%=elem.getKey()%>:</td>
						<td align="left" class="param_value"><input type="text"
							name="txtbox" value=<%=elem.getValue()%>>
						</td>
					</tr>
				</table>
				<%
					}
					}
					if (map.size() == 0) {
				%>
				<div class="params">
					<div class="param_name">
						Verification Code*(Get Verification Code via <a
							href='RequestPermissions'>RequestPermissions</a>)
					</div>
					<div class="param_value">
						<input type="text" name="verCode" size="50" maxlength="260"
							value="" /><br />
					</div>
				</div>
				<div class="params">
					<div class="param_name">
						Request Token*(Get Request Token via <a href='RequestPermissions'>RequestPermissions</a>)
					</div>
					<div class="param_value">
						<input type="text" name="reqToken" size="50" maxlength="260"
							value="" /><br />
					</div>
				</div>
				<%
					}
				%>
				<div class="submit">
					<input type="submit" name="GenerateBtn" value="GetAccessToken">
					<br />
				</div>
				<a href="index.html">Home</a>
			</div>
		</form>
		<div id="relatedcalls">
			See also
			<ul>
				<li><a href='RequestPermissions'>RequestPermissions</a>
				</li>
				<li><a href='GetAccessToken'>GetAccessToken</a>
				</li>
				<li><a href='GetPermissions'>GetPermissions</a>
				</li>
				<li><a href='CancelPermissions'>CancelPermissions</a>
				</li>
				<li><a href='GetBasicPersonalData'>GetBasicPersonalData</a>
				</li>
				<li><a href='GetAdvancedPersonalData'>GetAdvancedPersonalData</a>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
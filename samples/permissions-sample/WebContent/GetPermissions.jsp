<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PayPal SDK - GetPermissions</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h3>GetPermissions</h3>
			<div id="apidetails">GetPermissions API operation is used to
				obtain the permissions associated with an access token.</div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="param_name">
						Access Token*(Get Access Token via <a href='RequestPermissions'>RequestPermissions</a>)
					</div>
					<div class="param_value">
						<input type="text" name="token" size="50" maxlength="260" value="" /><br />
					</div>
				</div>
				<div class="submit">
					<input type="submit" name="GetPermissionsBtn"
						value="GetPermissions" /> <br />
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
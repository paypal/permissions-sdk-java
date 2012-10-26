<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PayPal SDK - GetAdvancedPersonalData</title>

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h3>GetAdvancedPersonalData</h3>
			<div id="apidetails">GetAdvancedPersonalData API operation is
				used to obtain sensitive personal data for an account holder.</div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="param_name">
						AccessToken(Get Access Token via <a href='RequestPermissions'>RequestPermissions</a>)
					</div>
					<div class="param_value">
						<input type="text" id="accessToken" name="accessToken" size="60"
							value="" /><br />
					</div>
				</div>
				<div class="params">
					<div class="param_name">
						TokenSecret(Get Token Secret via <a href='RequestPermissions'>RequestPermissions</a>)
					</div>
					<div class="param_value">
						<input type="text" id="tokenSecret" name="tokenSecret" size="60"
							value="" /><br />
					</div>
				</div>
				<div class="params">
					<div class="param_name">Advanced Attributes*</div>
					<div class="param_value">
						<input type="checkbox" name="attr"
							value='http://axschema.org/namePerson/first' checked="checked" />
						FirstName <br /> <input type="checkbox" name="attr"
							value='http://axschema.org/namePerson/last' checked="checked" />
						LastName <br /> <input type="checkbox" name="attr"
							value='http://axschema.org/contact/email' checked="checked" />
						Email <br /> <input type="checkbox" name="attr"
							value='http://schema.openid.net/contact/fullname'
							checked="checked" /> FullName <br /> <input type="checkbox"
							name="attr" value='http://axschema.org/company/name'
							checked="checked" /> BusinessName <br /> <input type="checkbox"
							name="attr" value='http://axschema.org/contact/country/home'
							checked="checked" /> CountryCode <br /> <input type="checkbox"
							name="attr" value='http://axschema.org/contact/country/home'
							checked="checked" /> CountryCode <br /> <input type="checkbox"
							name="attr" value='http://axschema.org/birthDate'
							checked="checked" /> BirthDate <br /> <input type="checkbox"
							name="attr" value='http://axschema.org/contact/postalCode/home'
							checked="checked" /> PostalCode <br /> <input type="checkbox"
							name="attr" value='http://schema.openid.net/contact/street1'
							checked="checked" /> Street Line 1 <br /> <input
							type="checkbox" name="attr"
							value='http://schema.openid.net/contact/street2'
							checked="checked" /> Street Line 2 <br /> <input
							type="checkbox" name="attr"
							value='http://axschema.org/contact/city/home' checked="checked" />
						City <br /> <input type="checkbox" name="attr"
							value='http://axschema.org/contact/state/home' checked="checked" />
						State <br /> <input type="checkbox" name="attr"
							value='http://axschema.org/contact/phone/default'
							checked="checked" /> Phone <br /> <input type="checkbox"
							name="attr"
							value='https://www.paypal.com/webapps/auth/schema/payerID'
							checked="checked" /> PayerId <br />
					</div>
				</div>
				<div class="submit">
					<input type="submit" name="PermissionBtn"
						value="GetAdvancedPersonalData" /> <br />
				</div>
				<a href="index.html">Home</a>
			</div>
		</form>
		<div id="relatedcalls">
			See also
			<ul>
				<li><a href='RequestPermissions'>RequestPermissions</a></li>
				<li><a href='GetAccessToken'>GetAccessToken</a></li>
				<li><a href='GetPermissions'>GetPermissions</a></li>
				<li><a href='CancelPermissions'>CancelPermissions</a></li>
				<li><a href='GetBasicPersonalData'>GetBasicPersonalData</a></li>
				<li><a href='GetAdvancedPersonalData'>GetAdvancedPersonalData</a>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
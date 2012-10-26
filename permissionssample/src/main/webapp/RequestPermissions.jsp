<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PayPal SDK - RequestPermissions</title>
<%
	StringBuilder url = new StringBuilder();
	url.append("http://");
	url.append(request.getServerName());
	url.append(":");
	url.append(request.getServerPort());
	url.append(request.getContextPath());
	String returnURL = url.toString() + "/GetAccessToken.jsp";
%>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h3>RequestPermission</h3>
			<div id="apidetails">RequestPermissions API operation is used
				to request permissions to execute API operations on a PayPal account
				holder's behalf.</div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="param_name">CallBack*</div>
					<div class="param_value">
						<input type="text" id="callback" name="callback" size="60"
							value="<%=returnURL%>" /><br />
					</div>
				</div>
				<div class="params">
					<div class="param_name">Scope*</div>
					<div class="param_value">
						<input type="checkbox" name="api" value="EXPRESS_CHECKOUT" />EXPRESS_CHECKOUT<br />
						<input type="checkbox" name="api" value="DIRECT_PAYMENT" />DIRECT_PAYMENT<br />
						<input type="checkbox" name="api" value="AUTH_CAPTURE" />AUTH_CAPTURE<br />
						<input type="checkbox" name="api" value="AIR_TRAVEL" />AIR_TRAVEL<br />
						<input type="checkbox" name="api" value="TRANSACTION_SEARCH" />TRANSACTION_SEARCH<br />
						<input type="checkbox" name="api" value="RECURRING_PAYMENTS" />RECURRING_PAYMENTS<br />
						<input type="checkbox" name="api" value="ACCOUNT_BALANCE" />ACCOUNT_BALANCE<br />
						<input type="checkbox" name="api"
							value="ENCRYPTED_WEBSITE_PAYMENTS" />ENCRYPTED_WEBSITE_PAYMENTS<br />
						<input type="checkbox" name="api" value="REFUND" /> REFUND<br />
						<input type="checkbox" name="api" value="BILLING_AGREEMENT" />BILLING_AGREEMENT<br />
						<input type="checkbox" name="api" value="REFERENCE_TRANSACTION" />REFERENCE_TRANSACTION<br />
						<input type="checkbox" name="api" value="MASS_PAY" />MASS_PAY<br />
						<input type="checkbox" name="api" value="TRANSACTION_DETAILS" />TRANSACTION_DETAILS<br />
						<input type="checkbox" name="api" value="NON_REFERENCED_CREDIT" />NON_REFERENCED_CREDIT<br />
						<input type="checkbox" name="api" value="SETTLEMENT_CONSOLIDATION" />SETTLEMENT_CONSOLIDATION<br />
						<input type="checkbox" name="api" value="SETTLEMENT_REPORTING" />SETTLEMENT_REPORTING<br />
						<input type="checkbox" name="api" value="BUTTON_MANAGER" />BUTTON_MANAGER<br />
						<input type="checkbox" name="api"
							value="MANAGE_PENDING_TRANSACTION_STATUS" />MANAGE_PENDING_TRANSACTION_STATUS<br />
						<input type="checkbox" name="api" value="RECURRING_PAYMENT_REPORT" />RECURRING_PAYMENT_REPORT<br />
						<input type="checkbox" name="api"
							value="EXTENDED_PRO_PROCESSING_REPORT" />EXTENDED_PRO_PROCESSING_REPORT<br />
						<input type="checkbox" name="api"
							value="EXCEPTION_PROCESSING_REPORT" />EXCEPTION_PROCESSING_REPORT<br />
						<input type="checkbox" name="api"
							value="ACCOUNT_MANAGEMENT_PERMISSION" />ACCOUNT_MANAGEMENT_PERMISSION<br />
						<input type="checkbox" name="api" value="INVOICING" />INVOICING<br />
						<input type="checkbox" name="api"
							value="ACCESS_BASIC_PERSONAL_DATA" />ACCESS_BASIC_PERSONAL_DATA<br />
						<input type="checkbox" name="api"
							value="ACCESS_ADVANCED_PERSONAL_DATA" />ACCESS_ADVANCED_PERSONAL_DATA<br />
					</div>
				</div>
				<div class="submit">
					<input type="submit" name="PermissionBtn"
						value="RequestPermissions" /> <br />
				</div>
				<a href="index.html">Home</a>
			</div>
		</form>
	</div>
</body>
</html>
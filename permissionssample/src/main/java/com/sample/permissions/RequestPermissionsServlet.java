package com.sample.permissions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;
import com.paypal.svcs.services.PermissionsService;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.paypal.svcs.types.perm.RequestPermissionsRequest;
import com.paypal.svcs.types.perm.RequestPermissionsResponse;

/**
 * Servlet implementation class RequestPermissionsServlet
 */
public class RequestPermissionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestPermissionsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletConfig().getServletContext()
				.getRequestDispatcher("/RequestPermissions.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("url", request.getRequestURI());
		session.setAttribute("relatedUrl",
				"<ul><li><a href='RequestPermissions'>RequestPermissions</a></li><li><a href='GetAccessToken'>GetAccessToken</a></li><li><a href='GetPermissions'>GetPermissions</a></li><li><a href='CancelPermissions'>CancelPermissions</a></li><li><a href='GetBasicPersonalData'>GetBasicPersonalData</a></li><li><a href='GetAdvancedPersonalData'>GetAdvancedPersonalData</a></li></ul>");
		/*
		 * (Required) RFC 3066 language in which error messages are returned; 
		 * by default it is en_US, which is the only language currently supported.
		 */
		RequestEnvelope env = new RequestEnvelope("en_US");
		List<String> scope = new ArrayList<String>();
		/*
		 *  (Required) At least 1 of the following permission categories:

		    EXPRESS_CHECKOUT - Express Checkout
		    DIRECT_PAYMENT - Direct payment by debit or credit card
		    SETTLEMENT_CONSOLIDATION - Settlement consolidation
		    SETTLEMENT_REPORTING - Settlement reporting
		    AUTH_CAPTURE - Payment authorization and capture
		    MOBILE_CHECKOUT - Mobile checkout
		    BILLING_AGREEMENT - Billing agreements
		    REFERENCE_TRANSACTION - Reference transactions
		    AIR_TRAVEL - Express Checkout for UTAP
		    MASS_PAY - Mass pay
		    TRANSACTION_DETAILS - Transaction details
		    TRANSACTION_SEARCH - Transaction search
		    RECURRING_PAYMENTS - Recurring payments
		    ACCOUNT_BALANCE - Account balance
		    ENCRYPTED_WEBSITE_PAYMENTS - Encrypted website payments
		    REFUND - Refunds
		    NON_REFERENCED_CREDIT - Non-referenced credit
		    BUTTON_MANAGER - Button Manager
		    MANAGE_PENDING_TRANSACTION_STATUS includes ManagePendingTransactionStatus
		    RECURRING_PAYMENT_REPORT - Reporting for recurring payments
		    EXTENDED_PRO_PROCESSING_REPORT - Extended Pro processing
		    EXCEPTION_PROCESSING_REPORT - Exception processing
		    ACCOUNT_MANAGEMENT_PERMISSION - Account Management Permission (MAM)
		    ACCESS_BASIC_PERSONAL_DATA - User attributes
		    ACCESS_ADVANCED_PERSONAL_DATA - User attributes
		    INVOICING - Invoicing
		 */
		String check[] = request.getParameterValues("api");
		if (check != null) {
			for (int i = 0; i < check.length; i++) {
				scope.add(check[i]);
			}
		}
		response.setContentType("text/html");
		/*
		 * (Required) Your callback function that specifies actions to take after 
		 * the account holder grants or denies the request. 
		 */
		String callback = request.getParameter("callback");
		try {
			
			RequestPermissionsRequest permRequest = new RequestPermissionsRequest(
					scope, callback);
			permRequest.setRequestEnvelope(env);
			
			// ## Creating service wrapper object
			// Creating service wrapper object to make API call and loading
			// configuration file for your credentials and endpoint
			PermissionsService service = new PermissionsService(Configuration.getSignatureConfig());
			
			// ## Making API call
			// Invoke the appropriate method corresponding to API in service
			// wrapper object
			RequestPermissionsResponse resp = service.requestPermissions(permRequest);
			if (resp != null) {
				session.setAttribute("RESPONSE_OBJECT", resp);
				session.setAttribute("lastReq", service.getLastRequest());
				session.setAttribute("lastResp", service.getLastResponse());
				if (resp.getResponseEnvelope().getAck().toString()
						.equalsIgnoreCase("SUCCESS")) {
					Map<Object, Object> map = new LinkedHashMap<Object, Object>();
					/*
					 * Acknowledgement code. It is one of the following values:

					    Success – The operation completed successfully.
					    Failure – The operation failed.
					    Warning – Warning.
					    SuccessWithWarning – The operation completed successfully; however, there is a warning message.
					    FailureWithWarning – The operation failed with a warning message.
					 */
					map.put("Ack", resp.getResponseEnvelope().getAck());
					
					//(Required) A token from PayPal that enables the request to obtain permissions.
					map.put("RequestToken", resp.getToken());
					map.put("Redirect URL",
							"<a href=https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_grant-permission&request_token="
									+ resp.getToken()
									+ ">Redirect To PayPal</a>");
					session.setAttribute("map", map);
					response.sendRedirect("Response.jsp");
				} else {
					session.setAttribute("Error", resp.getError());
					response.sendRedirect("Error.jsp");
				}
			}

		} catch (OAuthException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SSLConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidCredentialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HttpErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidResponseDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientActionRequiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MissingCredentialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

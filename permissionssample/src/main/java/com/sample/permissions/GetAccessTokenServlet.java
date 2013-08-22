package com.sample.permissions;

import java.io.IOException;
import java.util.LinkedHashMap;
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
import com.paypal.svcs.types.perm.GetAccessTokenRequest;
import com.paypal.svcs.types.perm.GetAccessTokenResponse;

/**
 * Servlet implementation class GetAccessTokenServlet
 */
public class GetAccessTokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAccessTokenServlet() {
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
				.getRequestDispatcher("/GetAccessToken.jsp")
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
		session.setAttribute(
				"relatedUrl",
				"<ul><li><a href='RequestPermissions'>RequestPermissions</a></li><li><a href='GetAccessToken'>GetAccessToken</a></li><li><a href='GetPermissions'>GetPermissions</a></li><li><a href='CancelPermissions'>CancelPermissions</a></li><li><a href='GetBasicPersonalData'>GetBasicPersonalData</a></li><li><a href='GetAdvancedPersonalData'>GetAdvancedPersonalData</a></li></ul>");
		response.setContentType("text/html");
		try {
			
			// ## Creating service wrapper object
			// Creating service wrapper object to make API call 
			// Configuration map containing signature credentials and other required configuration.
			// For a full list of configuration parameters refer in wiki page. 
			// (https://github.com/paypal/sdk-core-java/wiki/SDK-Configuration-Parameters)
			PermissionsService service = new PermissionsService(Configuration.getAcctAndConfig());
			
			GetAccessTokenRequest tokenReq = new GetAccessTokenRequest();
			/*
			 * (Required) RFC 3066 language in which error messages are returned; 
			 * by default it is en_US, which is the only language currently supported.
			 */
			RequestEnvelope env = new RequestEnvelope("en_US");
			tokenReq.setRequestEnvelope(env);
			
			
			String text[] = request.getParameterValues("txtbox");
			int i = 0;
			if (text != null) {
				//(Required) The request token from the response to RequestPermissions. 
				tokenReq.setToken(text[i + 1]);
				//(Required) The verification code returned in the redirect from PayPal to the return URL. 
				tokenReq.setVerifier(text[i]);
			} else {
				tokenReq.setToken(request.getParameter("reqToken"));
				tokenReq.setVerifier(request.getParameter("verCode"));
			}
			
			// ## Making API call
			// Invoke the appropriate method corresponding to API in service
			// wrapper object
			GetAccessTokenResponse resp = service.getAccessToken(tokenReq);

			if (resp != null) {
				session.setAttribute("RESPONSE_OBJECT", resp);
				session.setAttribute("lastReq", service.getLastRequest());
				session.setAttribute("lastResp", service.getLastResponse());
				if (resp.getResponseEnvelope().getAck().toString()
						.equalsIgnoreCase("SUCCESS")) {
					Map<Object, Object> map = new LinkedHashMap<Object, Object>();
					/*
					 * Acknowledgement code. It is one of the following values:

					    Success - The operation completed successfully.
					    Failure - The operation failed.
					    Warning - Warning.
					    SuccessWithWarning - The operation completed successfully; however, there is a warning message.
					    FailureWithWarning - The operation failed with a warning message.

					 */
					map.put("Ack", resp.getResponseEnvelope().getAck());
					
					//The access token that identifies a set of permissions. 
					map.put("AccessToken", resp.getToken());
					
					//The secret associated with the access token. 
					map.put("TokenSecret", resp.getTokenSecret());
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

package com.sample.permissions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;
import com.paypal.svcs.services.PermissionsService;
import com.paypal.svcs.types.common.AckCode;
import com.paypal.svcs.types.common.ErrorData;
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
		RequestEnvelope env = new RequestEnvelope("en_US");
		List<String> scope = new ArrayList<String>();
		String check[] = request.getParameterValues("api");
		for (int i = 0; i < check.length; i++) {
			scope.add(check[i]);
		}
		response.setContentType("text/html");

		String callback = request.getParameter("callback");
		try {
			if (request.getParameter("PermissionBtn").equals(
					"RequestPermissions")) {
				RequestPermissionsRequest permRequest = new RequestPermissionsRequest(
						scope, callback);
				permRequest.setRequestEnvelope(env);
				PermissionsService perm = new PermissionsService(this
						.getServletContext().getRealPath("/")
						+ "/WEB-INF/sdk_config.properties");
				RequestPermissionsResponse permResponse = perm
						.requestPermissions(permRequest);

				response.getWriter().println(
						"Ack:" + permResponse.getResponseEnvelope().getAck()
								+ "<br/>");

				if (permResponse.getResponseEnvelope().getAck()
						.equals(AckCode.SUCCESS)) {
					response.getWriter()
							.println(
									"RequestToken:" + permResponse.getToken()
											+ "<br/>");
					response.getWriter()
							.println(
									"<a href=https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_grant-permission&request_token="
											+ permResponse.getToken()
											+ ">RedirectURL</a>");
				} else {
					Iterator iterator = permResponse.getError().iterator();
					while (iterator.hasNext()) {
						ErrorData error = (ErrorData) iterator.next();
						response.getWriter().println(
								"<br/>" + error.getMessage());
					}
				}
			}
			response.getWriter().println("<a href='index.html'>Home</a>");

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

package com.sample.permissions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
import com.paypal.svcs.types.perm.GetBasicPersonalDataRequest;
import com.paypal.svcs.types.perm.GetBasicPersonalDataResponse;
import com.paypal.svcs.types.perm.PersonalAttribute;
import com.paypal.svcs.types.perm.PersonalAttributeList;
import com.paypal.svcs.types.perm.PersonalData;

/**
 * Servlet implementation class GetBasicPersonalDataServlet
 */
public class GetBasicPersonalDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetBasicPersonalDataServlet() {
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
				.getRequestDispatcher("/GetBasicPersonalData.jsp")
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
		GetBasicPersonalDataRequest req = new GetBasicPersonalDataRequest();
		
		/*
		 * (Required) RFC 3066 language in which error messages are returned; 
		 * by default it is en_US, which is the only language currently supported.
		 */
		RequestEnvelope requestEnvelope = new RequestEnvelope("en_US");
		req.setRequestEnvelope(requestEnvelope);
		
		//(Required) The list of personal attributes requested for this account. 
		List<PersonalAttribute> lst = new ArrayList<PersonalAttribute>();
		String check[] = request.getParameterValues("attr");
		for (int i = 0; i < check.length; i++) {
			lst.add(PersonalAttribute.fromValue(check[i]));
		}
		PersonalAttributeList attribute = new PersonalAttributeList();
		attribute.setAttribute(lst);
		req.setAttributeList(attribute);
		
		// ## Creating service wrapper object
		// Creating service wrapper object to make API call and loading
		// configuration file for your credentials and endpoint
		PermissionsService service = new PermissionsService(Utility.getSignatureConfig());
		try {
			//The access token that identifies a set of permissions.
			service.setAccessToken(request.getParameter("accessToken"));
			//The secret associated with the access token. 
			service.setTokenSecret(request.getParameter("tokenSecret"));
			
			// ## Making API call
			// Invoke the appropriate method corresponding to API in service
			// wrapper object
			GetBasicPersonalDataResponse resp = service.getBasicPersonalData(req);
			response.setContentType("text/html");
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
					Iterator<PersonalData> iterator = resp.getResponse()
							.getPersonalData().iterator();
					int index = 1;
					while (iterator.hasNext()) {
						PersonalData personalData = iterator.next();
						/*
						 * The attributes whose values you are requesting. 
						 * You specify one or more of the following URIs:

						    http://axschema.org/namePerson/first – First name
						    http://axschema.org/namePerson/last – last name
						    http://axschema.org/contact/email – Email
						    http://schema.openid.net/contact/fullname – Full name
						    http://openid.net/schema/company/name – Business name
						    http://axschema.org/contact/country/home – Country
						    https://www.paypal.com/webapps/auth/schema/payerID – Payer ID
						 */
						map.put("PersonalDataKey" + index, personalData
								.getPersonalDataKey().getValue());
						
						//The value associated with the key
						map.put("PersonalDataValue" + index,
								personalData.getPersonalDataValue());
						index++;
					}
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

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

import com.paypal.core.credential.SignatureCredential;
import com.paypal.core.credential.ThirdPartyAuthorization;
import com.paypal.core.credential.TokenAuthorization;
import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;
import com.paypal.svcs.services.PermissionsService;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.paypal.svcs.types.perm.GetAdvancedPersonalDataRequest;
import com.paypal.svcs.types.perm.GetAdvancedPersonalDataResponse;
import com.paypal.svcs.types.perm.PersonalAttribute;
import com.paypal.svcs.types.perm.PersonalAttributeList;
import com.paypal.svcs.types.perm.PersonalData;

/**
 * Servlet implementation class GetAdvancedPersonalDataServlet
 */
public class GetAdvancedPersonalDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAdvancedPersonalDataServlet() {
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
				.getRequestDispatcher("/GetAdvancedPersonalData.jsp")
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

		GetAdvancedPersonalDataRequest req = new GetAdvancedPersonalDataRequest();
		/*
		 * (Required) RFC 3066 language in which error messages are returned; by
		 * default it is en_US, which is the only language currently supported.
		 */
		RequestEnvelope requestEnvelope = new RequestEnvelope("en_US");
		req.setRequestEnvelope(requestEnvelope);

		/*
		 * The attributes whose value you are requesting. You specify one or
		 * more of the following URIs:
		 * 
		 * http://axschema.org/birthDate – Date of birth
		 * http://axschema.org/contact/postalCode/home – Postcode
		 * http://schema.openid.net/contact/street1 – Street1
		 * http://schema.openid.net/contact/street2 – Street2
		 * http://axschema.org/contact/city/home – City
		 * http://axschema.org/contact/state/home – State
		 * http://axschema.org/contact/phone/default – Phone
		 */
		List<PersonalAttribute> lst = new ArrayList<PersonalAttribute>();
		String check[] = request.getParameterValues("attr");
		for (int i = 0; i < check.length; i++) {
			lst.add(PersonalAttribute.fromValue(check[i]));
		}
		PersonalAttributeList attribute = new PersonalAttributeList();
		attribute.setAttribute(lst);
		req.setAttributeList(attribute);

		SignatureCredential cred = null;
		if (request.getParameter("accessToken") != null
				&& request.getParameter("accessToken").length() > 0
				&& request.getParameter("tokenSecret") != null
				&& request.getParameter("tokenSecret").length() > 0) {
			// The access token that identifies a set of permissions.
			// The secret associated with the access token.
			ThirdPartyAuthorization thirdPartyAuth = new TokenAuthorization(
					request.getParameter("accessToken"),
					request.getParameter("tokenSecret"));

			SignatureCredential cred = new SignatureCredential(
					"jb-us-seller_api1.paypal.com", "WX4WTU3S8MY44S7F",
					"AFcWxV21C7fd0v3bYYYRCpSSRl31A7yDhhsPUU2XhtMoZXsWHFxu-RWy");

			cred.setApplicationId("APP-80W284485P519543T");
			cred.setThirdPartyAuthorization(thirdPartyAuth);
		}
		// ## Creating service wrapper object
		// Creating service wrapper object to make API call
		// Configuration map containing mode and other required configuration.
		// For a full list of configuration parameters refer in wiki page.
		// (https://github.com/paypal/sdk-core-java/wiki/SDK-Configuration-Parameters)
		PermissionsService service = new PermissionsService(
				Configuration.getAcctAndConfig());
		try {

			// ## Making API call
			// Invoke the appropriate method corresponding to API in service
			// wrapper object
			GetAdvancedPersonalDataResponse resp = null;
			if (cred != null) {
				resp = service.getAdvancedPersonalData(req, cred);
			} else {
				resp = service.getAdvancedPersonalData(req);
			}
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
					 * 
					 * Success – The operation completed successfully. Failure –
					 * The operation failed. Warning – Warning.
					 * SuccessWithWarning – The operation completed
					 * successfully; however, there is a warning message.
					 * FailureWithWarning – The operation failed with a warning
					 * message.
					 */
					map.put("Ack", resp.getResponseEnvelope().getAck());
					Iterator<PersonalData> iterator = resp.getResponse()
							.getPersonalData().iterator();
					int index = 1;
					while (iterator.hasNext()) {
						PersonalData personalData = iterator.next();
						/*
						 * The attributes whose values you are requesting. You
						 * specify one or more of the following URIs:
						 * 
						 * http://axschema.org/namePerson/first – First name
						 * http://axschema.org/namePerson/last – last name
						 * http://axschema.org/contact/email – Email
						 * http://schema.openid.net/contact/fullname – Full name
						 * http://openid.net/schema/company/name – Business name
						 * http://axschema.org/contact/country/home – Country
						 * https://www.paypal.com/webapps/auth/schema/payerID –
						 * Payer ID
						 */
						map.put("PersonalDataKey" + index, personalData
								.getPersonalDataKey().getValue());

						// The value associated with the key
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

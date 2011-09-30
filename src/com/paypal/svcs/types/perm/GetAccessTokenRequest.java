
/**
 * Auto generated code
 */

package com.paypal.svcs.types.perm;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;


/**
 * The request use to retrieve a permanent access
 * token. The client can either send the token and
 * verifier, or a subject.
 */
public class GetAccessTokenRequest {

	/**
	 */
	private RequestEnvelope requestEnvelope;
	public RequestEnvelope getRequestEnvelope() {
		return requestEnvelope;
	}
	public void setRequestEnvelope(RequestEnvelope value) {
		this.requestEnvelope = value;
	}

	/**
	 * The temporary request token received
	 * from the RequestPermissions call.
	 */
	private String token;
	public String getToken() {
		return token;
	}
	public void setToken(String value) {
		this.token = value;
	}

	/**
	 * The verifier code returned to the client
	 * after the user authorization flow
	 * completed.
	 */
	private String verifier;
	public String getVerifier() {
		return verifier;
	}
	public void setVerifier(String value) {
		this.verifier = value;
	}

	/**
	 * The subject email address used to
	 * represent existing 3rd Party Permissions
	 * relationship. This field can be used in
	 * lieu of the token and verifier.
	 */
	private String subjectAlias;
	public String getSubjectAlias() {
		return subjectAlias;
	}
	public void setSubjectAlias(String value) {
		this.subjectAlias = value;
	}



	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( requestEnvelope != null ) {
			String newPrefix = prefix + "requestEnvelope.";
			sb.append(requestEnvelope.toNVPString(newPrefix));
		}
		if( token != null ) {
			sb.append(prefix).append("token=").append(NVPUtil.encodeUrl(token));
			sb.append('&');
		}
		if( verifier != null ) {
			sb.append(prefix).append("verifier=").append(NVPUtil.encodeUrl(verifier));
			sb.append('&');
		}
		if( subjectAlias != null ) {
			sb.append(prefix).append("subjectAlias=").append(NVPUtil.encodeUrl(subjectAlias));
			sb.append('&');
		}
		return sb.toString();
	}

}

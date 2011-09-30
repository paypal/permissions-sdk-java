
/**
 * Auto generated code
 */

package com.paypal.svcs.types.perm;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;


/**
 * Request to retrieve the approved list of
 * permissions associated with a token.
 */
public class GetPermissionsRequest {

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
	 * The permanent access token to ask about.
	 *
	 * @Required
	 */
	private String token;
	public String getToken() {
		return token;
	}
	public void setToken(String value) {
		this.token = value;
	}


	public GetPermissionsRequest(String token) {
		this.token = token;
	}
	public GetPermissionsRequest() {
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
		return sb.toString();
	}

}

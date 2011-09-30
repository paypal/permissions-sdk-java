
/**
 * Auto generated code
 */

package com.paypal.svcs.types.perm;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;


/**
 * Request to invalidate an access token and revoke
 * the permissions associated with it.
 */
public class CancelPermissionsRequest {

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


	public CancelPermissionsRequest(String token) {
		this.token = token;
	}
	public CancelPermissionsRequest() {
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


/**
 * Auto generated code
 */

package com.paypal.svcs.types.perm;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * Describes the request for permissions over an
 * account. Primary element is "scope", which lists
 * the permissions needed.
 */
public class RequestPermissionsRequest {

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
	 * URI of the permissions being requested.
	 *
	 * @Required
	 */
	private List<String> scope = new ArrayList<String>();
	public List<String> getScope() {
		return scope;
	}
	public void setScope(List<String> value) {
		this.scope = value;
	}

	/**
	 * URL on the client side that will be used
	 * to communicate completion of the user
	 * flow. The URL can include query
	 * parameters.
	 *
	 * @Required
	 */
	private String callback;
	public String getCallback() {
		return callback;
	}
	public void setCallback(String value) {
		this.callback = value;
	}


	public RequestPermissionsRequest(List<String> scope, String callback) {
		this.scope = scope;
		this.callback = callback;
	}
	public RequestPermissionsRequest() {
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
		if( scope != null ) {
			for(int i=0; i<scope.size(); i++) {
				sb.append(prefix).append("scope(").append(i).append(")=").append(NVPUtil.encodeUrl(scope.get(i)));
				sb.append('&');
			}
		}
		if( callback != null ) {
			sb.append(prefix).append("callback=").append(NVPUtil.encodeUrl(callback));
			sb.append('&');
		}
		return sb.toString();
	}

}

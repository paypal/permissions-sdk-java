
/**
 * Auto generated code
 */

package com.paypal.svcs.types.common;

import com.paypal.core.NVPUtil;
import java.io.UnsupportedEncodingException;


/**
 * This specifies the list of parameters with every
 * request to the service.
 */
public class RequestEnvelope {

	/**
	 * This should be the standard RFC 3066
	 * language identification tag, e.g.,
	 * en_US.
	 *
	 * @Required
	 */
	private String errorLanguage;
	public String getErrorLanguage() {
		return errorLanguage;
	}
	public void setErrorLanguage(String value) {
		this.errorLanguage = value;
	}


	public RequestEnvelope(String errorLanguage) {
		this.errorLanguage = errorLanguage;
	}
	public RequestEnvelope() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( errorLanguage != null ) {
			sb.append(prefix).append("errorLanguage=").append(NVPUtil.encodeUrl(errorLanguage));
			sb.append('&');
		}
		return sb.toString();
	}

}

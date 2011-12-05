
/**
 * Auto generated code
 */

package com.paypal.svcs.types.perm;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.paypal.svcs.types.perm.PersonalAttributeList;
import java.io.UnsupportedEncodingException;


/**
 * Request to retrieve personal data.Accepts PersonalAttributeList as request and responds with PersonalDataList.
 * This call will accept both 'Basic' and Advanced attributes. 
 */
public class GetAdvancedPersonalDataRequest {

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
	private PersonalAttributeList attributeList;
	public PersonalAttributeList getAttributeList() {
		return attributeList;
	}
	public void setAttributeList(PersonalAttributeList value) {
		this.attributeList = value;
	}


	public GetAdvancedPersonalDataRequest(PersonalAttributeList attributeList) {
		this.attributeList = attributeList;
	}
	public GetAdvancedPersonalDataRequest() {
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
		if( attributeList != null ) {
			String newPrefix = prefix + "attributeList.";
			sb.append(attributeList.toNVPString(newPrefix));
		}
		return sb.toString();
	}

}

package com.paypal.svcs.types.perm;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.paypal.svcs.types.perm.PersonalAttributeList;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * Request to retrieve personal data.Accepts
 * PersonalAttributeList as request and responds with
 * PersonalDataList. This call will accept both 'Basic' and
 * Advanced attributes. 
 */
public class GetAdvancedPersonalDataRequest{


	/**
	 * 	 
	 */ 
	private RequestEnvelope requestEnvelope;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private PersonalAttributeList attributeList;

	

	/**
	 * Constructor with arguments
	 */
	public GetAdvancedPersonalDataRequest (PersonalAttributeList attributeList){
		this.attributeList = attributeList;
	}	

	/**
	 * Default Constructor
	 */
	public GetAdvancedPersonalDataRequest (){
	}	

	/**
	 * Getter for requestEnvelope
	 */
	 public RequestEnvelope getRequestEnvelope() {
	 	return requestEnvelope;
	 }
	 
	/**
	 * Setter for requestEnvelope
	 */
	 public void setRequestEnvelope(RequestEnvelope requestEnvelope) {
	 	this.requestEnvelope = requestEnvelope;
	 }
	 
	/**
	 * Getter for attributeList
	 */
	 public PersonalAttributeList getAttributeList() {
	 	return attributeList;
	 }
	 
	/**
	 * Setter for attributeList
	 */
	 public void setAttributeList(PersonalAttributeList attributeList) {
	 	this.attributeList = attributeList;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (requestEnvelope != null) {
			String newPrefix = prefix + "requestEnvelope.";
			sb.append(requestEnvelope.toNVPString(newPrefix));
		}
		if (attributeList != null) {
			String newPrefix = prefix + "attributeList.";
			sb.append(attributeList.toNVPString(newPrefix));
		}
		return sb.toString();
	}

}
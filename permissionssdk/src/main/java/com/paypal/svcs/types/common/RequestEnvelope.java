package com.paypal.svcs.types.common;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * This specifies the list of parameters with every request to
 * the service. 
 */
public class RequestEnvelope{


	/**
	 * This should be the standard RFC 3066 language identification
	 * tag, e.g., en_US. 	  
	 *@Required	 
	 */ 
	private String errorLanguage;

	

	/**
	 * Constructor with arguments
	 */
	public RequestEnvelope (String errorLanguage){
		this.errorLanguage = errorLanguage;
	}	

	/**
	 * Default Constructor
	 */
	public RequestEnvelope (){
	}	

	/**
	 * Getter for errorLanguage
	 */
	 public String getErrorLanguage() {
	 	return errorLanguage;
	 }
	 
	/**
	 * Setter for errorLanguage
	 */
	 public void setErrorLanguage(String errorLanguage) {
	 	this.errorLanguage = errorLanguage;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (errorLanguage != null) {
			sb.append(prefix).append("errorLanguage=").append(NVPUtil.encodeUrl(errorLanguage));
			sb.append("&");
		}
		return sb.toString();
	}

}
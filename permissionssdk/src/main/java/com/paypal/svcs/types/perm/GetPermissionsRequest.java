package com.paypal.svcs.types.perm;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * Request to retrieve the approved list of permissions
 * associated with a token. 
 */
public class GetPermissionsRequest{


	/**
	 * 	 
	 */ 
	private RequestEnvelope requestEnvelope;

	/**
	 * The permanent access token to ask about. 	  
	 *@Required	 
	 */ 
	private String token;

	

	/**
	 * Constructor with arguments
	 */
	public GetPermissionsRequest (String token){
		this.token = token;
	}	

	/**
	 * Default Constructor
	 */
	public GetPermissionsRequest (){
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
	 * Getter for token
	 */
	 public String getToken() {
	 	return token;
	 }
	 
	/**
	 * Setter for token
	 */
	 public void setToken(String token) {
	 	this.token = token;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.requestEnvelope != null) {
			String newPrefix = prefix + "requestEnvelope.";
			sb.append(this.requestEnvelope.toNVPString(newPrefix));
		}
		if (this.token != null) {
			sb.append(prefix).append("token=").append(NVPUtil.encodeUrl(this.token));
			sb.append("&");
		}
		return sb.toString();
	}

}
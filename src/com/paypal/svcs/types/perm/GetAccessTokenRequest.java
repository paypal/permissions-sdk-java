package com.paypal.svcs.types.perm;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * The request use to retrieve a permanent access token. The
 * client can either send the token and verifier, or a subject.
 * 
 */
public class GetAccessTokenRequest{


	/**
	 * No Document Comments	 
	 */ 
	private RequestEnvelope requestEnvelope;

	/**
	 * The temporary request token received from the
	 * RequestPermissions call. 	 
	 */ 
	private String token;

	/**
	 * The verifier code returned to the client after the user
	 * authorization flow completed. 	 
	 */ 
	private String verifier;

	/**
	 * The subject email address used to represent existing 3rd
	 * Party Permissions relationship. This field can be used in
	 * lieu of the token and verifier. 	 
	 */ 
	private String subjectAlias;

	

	/**
	 * Default Constructor
	 */
	public GetAccessTokenRequest (){
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
	 
	/**
	 * Getter for verifier
	 */
	 public String getVerifier() {
	 	return verifier;
	 }
	 
	/**
	 * Setter for verifier
	 */
	 public void setVerifier(String verifier) {
	 	this.verifier = verifier;
	 }
	 
	/**
	 * Getter for subjectAlias
	 */
	 public String getSubjectAlias() {
	 	return subjectAlias;
	 }
	 
	/**
	 * Setter for subjectAlias
	 */
	 public void setSubjectAlias(String subjectAlias) {
	 	this.subjectAlias = subjectAlias;
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
		if (token != null) {
			sb.append(prefix).append("token=").append(NVPUtil.encodeUrl(token));
			sb.append("&");
		}
		if (verifier != null) {
			sb.append(prefix).append("verifier=").append(NVPUtil.encodeUrl(verifier));
			sb.append("&");
		}
		if (subjectAlias != null) {
			sb.append(prefix).append("subjectAlias=").append(NVPUtil.encodeUrl(subjectAlias));
			sb.append("&");
		}
		return sb.toString();
	}

}
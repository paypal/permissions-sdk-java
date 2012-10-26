package com.paypal.svcs.types.perm;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.util.List;
import java.util.ArrayList;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * Describes the request for permissions over an account.
 * Primary element is "scope", which lists the permissions
 * needed. 
 */
public class RequestPermissionsRequest{

	private static final String nameSpace="com.paypal.svcs.types.perm";
	private static final String preferredPrefix="";

	/**
	 * 	 
	 */ 
	private RequestEnvelope requestEnvelope;

	/**
	 * URI of the permissions being requested. 	  
	 *@Required	 
	 */ 
	private List<String> scope = new ArrayList<String>();

	/**
	 * URL on the client side that will be used to communicate
	 * completion of the user flow. The URL can include query
	 * parameters. 	  
	 *@Required	 
	 */ 
	private String callback;

	

	/**
	 * Constructor with arguments
	 */
	public RequestPermissionsRequest (List<String> scope, String callback){
		this.scope = scope;
		this.callback = callback;
	}	

	/**
	 * Default Constructor
	 */
	public RequestPermissionsRequest (){
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
	 * Getter for scope
	 */
	 public List<String> getScope() {
	 	return scope;
	 }
	 
	/**
	 * Setter for scope
	 */
	 public void setScope(List<String> scope) {
	 	this.scope = scope;
	 }
	 
	/**
	 * Getter for callback
	 */
	 public String getCallback() {
	 	return callback;
	 }
	 
	/**
	 * Setter for callback
	 */
	 public void setCallback(String callback) {
	 	this.callback = callback;
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
		if (scope != null) {
			for(int i=0; i < scope.size(); i++) {
				sb.append(prefix).append("scope(").append(i).append(")=").append(NVPUtil.encodeUrl(scope.get(i)));
				sb.append("&");
			}
		}
		if (callback != null) {
			sb.append(prefix).append("callback=").append(NVPUtil.encodeUrl(callback));
			sb.append("&");
		}
		return sb.toString();
	}

}
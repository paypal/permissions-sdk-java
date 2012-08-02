package com.paypal.svcs.types.perm;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * Permanent access token and token secret that can be used to
 * make requests for protected resources owned by another
 * account. 
 */
public class GetAccessTokenResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * Identifier for the permissions approved for this
	 * relationship. 	 
	 */ 
	private List<String> scope = new ArrayList<String>();

	/**
	 * Permanent access token that identifies the relationship that
	 * the user authorized. 	 
	 */ 
	private String token;

	/**
	 * The token secret/password that will need to be used when
	 * generating the signature. 	 
	 */ 
	private String tokenSecret;

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public GetAccessTokenResponse (){
	}	

	/**
	 * Getter for responseEnvelope
	 */
	 public ResponseEnvelope getResponseEnvelope() {
	 	return responseEnvelope;
	 }
	 
	/**
	 * Setter for responseEnvelope
	 */
	 public void setResponseEnvelope(ResponseEnvelope responseEnvelope) {
	 	this.responseEnvelope = responseEnvelope;
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
	 * Getter for tokenSecret
	 */
	 public String getTokenSecret() {
	 	return tokenSecret;
	 }
	 
	/**
	 * Setter for tokenSecret
	 */
	 public void setTokenSecret(String tokenSecret) {
	 	this.tokenSecret = tokenSecret;
	 }
	 
	/**
	 * Getter for error
	 */
	 public List<ErrorData> getError() {
	 	return error;
	 }
	 
	/**
	 * Setter for error
	 */
	 public void setError(List<ErrorData> error) {
	 	this.error = error;
	 }
	 


	
	public static GetAccessTokenResponse createInstance(Map<String, String> map, String prefix, int index) {
		GetAccessTokenResponse getAccessTokenResponse = null;
		int i = 0;
		if (index != -1) {
				if (!prefix.isEmpty() && !prefix.endsWith(".")) {
					prefix = prefix + "(" + index + ").";
				}
		} else {
			if (!prefix.isEmpty() && !prefix.endsWith(".")) {
				prefix = prefix + ".";
			}
		}
			
		ResponseEnvelope responseEnvelope =  ResponseEnvelope.createInstance(map, prefix + "responseEnvelope", -1);
		if (responseEnvelope != null) {
			getAccessTokenResponse = (getAccessTokenResponse == null) ? new GetAccessTokenResponse() : getAccessTokenResponse;
			getAccessTokenResponse.setResponseEnvelope(responseEnvelope);
		}
		i = 0;
		while(true) {
			if (map.containsKey(prefix + "scope" + "(" + i + ")")) {
				getAccessTokenResponse = (getAccessTokenResponse == null) ? new GetAccessTokenResponse() : getAccessTokenResponse;
				getAccessTokenResponse.getScope().add(map.get(prefix + "scope" + "(" + i + ")"));
				i++;
			} else {
				break;
			}
		}
		if (map.containsKey(prefix + "token")) {
				getAccessTokenResponse = (getAccessTokenResponse == null) ? new GetAccessTokenResponse() : getAccessTokenResponse;
				getAccessTokenResponse.setToken(map.get(prefix + "token"));
		}
		if (map.containsKey(prefix + "tokenSecret")) {
				getAccessTokenResponse = (getAccessTokenResponse == null) ? new GetAccessTokenResponse() : getAccessTokenResponse;
				getAccessTokenResponse.setTokenSecret(map.get(prefix + "tokenSecret"));
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				getAccessTokenResponse = (getAccessTokenResponse == null) ? new GetAccessTokenResponse() : getAccessTokenResponse;
				getAccessTokenResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return getAccessTokenResponse;
	}
 
}
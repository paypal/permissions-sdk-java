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
	 


	public GetAccessTokenResponse(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "responseEnvelope" + ".timestamp")){
			String newPrefix = prefix + "responseEnvelope" + ".";
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "scope" + "(" + i + ")")){
			this.scope.add(map.get(prefix + "scope" + "(" + i + ")"));
			} else {
				break;
			}
			i++;
		}
		if(map.containsKey(prefix + "token")){
			this.token = map.get(prefix + "token");
		}
		if(map.containsKey(prefix + "tokenSecret")){
			this.tokenSecret = map.get(prefix + "tokenSecret");
		}
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "error" + "(" + i + ")" + ".errorId")){
				String newPrefix = prefix + "error" + "(" + i + ")" + ".";
				this.error.add(new ErrorData(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
	}

}
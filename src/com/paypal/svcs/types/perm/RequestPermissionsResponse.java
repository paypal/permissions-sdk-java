package com.paypal.svcs.types.perm;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * Returns the temporary request token 
 */
public class RequestPermissionsResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * Temporary token that identifies the request for permissions.
	 * This token cannot be used to access resources on the
	 * account. It can only be used to instruct the user to
	 * authorize the permissions. 	 
	 */ 
	private String token;

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public RequestPermissionsResponse (){
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
	 


	
	public static RequestPermissionsResponse createInstance(Map<String, String> map, String prefix, int index) {
		RequestPermissionsResponse requestPermissionsResponse = null;
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
			requestPermissionsResponse = (requestPermissionsResponse == null) ? new RequestPermissionsResponse() : requestPermissionsResponse;
			requestPermissionsResponse.setResponseEnvelope(responseEnvelope);
		}
		if (map.containsKey(prefix + "token")) {
				requestPermissionsResponse = (requestPermissionsResponse == null) ? new RequestPermissionsResponse() : requestPermissionsResponse;
				requestPermissionsResponse.setToken(map.get(prefix + "token"));
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				requestPermissionsResponse = (requestPermissionsResponse == null) ? new RequestPermissionsResponse() : requestPermissionsResponse;
				requestPermissionsResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return requestPermissionsResponse;
	}
 
}
package com.paypal.svcs.types.perm;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * The list of permissions associated with the token. 
 */
public class GetPermissionsResponse{


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
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public GetPermissionsResponse (){
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
	 


	
	public static GetPermissionsResponse createInstance(Map<String, String> map, String prefix, int index) {
		GetPermissionsResponse getPermissionsResponse = null;
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
			getPermissionsResponse = (getPermissionsResponse == null) ? new GetPermissionsResponse() : getPermissionsResponse;
			getPermissionsResponse.setResponseEnvelope(responseEnvelope);
		}
		i = 0;
		while(true) {
			if (map.containsKey(prefix + "scope" + "(" + i + ")")) {
				getPermissionsResponse = (getPermissionsResponse == null) ? new GetPermissionsResponse() : getPermissionsResponse;
				getPermissionsResponse.getScope().add(map.get(prefix + "scope" + "(" + i + ")"));
				i++;
			} else {
				break;
			}
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				getPermissionsResponse = (getPermissionsResponse == null) ? new GetPermissionsResponse() : getPermissionsResponse;
				getPermissionsResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return getPermissionsResponse;
	}
 
}
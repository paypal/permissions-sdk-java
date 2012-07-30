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
	 


	public GetPermissionsResponse(Map<String, String> map, String prefix) {
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
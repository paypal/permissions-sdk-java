
/**
 * Auto generated code
 */

package com.paypal.svcs.types.perm;

import com.paypal.svcs.types.common.ErrorData;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * The list of permissions associated with the
 * token.
 */
public class GetPermissionsResponse {

	/**
	 *
	 * @Required
	 */
	private ResponseEnvelope responseEnvelope;
	public ResponseEnvelope getResponseEnvelope() {
		return responseEnvelope;
	}
	public void setResponseEnvelope(ResponseEnvelope value) {
		this.responseEnvelope = value;
	}

	/**
	 * Identifier for the permissions approved
	 * for this relationship.
	 */
	private List<String> scope = new ArrayList<String>();
	public List<String> getScope() {
		return scope;
	}
	public void setScope(List<String> value) {
		this.scope = value;
	}

	/**
	 */
	private List<ErrorData> error = new ArrayList<ErrorData>();
	public List<ErrorData> getError() {
		return error;
	}
	public void setError(List<ErrorData> value) {
		this.error = value;
	}


	public GetPermissionsResponse() {
	}
	public GetPermissionsResponse(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "responseEnvelope" + ".timestamp") ) {
			String newPrefix = prefix + "responseEnvelope" + '.';
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "scope" + '(' + i + ')') ) {
				this.scope.add(map.get(prefix + "scope" + '(' + i + ')'));
			}
			else break;
			i++;
		}
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "error" + '(' + i + ')'+ ".errorId") ) {
				String newPrefix = prefix + "error" + '(' + i + ')' + '.';
				this.error.add(new ErrorData(map, newPrefix));
			}
			else break;
			i++;
		}
	}
}

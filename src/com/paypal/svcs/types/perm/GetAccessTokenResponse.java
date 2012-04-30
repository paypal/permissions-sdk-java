
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
 * Permanent access token and token secret that can
 * be used to make requests for protected resources
 * owned by another account.
 */
public class GetAccessTokenResponse {

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
	 * Permanent access token that identifies
	 * the relationship that the user
	 * authorized.
	 */
	private String token;
	public String getToken() {
		return token;
	}
	public void setToken(String value) {
		this.token = value;
	}

	/**
	 * The token secret/password that will need
	 * to be used when generating the
	 * signature.
	 */
	private String tokenSecret;
	public String getTokenSecret() {
		return tokenSecret;
	}
	public void setTokenSecret(String value) {
		this.tokenSecret = value;
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


	public GetAccessTokenResponse() {
	}
	public GetAccessTokenResponse(Map<String, String> map, String prefix) {
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
		if( map.containsKey(prefix + "token") ) {
			this.token = map.get(prefix + "token");
		}
		if( map.containsKey(prefix + "tokenSecret") ) {
			this.tokenSecret = map.get(prefix + "tokenSecret");
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


/**
 * Auto generated code
 */

package com.paypal.svcs.types.perm;

import com.paypal.svcs.types.common.ErrorData;
import com.paypal.svcs.types.common.ResponseEnvelope;
import com.paypal.svcs.types.perm.PersonalDataList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 */
public class GetBasicPersonalDataResponse {

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
	 */
	private PersonalDataList response;
	public PersonalDataList getResponse() {
		return response;
	}
	public void setResponse(PersonalDataList value) {
		this.response = value;
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


	public GetBasicPersonalDataResponse() {
	}
	public GetBasicPersonalDataResponse(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "responseEnvelope" + ".timestamp") ) {
			String newPrefix = prefix + "responseEnvelope" + '.';
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		if( map.containsKey(prefix + "response" + ".personalData(0).personalDataValue") ) {
			String newPrefix = prefix + "response" + '.';
			this.response =  new PersonalDataList(map, newPrefix);
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

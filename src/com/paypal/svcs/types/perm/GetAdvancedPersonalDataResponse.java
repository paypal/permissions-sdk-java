package com.paypal.svcs.types.perm;
import com.paypal.svcs.types.common.ResponseEnvelope;
import com.paypal.svcs.types.perm.PersonalDataList;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * 
 */
public class GetAdvancedPersonalDataResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * 	 
	 */ 
	private PersonalDataList response;

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public GetAdvancedPersonalDataResponse (){
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
	 * Getter for response
	 */
	 public PersonalDataList getResponse() {
	 	return response;
	 }
	 
	/**
	 * Setter for response
	 */
	 public void setResponse(PersonalDataList response) {
	 	this.response = response;
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
	 


	
	public static GetAdvancedPersonalDataResponse createInstance(Map<String, String> map, String prefix, int index) {
		GetAdvancedPersonalDataResponse getAdvancedPersonalDataResponse = null;
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
			getAdvancedPersonalDataResponse = (getAdvancedPersonalDataResponse == null) ? new GetAdvancedPersonalDataResponse() : getAdvancedPersonalDataResponse;
			getAdvancedPersonalDataResponse.setResponseEnvelope(responseEnvelope);
		}
		PersonalDataList response =  PersonalDataList.createInstance(map, prefix + "response", -1);
		if (response != null) {
			getAdvancedPersonalDataResponse = (getAdvancedPersonalDataResponse == null) ? new GetAdvancedPersonalDataResponse() : getAdvancedPersonalDataResponse;
			getAdvancedPersonalDataResponse.setResponse(response);
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				getAdvancedPersonalDataResponse = (getAdvancedPersonalDataResponse == null) ? new GetAdvancedPersonalDataResponse() : getAdvancedPersonalDataResponse;
				getAdvancedPersonalDataResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return getAdvancedPersonalDataResponse;
	}
 
}
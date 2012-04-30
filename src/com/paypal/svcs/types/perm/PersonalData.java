
/**
 * Auto generated code
 */

package com.paypal.svcs.types.perm;

import com.paypal.svcs.types.perm.PersonalAttribute;
import java.util.Map;


/**
 * A property of User Identity data , represented as a Name-value pair with Name being the PersonalAttribute requested and value being the data.
 */
public class PersonalData {

	/**
	 *
	 * @Required
	 */
	private PersonalAttribute personalDataKey;
	public PersonalAttribute getPersonalDataKey() {
		return personalDataKey;
	}
	public void setPersonalDataKey(PersonalAttribute value) {
		this.personalDataKey = value;
	}

	/**
	 *
	 * @Required
	 */
	private String personalDataValue;
	public String getPersonalDataValue() {
		return personalDataValue;
	}
	public void setPersonalDataValue(String value) {
		this.personalDataValue = value;
	}


	public PersonalData() {
	}
	public PersonalData(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "personalDataKey") ) {
			this.personalDataKey = PersonalAttribute.fromValue( map.get(prefix + "personalDataKey") );
		}
		if( map.containsKey(prefix + "personalDataValue") ) {
			this.personalDataValue = map.get(prefix + "personalDataValue");
		}
	}
}


/**
 * Auto generated code
 */

package com.paypal.svcs.types.perm;

import com.paypal.svcs.types.perm.PersonalData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Set of personal data which forms the response of GetPersonalData call.
 */
public class PersonalDataList {

	/**
	 */
	private List<PersonalData> personalData = new ArrayList<PersonalData>();
	public List<PersonalData> getPersonalData() {
		return personalData;
	}
	public void setPersonalData(List<PersonalData> value) {
		this.personalData = value;
	}


	public PersonalDataList() {
	}
	public PersonalDataList(Map<String, String> map, String prefix) {
		int i=0; 
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "personalData" + '(' + i + ')'+ ".personalDataValue") ) {
				String newPrefix = prefix + "personalData" + '(' + i + ')' + '.';
				this.personalData.add(new PersonalData(map, newPrefix));
			}
			else break;
			i++;
		}
	}
}

package com.paypal.svcs.types.perm;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.perm.PersonalData;
import java.util.Map;

/**
 * Set of personal data which forms the response of
 * GetPersonalData call. 
 */
public class PersonalDataList{


	/**
	 * 	 
	 */ 
	private List<PersonalData> personalData = new ArrayList<PersonalData>();

	

	/**
	 * Default Constructor
	 */
	public PersonalDataList (){
	}	

	/**
	 * Getter for personalData
	 */
	 public List<PersonalData> getPersonalData() {
	 	return personalData;
	 }
	 
	/**
	 * Setter for personalData
	 */
	 public void setPersonalData(List<PersonalData> personalData) {
	 	this.personalData = personalData;
	 }
	 


	public PersonalDataList(Map<String, String> map, String prefix) {
		int i = 0;
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "personalData" + "(" + i + ")" + ".personalDataValue")){
				String newPrefix = prefix + "personalData" + "(" + i + ")" + ".";
				this.personalData.add(new PersonalData(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
	}

}
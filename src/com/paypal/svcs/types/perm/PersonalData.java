package com.paypal.svcs.types.perm;
import com.paypal.svcs.types.perm.PersonalAttribute;
import java.util.Map;

/**
 * A property of User Identity data , represented as a
 * Name-value pair with Name being the PersonalAttribute
 * requested and value being the data. 
 */
public class PersonalData{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private PersonalAttribute personalDataKey;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String personalDataValue;

	

	/**
	 * Default Constructor
	 */
	public PersonalData (){
	}	

	/**
	 * Getter for personalDataKey
	 */
	 public PersonalAttribute getPersonalDataKey() {
	 	return personalDataKey;
	 }
	 
	/**
	 * Setter for personalDataKey
	 */
	 public void setPersonalDataKey(PersonalAttribute personalDataKey) {
	 	this.personalDataKey = personalDataKey;
	 }
	 
	/**
	 * Getter for personalDataValue
	 */
	 public String getPersonalDataValue() {
	 	return personalDataValue;
	 }
	 
	/**
	 * Setter for personalDataValue
	 */
	 public void setPersonalDataValue(String personalDataValue) {
	 	this.personalDataValue = personalDataValue;
	 }
	 


	
	public static PersonalData createInstance(Map<String, String> map, String prefix, int index) {
		PersonalData personalData = null;
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
			
		if (map.containsKey(prefix + "personalDataKey")) {
				personalData = (personalData == null) ? new PersonalData() : personalData;
				personalData.setPersonalDataKey(PersonalAttribute.fromValue(map.get(prefix + "personalDataKey")));
		}
		if (map.containsKey(prefix + "personalDataValue")) {
				personalData = (personalData == null) ? new PersonalData() : personalData;
				personalData.setPersonalDataValue(map.get(prefix + "personalDataValue"));
		}
		return personalData;
	}
 
}
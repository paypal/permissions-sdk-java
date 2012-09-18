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
	 


	
	public static PersonalDataList createInstance(Map<String, String> map, String prefix, int index) {
		PersonalDataList personalDataList = null;
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
			
		i = 0;
		while(true) {
			PersonalData personalData =  PersonalData.createInstance(map, prefix + "personalData", i);
			if (personalData != null) {
				personalDataList = (personalDataList == null) ? new PersonalDataList() : personalDataList;
				personalDataList.getPersonalData().add(personalData);
				i++;
			} else {
				break;
			}
		}
		return personalDataList;
	}
 
}
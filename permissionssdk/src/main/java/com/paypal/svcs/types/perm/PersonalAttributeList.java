package com.paypal.svcs.types.perm;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.perm.PersonalAttribute;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * List of Personal Attributes to be sent as a request. 
 */
public class PersonalAttributeList{

	private static final String nameSpace="com.paypal.svcs.types.perm";
	private static final String preferredPrefix="";

	/**
	 * 	 
	 */ 
	private List<PersonalAttribute> attribute = new ArrayList<PersonalAttribute>();

	

	/**
	 * Default Constructor
	 */
	public PersonalAttributeList (){
	}	

	/**
	 * Getter for attribute
	 */
	 public List<PersonalAttribute> getAttribute() {
	 	return attribute;
	 }
	 
	/**
	 * Setter for attribute
	 */
	 public void setAttribute(List<PersonalAttribute> attribute) {
	 	this.attribute = attribute;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (attribute != null) {
			for(int i=0; i < attribute.size(); i++) {
				sb.append(prefix).append("attribute(").append(i).append(")=").append(attribute.get(i).getValue());
				sb.append("&");
			}
		}
		return sb.toString();
	}

}
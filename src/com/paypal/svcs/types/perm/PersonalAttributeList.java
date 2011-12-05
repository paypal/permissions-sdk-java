
/**
 * Auto generated code
 */

package com.paypal.svcs.types.perm;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.perm.PersonalAttribute;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * List of Personal Attributes to be sent as a request. 
 */
public class PersonalAttributeList {

	/**
	 */
	private List<PersonalAttribute> attribute = new ArrayList<PersonalAttribute>();
	public List<PersonalAttribute> getAttribute() {
		return attribute;
	}
	public void setAttribute(List<PersonalAttribute> value) {
		this.attribute = value;
	}



	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( attribute != null ) {
			for(int i=0; i<attribute.size(); i++) {
				sb.append(prefix).append("attribute(").append(i).append(")=").append(attribute.get(i).getValue());
				sb.append('&');
			}
		}
		return sb.toString();
	}

}

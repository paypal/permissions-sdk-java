package com.paypal.svcs.types.perm;

/**
 * 
 *  Enumeration for Personal Attributes of a user.
 * 
 */
public enum  PersonalAttribute {

	HTTPAXSCHEMAORGNAMEPERSONFIRST("http://axschema.org/namePerson/first"),

	HTTPAXSCHEMAORGNAMEPERSONLAST("http://axschema.org/namePerson/last"),

	HTTPAXSCHEMAORGCONTACTEMAIL("http://axschema.org/contact/email"),

	HTTPSCHEMAOPENIDNETCONTACTFULLNAME("http://schema.openid.net/contact/fullname"),

	HTTPAXSCHEMAORGCOMPANYNAME("http://axschema.org/company/name"),

	HTTPAXSCHEMAORGCONTACTCOUNTRYHOME("http://axschema.org/contact/country/home"),

	HTTPAXSCHEMAORGBIRTHDATE("http://axschema.org/birthDate"),

	HTTPAXSCHEMAORGCONTACTPOSTALCODEHOME("http://axschema.org/contact/postalCode/home"),

	HTTPSCHEMAOPENIDNETCONTACTSTREET1("http://schema.openid.net/contact/street1"),

	HTTPSCHEMAOPENIDNETCONTACTSTREET("http://schema.openid.net/contact/street2"),

	HTTPAXSCHEMAORGCONTACTCITYHOME("http://axschema.org/contact/city/home"),

	HTTPAXSCHEMAORGCONTACTSTATEHOME("http://axschema.org/contact/state/home"),

	HTTPAXSCHEMAORGCONTACTPHONEDEFAULT("http://axschema.org/contact/phone/default"),

	HTTPSWWWPAYPALCOMWEBAPPSAUTHSCHEMAPAYERID2("https://www.paypal.com/webapps/auth/schema/payerID");

	private String value;

	private PersonalAttribute (String value) {
		this.value = value;
	}

	public String getValue(){
		return value;
	}
	
	public static PersonalAttribute fromValue(String v) {
		for (PersonalAttribute c : values())
			if (c.value.equals(v))
				return c;
		throw new IllegalArgumentException(v);
	}

}
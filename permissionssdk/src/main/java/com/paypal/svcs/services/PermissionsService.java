package com.paypal.svcs.services;
import java.io.*;
import java.util.Map;
import java.util.Properties;
import com.paypal.core.BaseService;
import com.paypal.exception.*;
import com.paypal.core.credential.ICredential;
import com.paypal.core.APICallPreHandler;
import com.paypal.core.NVPUtil;
import com.paypal.core.nvp.PlatformAPICallPreHandler;
import com.paypal.svcs.types.perm.RequestPermissionsRequest;
import com.paypal.svcs.types.perm.RequestPermissionsResponse;
import com.paypal.svcs.types.perm.GetAccessTokenRequest;
import com.paypal.svcs.types.perm.GetAccessTokenResponse;
import com.paypal.svcs.types.perm.GetPermissionsRequest;
import com.paypal.svcs.types.perm.GetPermissionsResponse;
import com.paypal.svcs.types.perm.CancelPermissionsRequest;
import com.paypal.svcs.types.perm.CancelPermissionsResponse;
import com.paypal.svcs.types.perm.GetBasicPersonalDataRequest;
import com.paypal.svcs.types.perm.GetBasicPersonalDataResponse;
import com.paypal.svcs.types.perm.GetAdvancedPersonalDataRequest;
import com.paypal.svcs.types.perm.GetAdvancedPersonalDataResponse;
import com.paypal.sdk.exceptions.OAuthException;

public class PermissionsService extends BaseService {


	// Service Version
	public static final String SERVICE_VERSION = "";

	// Service Name
	public static final String SERVICE_NAME = "Permissions";

	//SDK Name
	private static final String SDK_NAME = "permissions-java-sdk";
	
	//SDK Version
	private static final String SDK_VERSION = "2.3.106";


	/**
	 * Default <code>PermissionsService</code> Constructor.
	 * Initializes the SDK system with the default configuration file named
	 * 'sdk_config.properties' found in the class-path
	 * 
	 */
	public PermissionsService() {
		super();
	}
	
	/**
	 * <code>PermissionsService</code> that uses the supplied path
	 * to initialize the SDK system. The initialization context is maintained
	 * only for this instance of the class. To initialize the SDK system
	 * globally use the default constructor.
	 * 
	 * @see PayPalAPIInterfaceServiceService
	 * @param configFilePath
	 *            Absolute path to a {@link Properties} file
	 * @throws IOException
	 */
	public PermissionsService(String configFilePath) throws IOException {
		this(new File(configFilePath));
	}
	
	/**
	 * <code>PermissionsService</code> that uses the supplied
	 * {@link File} object to initialize the SDK system. The initialization
	 * context is maintained only for this instance of the class. To initialize
	 * the SDK system globally use the default constructor
	 * 
	 * @see PayPalAPIInterfaceServiceService
	 * @param configFile
	 *            Configuration file in {@link Properties} format
	 * @throws IOException
	 */
	public PermissionsService(File configFile) throws IOException {
		this(new FileInputStream(configFile));
	}		

	/**
	 * <code>PermissionsService</code> that uses the supplied
	 * {@link InputStream} object to initialize the SDK system. The
	 * initialization context is maintained only for this instance of the class.
	 * To initialize the SDK system globally use the default constructor.
	 * 
	 * @see PayPalAPIInterfaceServiceService
	 * @param inputStream
	 *            InputStream of a {@link Properties} file
	 * @throws IOException
	 */
	public PermissionsService(InputStream inputStream) throws IOException {
		super(inputStream);
	}

	/**
	 * <code>PermissionsService</code> that uses the supplied
	 * {@link Properties} to initialize the SDK system. For values that the
	 * properties should hold consult the sample 'sdk_config.properties' file
	 * bundled with the SDK. The initialization context is maintained only for
	 * this instance of the class. To initialize the SDK system globally use the
	 * default constructor.
	 * 
	 * @see PayPalAPIInterfaceServiceService
	 * @param properties
	 *            {@link Properties} object
	 */	
	public PermissionsService(Properties properties) {
		super(properties);
	}
	
	/**
	 * <code>PayPalAPIInterfaceServiceService</code> that uses the supplied
	 * {@link Map} to initialize the SDK system. For values that the map should
	 * hold consult the sample 'sdk_config.properties' file bundled with the
	 * SDK. The initialization context is maintained only for this instance of
	 * the class. To initialize the SDK system globally use the default
	 * constructor.
	 * 
	 * @see PayPalAPIInterfaceServiceService
	 * @param configurationMap
	 *            {@link Map} object
	 */
	public PermissionsService(Map<String, String> configurationMap) {
		super(configurationMap);
	}




	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public RequestPermissionsResponse requestPermissions(RequestPermissionsRequest requestPermissionsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return requestPermissions(requestPermissionsRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public RequestPermissionsResponse requestPermissions(RequestPermissionsRequest requestPermissionsRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(requestPermissionsRequest.toNVPString(), SERVICE_NAME, "RequestPermissions", credential, SDK_NAME, SDK_VERSION, "Permissions", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return RequestPermissionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public RequestPermissionsResponse requestPermissions(RequestPermissionsRequest requestPermissionsRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(requestPermissionsRequest.toNVPString(), SERVICE_NAME, "RequestPermissions", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "Permissions", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return RequestPermissionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAccessTokenResponse getAccessToken(GetAccessTokenRequest getAccessTokenRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return getAccessToken(getAccessTokenRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAccessTokenResponse getAccessToken(GetAccessTokenRequest getAccessTokenRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getAccessTokenRequest.toNVPString(), SERVICE_NAME, "GetAccessToken", credential, SDK_NAME, SDK_VERSION, "Permissions", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetAccessTokenResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAccessTokenResponse getAccessToken(GetAccessTokenRequest getAccessTokenRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getAccessTokenRequest.toNVPString(), SERVICE_NAME, "GetAccessToken", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "Permissions", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetAccessTokenResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetPermissionsResponse getPermissions(GetPermissionsRequest getPermissionsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return getPermissions(getPermissionsRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetPermissionsResponse getPermissions(GetPermissionsRequest getPermissionsRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getPermissionsRequest.toNVPString(), SERVICE_NAME, "GetPermissions", credential, SDK_NAME, SDK_VERSION, "Permissions", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetPermissionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetPermissionsResponse getPermissions(GetPermissionsRequest getPermissionsRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getPermissionsRequest.toNVPString(), SERVICE_NAME, "GetPermissions", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "Permissions", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetPermissionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CancelPermissionsResponse cancelPermissions(CancelPermissionsRequest cancelPermissionsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return cancelPermissions(cancelPermissionsRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CancelPermissionsResponse cancelPermissions(CancelPermissionsRequest cancelPermissionsRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(cancelPermissionsRequest.toNVPString(), SERVICE_NAME, "CancelPermissions", credential, SDK_NAME, SDK_VERSION, "Permissions", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return CancelPermissionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CancelPermissionsResponse cancelPermissions(CancelPermissionsRequest cancelPermissionsRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(cancelPermissionsRequest.toNVPString(), SERVICE_NAME, "CancelPermissions", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "Permissions", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return CancelPermissionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetBasicPersonalDataResponse getBasicPersonalData(GetBasicPersonalDataRequest getBasicPersonalDataRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return getBasicPersonalData(getBasicPersonalDataRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetBasicPersonalDataResponse getBasicPersonalData(GetBasicPersonalDataRequest getBasicPersonalDataRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getBasicPersonalDataRequest.toNVPString(), SERVICE_NAME, "GetBasicPersonalData", credential, SDK_NAME, SDK_VERSION, "Permissions", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetBasicPersonalDataResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetBasicPersonalDataResponse getBasicPersonalData(GetBasicPersonalDataRequest getBasicPersonalDataRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getBasicPersonalDataRequest.toNVPString(), SERVICE_NAME, "GetBasicPersonalData", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "Permissions", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetBasicPersonalDataResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAdvancedPersonalDataResponse getAdvancedPersonalData(GetAdvancedPersonalDataRequest getAdvancedPersonalDataRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
	 	return getAdvancedPersonalData(getAdvancedPersonalDataRequest, (String) null);
	 }

	/** 
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAdvancedPersonalDataResponse getAdvancedPersonalData(GetAdvancedPersonalDataRequest getAdvancedPersonalDataRequest, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getAdvancedPersonalDataRequest.toNVPString(), SERVICE_NAME, "GetAdvancedPersonalData", credential, SDK_NAME, SDK_VERSION, "Permissions", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetAdvancedPersonalDataResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
	
	/**	
	 * 
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAdvancedPersonalDataResponse getAdvancedPersonalData(GetAdvancedPersonalDataRequest getAdvancedPersonalDataRequest, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		APICallPreHandler apiCallPreHandler = new PlatformAPICallPreHandler(getAdvancedPersonalDataRequest.toNVPString(), SERVICE_NAME, "GetAdvancedPersonalData", apiUsername, getAccessToken(), getTokenSecret(), SDK_NAME, SDK_VERSION, "Permissions", this.configurationMap);
	 	String response = call(apiCallPreHandler);
		return GetAdvancedPersonalDataResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }

}
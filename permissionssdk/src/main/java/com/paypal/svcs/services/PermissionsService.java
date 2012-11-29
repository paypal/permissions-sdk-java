package com.paypal.svcs.services;
import java.io.*;
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

public class PermissionsService extends BaseService{


	// Service Version
	public static final String SERVICE_VERSION = "";

	// Service Name
	public static final String SERVICE_NAME = "Permissions";

	//SDK Name
	private static final String SDK_NAME="permissions-java-sdk";
	
	//SDK Version
	private static final String SDK_VERSION="2.0.96";

	
	public PermissionsService(File configFile) throws IOException {
		initConfig(configFile);
	}		

	public PermissionsService(InputStream config) throws IOException {
		initConfig(config);
	}

	public PermissionsService(String configFilePath) throws IOException {
		initConfig(configFilePath);
	}



		
	/**	
	 * AUTO_GENERATED
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
	 	APICallPreHandler apiCallPreHandler = null;
		apiCallPreHandler = new PlatformAPICallPreHandler(requestPermissionsRequest.toNVPString(), SERVICE_NAME, "RequestPermissions", apiUsername, getAccessToken(), getTokenSecret());
	    ((PlatformAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
	 	String response = call(apiCallPreHandler);
		return RequestPermissionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }
	 
	/** 
	 * AUTO_GENERATED
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
	 * AUTO_GENERATED
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
	 	APICallPreHandler apiCallPreHandler = null;
		apiCallPreHandler = new PlatformAPICallPreHandler(requestPermissionsRequest.toNVPString(), SERVICE_NAME, "RequestPermissions", credential);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
	 	String response = call(apiCallPreHandler);
		return RequestPermissionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
		
	/**	
	 * AUTO_GENERATED
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
	 	APICallPreHandler apiCallPreHandler = null;
		apiCallPreHandler = new PlatformAPICallPreHandler(getAccessTokenRequest.toNVPString(), SERVICE_NAME, "GetAccessToken", apiUsername, getAccessToken(), getTokenSecret());
	    ((PlatformAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
	 	String response = call(apiCallPreHandler);
		return GetAccessTokenResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }
	 
	/** 
	 * AUTO_GENERATED
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
	 * AUTO_GENERATED
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
	 	APICallPreHandler apiCallPreHandler = null;
		apiCallPreHandler = new PlatformAPICallPreHandler(getAccessTokenRequest.toNVPString(), SERVICE_NAME, "GetAccessToken", credential);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
	 	String response = call(apiCallPreHandler);
		return GetAccessTokenResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
		
	/**	
	 * AUTO_GENERATED
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
	 	APICallPreHandler apiCallPreHandler = null;
		apiCallPreHandler = new PlatformAPICallPreHandler(getPermissionsRequest.toNVPString(), SERVICE_NAME, "GetPermissions", apiUsername, getAccessToken(), getTokenSecret());
	    ((PlatformAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
	 	String response = call(apiCallPreHandler);
		return GetPermissionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }
	 
	/** 
	 * AUTO_GENERATED
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
	 * AUTO_GENERATED
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
	 	APICallPreHandler apiCallPreHandler = null;
		apiCallPreHandler = new PlatformAPICallPreHandler(getPermissionsRequest.toNVPString(), SERVICE_NAME, "GetPermissions", credential);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
	 	String response = call(apiCallPreHandler);
		return GetPermissionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
		
	/**	
	 * AUTO_GENERATED
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
	 	APICallPreHandler apiCallPreHandler = null;
		apiCallPreHandler = new PlatformAPICallPreHandler(cancelPermissionsRequest.toNVPString(), SERVICE_NAME, "CancelPermissions", apiUsername, getAccessToken(), getTokenSecret());
	    ((PlatformAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
	 	String response = call(apiCallPreHandler);
		return CancelPermissionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }
	 
	/** 
	 * AUTO_GENERATED
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
	 * AUTO_GENERATED
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
	 	APICallPreHandler apiCallPreHandler = null;
		apiCallPreHandler = new PlatformAPICallPreHandler(cancelPermissionsRequest.toNVPString(), SERVICE_NAME, "CancelPermissions", credential);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
	 	String response = call(apiCallPreHandler);
		return CancelPermissionsResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
		
	/**	
	 * AUTO_GENERATED
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
	 	APICallPreHandler apiCallPreHandler = null;
		apiCallPreHandler = new PlatformAPICallPreHandler(getBasicPersonalDataRequest.toNVPString(), SERVICE_NAME, "GetBasicPersonalData", apiUsername, getAccessToken(), getTokenSecret());
	    ((PlatformAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
	 	String response = call(apiCallPreHandler);
		return GetBasicPersonalDataResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }
	 
	/** 
	 * AUTO_GENERATED
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
	 * AUTO_GENERATED
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
	 	APICallPreHandler apiCallPreHandler = null;
		apiCallPreHandler = new PlatformAPICallPreHandler(getBasicPersonalDataRequest.toNVPString(), SERVICE_NAME, "GetBasicPersonalData", credential);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
	 	String response = call(apiCallPreHandler);
		return GetBasicPersonalDataResponse.createInstance(NVPUtil.decode(response), "", -1);
	}
		
	/**	
	 * AUTO_GENERATED
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
	 	APICallPreHandler apiCallPreHandler = null;
		apiCallPreHandler = new PlatformAPICallPreHandler(getAdvancedPersonalDataRequest.toNVPString(), SERVICE_NAME, "GetAdvancedPersonalData", apiUsername, getAccessToken(), getTokenSecret());
	    ((PlatformAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
	 	String response = call(apiCallPreHandler);
		return GetAdvancedPersonalDataResponse.createInstance(NVPUtil.decode(response), "", -1);
	 }
	 
	/** 
	 * AUTO_GENERATED
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
	 * AUTO_GENERATED
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
	 	APICallPreHandler apiCallPreHandler = null;
		apiCallPreHandler = new PlatformAPICallPreHandler(getAdvancedPersonalDataRequest.toNVPString(), SERVICE_NAME, "GetAdvancedPersonalData", credential);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((PlatformAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
	 	String response = call(apiCallPreHandler);
		return GetAdvancedPersonalDataResponse.createInstance(NVPUtil.decode(response), "", -1);
	}

}
/**
 * PermissionsService wrapper class
 * Auto generated code
 */
package com.paypal.svcs.services;

import com.paypal.core.BaseService;
import com.paypal.core.NVPUtil;
import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;
import com.paypal.svcs.types.perm.CancelPermissionsRequest;
import com.paypal.svcs.types.perm.CancelPermissionsResponse;
import com.paypal.svcs.types.perm.GetAccessTokenRequest;
import com.paypal.svcs.types.perm.GetAccessTokenResponse;
import com.paypal.svcs.types.perm.GetPermissionsRequest;
import com.paypal.svcs.types.perm.GetPermissionsResponse;
import com.paypal.svcs.types.perm.RequestPermissionsRequest;
import com.paypal.svcs.types.perm.RequestPermissionsResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


public class PermissionsService extends BaseService {

	private static final String SERVICE_VERSION = "";
	private static final String SERVICE_NAME = "Permissions";

	public PermissionsService(File configFile) throws IOException, FileNotFoundException {
		super(SERVICE_NAME, SERVICE_VERSION);
		initConfig(configFile);
	}
	public PermissionsService(InputStream config) throws IOException, FileNotFoundException {
		super(SERVICE_NAME, SERVICE_VERSION);
		initConfig(config);
	}
	public PermissionsService(String configFilePath) throws IOException, FileNotFoundException {
		super(SERVICE_NAME, SERVICE_VERSION);
		initConfig(configFilePath);
		
	}

	/**
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
	public RequestPermissionsResponse requestPermissions (RequestPermissionsRequest RequestPermissionsRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("RequestPermissions", RequestPermissionsRequest.toNVPString(), apiUsername);
		return new RequestPermissionsResponse(NVPUtil.decode(response), "");
	}

	public RequestPermissionsResponse requestPermissions (RequestPermissionsRequest RequestPermissionsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return requestPermissions(RequestPermissionsRequest, null);
	}

	/**
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
	public GetAccessTokenResponse getAccessToken (GetAccessTokenRequest GetAccessTokenRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("GetAccessToken", GetAccessTokenRequest.toNVPString(), apiUsername);
		return new GetAccessTokenResponse(NVPUtil.decode(response), "");
	}

	public GetAccessTokenResponse getAccessToken (GetAccessTokenRequest GetAccessTokenRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return getAccessToken(GetAccessTokenRequest, null);
	}

	/**
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
	public GetPermissionsResponse getPermissions (GetPermissionsRequest GetPermissionsRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("GetPermissions", GetPermissionsRequest.toNVPString(), apiUsername);
		return new GetPermissionsResponse(NVPUtil.decode(response), "");
	}

	public GetPermissionsResponse getPermissions (GetPermissionsRequest GetPermissionsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return getPermissions(GetPermissionsRequest, null);
	}

	/**
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
	public CancelPermissionsResponse cancelPermissions (CancelPermissionsRequest CancelPermissionsRequest,  String apiUsername) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		String response = call("CancelPermissions", CancelPermissionsRequest.toNVPString(), apiUsername);
		return new CancelPermissionsResponse(NVPUtil.decode(response), "");
	}

	public CancelPermissionsResponse cancelPermissions (CancelPermissionsRequest CancelPermissionsRequest) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException {
		return cancelPermissions(CancelPermissionsRequest, null);
	}

}

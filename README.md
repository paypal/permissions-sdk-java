This repository contains java sdk and samples for Permissions API.

Prerequisites:
---------------
*	Java jdk-1.5 or higher
*	Apache Maven 2 or higher

SDK Integration:
----------------
*	Create a new maven web application.

*	Add dependency to sdk in your application's pom.xml as below.
		
		<dependency>
			<groupId>com.paypal.sdk</groupId>
			<artifactId>permissionssdk</artifactId>
			<version>1.0-SNAPSHOT</version>
		</dependency>
		
*	Import PermissionsService.java into your code.
		
*	Copy the configuration file 'sdk_config.properties' in 'permissionssample/src/main/resources' folder to your application 'src/main/resources'. And load it using,  
		  
		new PermissionsService(this.getClass().getResourceAsStream("/sdk_config.properties"));
	
*	Or load the configuration file from any location using absolute path with the below method calls as required.

          new PermissionsService(new File(" .../sdk_config.properties"));
                                 Or
		  new PermissionsService(new InputStream(new File(" .../sdk_config.properties")));
                                 Or
          new PermissionsService(" .../sdk_config.properties");
  
*	Create a service wrapper object.

*	Create a request object as per your project needs. 

*	Invoke the appropriate method on the service wrapper object.

For example,

          
	  import com.paypal.svcs.services.PermissionsService;
	  import com.paypal.svcs.types.common.RequestEnvelope;
	  import com.paypal.svcs.types.perm.RequestPermissionsRequest;
      import com.paypal.svcs.types.perm.RequestPermissionsResponse;
	  ...
	  
          
          
          RequestEnvelope env = new RequestEnvelope();
	      env.setErrorLanguage("en_US");
          ...
          
		  List<String> scope = new ArrayList<String>();
		  String value="INVOICING";
		  scope.add(value);
          ...
                    
	      RequestPermissionsRequest requestPermissionsRequest = new RequestPermissionsRequest(scope, callback);
		  requestPermissionsRequest.setRequestEnvelope(env);
          ...

          //userName is optional
          PermissionsService permissionsService = new PermissionsService(this.getClass().getResourceAsStream("/sdk_config.properties"));
	      RequestPermissionsResponse requestPermissionsResponse = permissionsService.requestPermissions(requestPermissionsRequest,userName);
		  

SDK Logging:
------------
*	For logging - java.util.logging has been used. To change the default configuration, edit the logging.properties file in 'jre/lib' folder under your JDK root.		  

		  
SDK Configuration:
------------------
The SDK uses .properties format configuration file. Sample of this file is at 
 
'permissionssample/src/main/resources/'. You can use the 'sdk_config.properties' configuration file to configure

*	(Multiple) API account credentials.

*	HTTP connection parameters.

*	Service configuration.


For additional information on Permissions API, please refer to https://www.x.com/developers/paypal/documentation-tools/api





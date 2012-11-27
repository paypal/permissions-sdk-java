This repository contains java sdk and samples for Permissions API.

Prerequisites:
---------------
*	Java jdk-1.5 or higher
*	Apache Maven 2 or higher

SDK Integration:
----------------
For Non-Maven Users:
--------------------
*   Create a new application.

*   Copy  all the jar files present inside 'lib' folder to your application.

For Maven Users:
----------------
*   Install all the jar files present inside 'lib' folder manually to local repository. 

        mvn install:install-file -Dfile=commons-codec-1.3.jar -DgroupId=commons-codec -DartifactId=commons-codec -Dversion=1.3 -Dpackaging=jar
        mvn install:install-file -Dfile=paypal-auth-signature-1.0.jar -DgroupId=com.paypal.sdk -DartifactId=paypal-auth-signature -Dversion=1.0 -Dpackaging=jar
        mvn install:install-file -Dfile=paypal-core-1.0.jar -DgroupId=com.paypal.sdk -DartifactId=paypal-core -Dversion=1.0 -Dpackaging=jar
		mvn install:install-file -Dfile=permissionssdk-2.2.96.jar -DgroupId=com.paypal.sdk -DartifactId=permissionssdk -Dversion=2.2.96 -Dpackaging=jar	

*	Create a new maven application.

*	Add dependency to sdk in your application's pom.xml as below.
		
		<dependency>
			<groupId>com.paypal.sdk</groupId>
			<artifactId>permissionssdk</artifactId>
			<version>2.2.96</version>
		</dependency>
		
To make an API call:
--------------------			
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





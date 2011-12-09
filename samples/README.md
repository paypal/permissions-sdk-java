PayPal Java Permissions API sample using the sdk
============================================
	The permissions-sample project is a API scratch pad application that allows you to test Permissions APIs. This application is a handy complement to the API reference guides available on x.com. The samples also demonstrate how you can use the SDK to call the API methods in your own application.

To build and run the permissions-sample:
------------------------------------
* 	update the sdk_config.properties in the permissions-sample/WebContent/WEB-INF/ directory with your API credentials.
*	simply run ant in the permissions-sample directory - it would rebuild the SDK if the sdk jar file doesn't exist already.
*	copy the dist/permissions-sample.war into your tomcat/webapps directory
*	start your tomcat if it's not already running
*	access http://<your-server-host:port>/permissions-sample/ in your browser to play with the test pages.


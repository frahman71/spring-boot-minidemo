Welcome to the Spring Boot Demo application for the Webstep Crash Course
------------------------------------------------------------------------

This Demo application consist of a number of Micro services and their related components.

You simply start the Demo application by running SpringBootDemoApplication located under source package (main).
To get the connector working for the database you need a secret password used by the encryptor Jasypt so just
pass a define to the SpringBootApplication through VMOptions -Djasypt.encryptor.password=Ulger78ikbn.

You can switch on and off Basic Authentication as you like. Just enter the DemoWebSecurityConfigurerAdapter
and remove comments for the web security annotations.

If you want to use HTTPS instead of HTTP you can active the application properties for the P12 test certificate
and just restart your Spring Boot Application.

Enjoy :-)

Fredrik Åhman

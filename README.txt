Welcome to the Spring Boot Demo application for the Webstep Crash Course
------------------------------------------------------------------------

This Demo application consist of a number of Micro services and their related components.

You simply start the Demo application by running SpringBootDemoApplication located under source package (main).
To get embedded tomcat server working for HTTPS-connections you need a secret password used by the encryptor Jasypt so just
pass a define to the SpringBootApplication through VMOptions -Djasypt.encryptor.password=Ulger78ikbn.

You can switch on and off Basic Authentication as you like. Just enter the DemoWebSecurityConfigurerAdapter
and remove comments for the web security annotations.

If you want to use HTTPS instead of HTTP you can active the application properties for the P12 test certificate
and just restart your Spring Boot Application.


To TEST the services simply use Postman or any other suitable tool for making REST-calls.

Adding customer call is:

HTTP POST
http://localhost:8080/customer/addCustomer

{
    "customerId": "20030101-1093",
    "firstName": "Ole",
    "surName": "Johansson",
    "address": "Storgatan 15",
    "postalAddress": "Testholmen",
    "postalCode": "125 20"
}


To get all the registered customers:

HTTP GET
http://localhost:8080/customer/getAllCustomers

To delete a single customer:

HTTP DELETE, Where the (XXXXXXXX-XXXX) is your customerId or equiv SSN
http://localhost:8080/customer/deleteCustomer/XXXXXXXX-XXXX

Enjoy :-)

Fredrik Åhman

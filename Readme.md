/* To start App follow these instructions */

Open Terminal
Run these two commands below:

$env:JAVA_TOOL_OPTIONS='-Djavax.net.ssl.trustStore=C:\Users\957446\truststore.jks -Djavax.net.ssl.trustStorePassword=yourpassword'

mvn spring-boot:run


Once app is running - try browsing to the following link below.

https://localhost:8080/api/houses/cheapest

NOTE: This will make an API call via SSL to "https://app.rentcast.io/app/api" to get the top 10 cheapest houses within 100 miles of our house per square foot. 
1. Steps to build and run settlement project
   a) Unzip settlement project
   b) Build using command mvn clean package, maven should be 
pre-installed before running this command
   c) Jar file will be generated after running build command
   d) Run command java -jar settlement-0.0.1-SNAPSHOT.jar, to start 
in-built server and app
   e) To test, access api using postman
       http://localhost:8080/fetchMarketSettlement/16800001
       http://localhost:8080/createNewMarketSettlement
   f) During build test cases will be executed, we can verify if test case failure
2. Assumption : ssicode will be unique in the SSI reference data, so that we can fetch reference data based trade request ssicode
3. Assumption : This assessment excludes trade validation, 
risk management and alerts  

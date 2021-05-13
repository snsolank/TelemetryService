# EP1 Telemetry Micro-Service communication with Kafka 
 - This service is created with Java 11 and Spring Boot Framework
 - Telemetry micro-service consumes the telemetry data that is published on to kafka topic by MQTT Broker.
 ## Steps to Start Telemetry Service Locally
 - Install Apache Kafka 
   #### Start Zookeeper
   -  .\bin\windows\zookeeper-server-start.bat  .\config\zookeeper.properties
   #### Start Kafka Server
   - .\bin\windows\kafka-server-start.bat  .\config\server.properties
   #### Create Kafka Topic
   - .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic EP1-Telemetry-Topic
 
 ### REST Endpoints 
 - For this assignment I have created POST Api to publish the messages to Kafka EP1-Telemetry-Topic.
 - Ideally these messages should be published by EP1 sensors to MQTT Broker and eventually to Kafka Topic.
 - These messages are consumed by Telemetry Service and stored in database. (for assignment H2 in memory DB has been used)
    ##### POST API  
    - http://localhost:8081/api/ep1/v1/telemetry/publish
    - ##### payload or request body
    ```json
    {
        "ep1TelemetryData":[
            {
                "code":"EP003",
                "description":"EP001-Georgia BrightDrop-GM Site",
                "geolocation":{
                    "location": "Baker Street Northwest, Atlanta, GA",
                    "latitude": "34.1717109",
                    "longitude": "-84.1827338"
                },
                "healthStatus":"good",
                "batteryStatus":"99",
                "temperature":"75",
                "eta":"4:00",
                "isDoorOpen": false
            }
        ]
    }
    ```
   - ##### POST API Response
   ```json
   {
       "status": "OK",
       "data": "EP1 Telemetry Data Published to Kafka Topic successfully",
       "errorMessage": ""
   }
   ```
   ##### GET API
   - After successfully publishing telemetry message to kafka topic using above mentioned 
     POST Api, these messages are saved in in-memory H2 db. 
   - Following GET api is used to retrieve EP1 telemetry data from H2 db and can be consumed by our 3rd party
        clients via API Gateway. 
   - http://localhost:8081/api/ep1/v1/telemetry 
     
   ##### GET API Response
   ```json
   {
       "status": "OK",
       "data": [
           {
               "code": "EP003",
               "description": "EP001-Georgia BrightDrop-GM Site",
               "geolocation": {
                   "location": "Baker Street Northwest, Atlanta, GA",
                   "latitude": "34.1717109",
                   "longitude": "-84.1827338"
               },
               "healthStatus": "good",
               "batteryStatus": "99",
               "temperature": "75",
               "eta": "4:00",
               "isDoorOpen": false
           }
       ],
       "errorMessage": ""
   }
   ```  
   
    
    
 


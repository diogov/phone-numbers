# Phone-numbers API

## Set up project

* Download maven 3: http://apache.mirrors.nublue.co.uk/maven/maven-3/3.5.3/binaries/apache-maven-3.5.3-bin.zip 
* extract and set bin folder on environment variable "path"
* execute: mvn clean compile assembly:single
* execute: java -jar target/phone-numbers-1.0-SNAPSHOT-jar-with-dependencies.jar

## Documentation

### GET /phone/number  
**List all phone numbers**

**Resource url**  
http://localhost:4567/phone/number


**Example Request**  
GET http://localhost:4567/phone/number

**Example Response**  
```json
[{
    "number": "0812222111310",
    "activated": true,
    "customerId": 3,
    "customerName": "Andrew"
}, {
    "number": "0812222111322",
    "activated": true,
    "customerId": 6,
    "customerName": "Matt"
}, {
    "number": "08121323221348",
    "activated": true,
    "customerId": 2,
    "customerName": "David"
}, {
    "number": "081213221313",
    "activated": true,
    "customerId": 4,
    "customerName": "Diogo"
}, {
    "number": "0812222111314",
    "activated": true,
    "customerId": 4,
    "customerName": "Diogo"
}]
```
---

### GET /phone/number/{customerId}
**List phone numbers from customer**

**Resource url**  
http://localhost:4567/phone/number/{customerId}

**Parameters**  

| name          | description         |
| ------------- |:-------------:      |
| customerId    | id of the customer  |

**Example Request**  
GET http://localhost:4567/phone/number/1

**Example Response**  
```json
[{
    "number": "071213221341",
    "activated": true
}, {
    "number": "0712222111342",
    "activated": true
}, {
    "number": "0712131321343",
    "activated": true
}, {
    "number": "07121323221344",
    "activated": true
}]
```
---

### PUT /phone/number/activate
**Activate phone number**

**Resource url**  
http://localhost:4567/phone/number/activate

**Example Request**  
PUT http://localhost:4567/phone/number/activate
```json
{
    "number" : "08121323221312"
}
```

**Example Response**  
```json
{
    "message" : "Phone number activated successfully!"
}
```

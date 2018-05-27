# Phone-numbers API

### GET /phone/number  
**List all phone numbers**

**Resourse url**  
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

**Resourse url**  
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

**Resourse url**  
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

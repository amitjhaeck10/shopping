# Online shopping spring boot REST API example
Technology stack:
1) Java 1.8
2) Spring boot 2.x
3) gradle
4) Spring JPA and H2 in-memory DB.

At start of application load intial below product in PRODUCT table.
Apple - 0.60 cent
Orange - 0.25 cent

POST endpoint of Order:
http://localhost:8090/api/orders

POST request:
{
    "productOrders": [
        {
            "product": {
                "id": 1
            },
            "quantity": 3
        },
        {
            "product": {
                "id": 2
            },
            "quantity": 3
        }
    ]
}

GET endpoint : http://localhost:8090/api/orders

Summary on Order:
[
    {
        "orderProducts": [
            {
                "quantity": 3,
                "product": {
                    "id": 1,
                    "name": "apple",
                    "price": 0.6,
                    "hibernateLazyInitializer": {}
                },
                "totalPrice": 1.2
            },
            {
                "quantity": 3,
                "product": {
                    "id": 2,
                    "name": "orange",
                    "price": 0.25,
                    "hibernateLazyInitializer": {}
                },
                "totalPrice": 0.5
            }
        ],
        "id": 1,
        "dateCreated": "10/08/2021",
        "numberOfProducts": 2,
        "totalOrderPrice": 1.7
    }
]



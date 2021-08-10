# Online shopping spring boot REST API example
Technology stack:
1) Java 1.8
2) Spring boot
3) gradle
4) Spring JPA and H2 in-memory DB.

At start of application load intial below product.
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


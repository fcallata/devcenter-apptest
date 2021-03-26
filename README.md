# devcenter-apptest
---
> Para usar MongoDb usamos Docker y ejecutamos la siguiente linea
>
`code` docker run -d -p 27017-27019:27017-27019 --name mongodb mongo:4.0.4

---

> # Endpoints
>
> - localhost:8080/car?id=1&applicationDate=2021-03-21  GET
> - localhost:8080/car/busqueda?filter=TOYOTA  GET
> - localhost:8080/car/excel GET 
> - localhost:8081/log POST
> - localhost:8080/log GET

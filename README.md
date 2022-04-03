# people-flow

1- I pushed a docker image for the project on dockerhub, first run command docker pull howaydagamal77/people-flow:latest

2- Then run command docker run -it  people-flow howaydagamal77/people-flow

3- I am using h2 as an in-memory database also, I'm using liquibase for DDL.

4- After starting 'on port 8080' , go to 'http://localhost:8080/api/h2-console' and press connect to activate h2 database. make sure that the JDBC field has this value : 'jdbc:h2:mem:people-flow-db' ,After connecting , you can see tables 'EMPLOYEE' created.

5- For testing the APIs , you can use 'http://localhost:8080/api/swagger-ui/index.html' to access swagger APIs.
sample request:
{
"name": "Employee1",
"contractInfo": "Employee contract",
"age": 20,
"state": "ADDED"
}

}

successful response for this request is : {

{
"id": "01169f34-e6c4-49bb-bcd8-3628efef23b3",
"name": "Employee1",
"contractInfo": "Employee contract",
"age": 20,
"state": "ADDED"
}

}

That's all for now , if you faced any unexpected error , contact me on howayda.gamal@gmail.com

# PetStore Application

## Index No - 18000721

Build App and Run - Steps
1. Go to the project folder and open the terminal
2. Type ./gradlew build in the termial and execute
3. Type  java -jar build/petstore-runner.jar and execute
4. Now project is up and running

Main Functionalities

1.Get all the pets
method - GET
url : http://localhost:8080/v1/pets/

2.Get a pet by id
method - GET
url : http://localhost:8080/v1/pets/{id}
example:- http://localhost:8080/v1/pets/3

3.Create a new pet
method - POST
url : http://localhost:8080/v1/pets/
body : 
{ "petName" : "panda", "petAge" : 6, "petType" : "dog" }

4.Delete a pet by id
method - DELETE
url : http://localhost:8080/v1/pets/{id}
example:- http://localhost:8080/v1/pets/3

5.Update a pet by id
method - PUT
url : http://localhost:8080/v1/pets/{id}
example:- 
http://localhost:8080/v1/pets/3
body - { "petAge" : 6, "petType" : "cat" }

6.Get all the pet types
method - GET
url : http://localhost:8080/v1/pets/pettypes

7.Get a pet types by id
method - GET
url : http://localhost:8080/v1/pets/pettypes/{id}
example:- http://localhost:8080/v1/pets/pettypes/3

8.Create a new pet type
method - POST
url : http://localhost:8080/v1/pets/pettypes
body : 
{ "petType" : "dog" }

9.Delete a pet type by id
method - DELETE
url : http://localhost:8080/v1/pets/pettypes/{id}
example:- http://localhost:8080/v1/pets/pettypes/3

10.Update a pet type by id
method - PUT
url : http://localhost:8080/v1/pets/pettypes/{id}
example:- http://localhost:8080/v1/pets/pettypes/3
{ "petType" : "cat" }


# springboot-graphql
This project features a very simple GraphQL project using SpringBoot 2.1.9. 
Users can be added and retrieved using a GraphQL mutation and query. 
GraphiQL,  a nice browser UI, is included.

## How to start
Start the application named Application.java in your favorite IDE.
The HTTP server is started on port 7777.
Try out your first GraphQL user by using GraphiQL:

http://localhost:7777/graphiql

Add a user:

    mutation {
      addUser(input: {name: "My first user", address: "User street 1"}) {
        id
        name
        address
      }
    }



... and retrieve it afterwards (insert the appropriate ID):
    
      findUserById(ID:"9b05b9e4-64c6-4878-9b01-f7c5dbe895ac") {
        name
        address
      }
      
      
Have a lot of fun!      
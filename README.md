# springboot-graphql
Simple GraphQL project with SpringBoot 2.1.8.

The server is started on port 7777.
Start the application and try to emit your first GraphQL user by using GraphiQL, a nice browser UI:

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
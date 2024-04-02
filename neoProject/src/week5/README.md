# Description of a project
The project shows a basic configuration Spring Security with JWT
## How you can test a project
1. **Overview**<br>
To begin with, you have to go through all files and understand their usages before going to test.
As you see, there are some endpoints in ProductController and UserController. Think, that UserController file is like a guard of
our data, and this data can be extract from out ProductController, so UserController is a guard of ProductController.
The main point is ,that user have to pass guard to get access to data. This is what, we test here.
2. **Testing**
- Firstly, go to Postman and register as a new user(using endpoint /api/v1/register and command POST) and you will see a message, if you registered successfully or not.
If you registered successfully, remember your email and password that you used for registration, if not try again.
- Secondly, you have to be authenticated to work with products endpoint. The same action, use command POST and url /api/v1/auth
(write the same email and password as you registered), then you will see JWT, copy it.
- Thirdly, now the same action as you have done in week3, use any endpoint you want from ProductController, but before find a link called
Authorization in bar below URL, the type has to be Bearer token. In a token placeholder, paste a token that you copied in a second step, and
do a request. if you do these steps correctly, you will see a result and status (200 ok).

   



# SoftArch_lab №1 
About: microservices simple implementation java <br>
Student: Zhurba Inna <br>

## Additional info

Implemented 3 microservices: <br>
 - facade: is a comunicational service that control requests to other two services; <br>
 - logger: save messages from the clients that ask for it using facade and send saved messages if it is requested; <br>
 - messages: for now it has static message on GET request. 

## Screenshots

GET result after POST with "msg5": <br>
![GET result after POST with "msg5"](./get_after_post.png)

POST with "msg8": <br>
![POST with "msg8"](./post_msg8.png)

GET result after POST with "msg8": <br>
![GET result after POST with "msg8"](./get_after_post_msg8.png)
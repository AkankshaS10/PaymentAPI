# Money Transfer Api
Maven project to demonstrate money trasnfer api using REST

#Usage
The application can be started by running App.java class.
This wil start the jetty server at Port:8888
Data is tored in memory from local file storage

#Endpoints


Endpoint	Method	Payload example
/account/transaction	POST	{"fromAccontId":1000,"toAccountId":1001,"
ammount":500,"currency":"EUR"}
/account/?accId	GET	
/account/update	PUT	{"accountId":1001,"userId":"U1","balance":500,"currency":"USD"}
/user/?userId	GET	

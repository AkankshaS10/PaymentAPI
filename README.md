# Money Transfer Api

Maven project to demonstrate money trasnfer api using REST

#Usage

The application can be started by running App.java class.

This wil start the jetty server at Port:8888

Data is stored in memory from local file storage.


#Endpoints

1. Transfer fund between account

Url:  http://localhost:8888//account/transaction

Method :POST

Payload: {"fromAccontId":1000,"toAccountId":1001,"ammount":500,"currency":"EUR"}


2. Get account based on accountId

Url: http://localhost:8888/account/?accId

Method:GET	

3: Update an account

Url: http://localhost:8888/account/update

Method :PUT

Payload:{"accountId":1001,"userId":"U1","balance":500,"currency":"USD"}

4: To get user details

Url: http://localhost:8888/user/?userId	

Method :GET	


	

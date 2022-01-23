### Prerequisites
* Please install Docker Desktop from https://docs.docker.com/desktop/windows/install/

## Are you ready for rambooo ?

* Open OS shell like cmd.exe and run the Docker container:
    > docker run --name airman -p 8080:8080 maxanarki/airman
* Execute the remote command *java -jar* to run the application:
    > docker exec -it airman java -jar /1111/AirCompaniesManagementSystem-0.0.1-SNAPSHOT.jar
* Use Postman and provided collection to use and test the application's API:  
    > https://www.getpostman.com/collections/289e3a8635693b88cb82

### Comment

The Spring Boot Rest API and JPA repository interfaces does allmost all work. The only API that I decided to implement separately as a dedicated service is 
7) Endpoint to change Flight status:
   if status to change is DELAYED – set delay started at
   if status to change is ACTIVE – set started at
   if status to change is COMPLETED set ended at

because of the custom logic that is impossible or not easy to implement neither as a Query Method in an JPA repository interface nor as @Query annotation.

I've tried to go the easiest to implement way, not canonical way. I didn't care about security or misuse by client, nor amount of traffic.  

I've spent a lot of time playing with Spring HATEOAS ((

#### Thank You for interesting task...
# Api_sparta-testing-framework

## Testing Approach 
1. Once the Docker container is running with Docker Desktop, I go over the Swagger UI documentation. On the docs, I observe how each endpoint works; what is the expected status code for a valid response? how about the status code for an invalid response?
   2. I also observe the different HTTP request methods associated with the endpoints and made sure that all of the methods are covered in the user stories.
   3. Sometimes Swagger UI will not provide enough information about the API, so I use Postman to futher investigate the behaviour of the APIs.
2. On Intelij, I create seperate files per endpoint. The endpoint file will contain a feature file per HTTP request method.
   3. In these files, the user stories will live here. Each feature file aims to have both HAPPY and SAD paths. In some cases there are endpoints that do not request a parameter or query, so they return a full collection of information.
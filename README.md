# Movie_Character_API
Movie_character is an API that is made with Hibernate to control a PostgresSQL database. The database contains a list of movies, franchises and characters.

## Contributors
1. [AHAB-HUB](https://github.com/AHAB-HUB)
2. [LLehtola](https://github.com/LLehtola)
3. [maijahaka](https://github.com/maijahaka)
## API
### Allowed HTTPs requests:
- POST    &emsp;&nbsp; : To create resource
- PUT     &emsp;&emsp; : Update resource
- GET     &emsp;&emsp; : Get a resource or list of resources
- DELETE  &nbsp; : To delete resource

### Description Of Usual Server Responses:
- 200 `OK` - the request was successful (some API calls may return 201 instead).
- 201 `Created` - the request was successful, and a resource was created.
- 204 `No Content` - the request was successful but there is no representation to return (i.e. the response is empty).
- 400 `Bad Request` - the request could not be understood or was missing required parameters.
- 404 `Not Found` - resource was not found.
### Endpoints definition

#### Get all movies
- Request type: GET
```thymeleafurlexpressions
localhost:8080/api/v1/movies
```
#### Get a movie by id
- Request type: GET
```thymeleafurlexpressions
localhost:8080/api/v1/movies/1
```

#### Add a new movie
- Request type: Post
```thymeleafurlexpressions
localhost:8080/api/v1/movies
```
#### Update a movie by id
- Request type: PUT
```thymeleafurlexpressions
localhost:8080/api/v1/movies
```
#### Delete a movie by id
- Request type: DELETE
```thymeleafurlexpressions
localhost:8080/api/v1/movies/1
```
#### Get all characters
- Request type: GET
```thymeleafurlexpressions
localhost:8080/api/v1/Characters
```

#### Get a character by id
- Request type: GET
```thymeleafurlexpressions
localhost:8080/api/v1/Characters/1
```

#### Add a new character
- Request type: POST
```thymeleafurlexpressions
localhost:8080/api/v1/Characters
```

#### Update a character by id
- Request type: PUT
```thymeleafurlexpressions
localhost:8080/api/v1/Characters/1
```
#### Delete a character by id
- Request type: DELETE
```thymeleafurlexpressions
localhost:8080/api/v1/Characters/1
```
#### Get all franchises
- Request type: GET
```thymeleafurlexpressions
localhost:8080/api/v1/franchises
```
#### Get a franchise by id
- Request type: GET
```thymeleafurlexpressions
localhost:8080/api/v1/franchises
```
#### Add a new franchise
- Request type: POST
```thymeleafurlexpressions
localhost:8080/api/v1/franchises
```
#### Update a franchise by id
- Request type: PUT
```thymeleafurlexpressions
localhost:8080/api/v1/franchises
```

## Heroku
The [link]() to the API on Heroku.

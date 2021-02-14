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

### Heroku
The [link](https://moviescharactersapi.herokuapp.com/) to the API on Heroku.

### Postman Documentation
The [link](https://documenter.getpostman.com/view/14561099/TWDRseqM) to the Postman documentation.
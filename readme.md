# Java Interview - Venkat

This project is being developed as part of coding challenge given to [Venkat] (venkatraju.1284@gmail).

## Dependencies

The following dependencies are required
* Java 11 or higher
* docker-compose version 1.28 or later
* docker engine to build and run containers
* On Windows machine Docker desktop would get correct docker dependencies. Be sure to enable TLS
Optionally you could have a [docker](https://hub.docker.com) account to explore the dependencies.

## Usage

Date format is assumed to be in MM/dd/YYYY format

```python

# To start application
sh startApplication.sh

# To stop application (also removes volumes attached)
sh stopApplication.sh

```

Application runs on port 8082 of localhost.
[application](http://localhost:8080/) can be used once it is successfully started.

### Swagger documentation(not complete)
Swagger documentation can be accessed [here](http://localhost:8080/swagger-ui.html).
Endpoint information can be accessed [here](http://localhost:8080/v3/api-docs)

# Sample URL
check following:
* To get information based on [authorname](http://localhost:8080/talks/authors/venkat)
* To get information based on [title](http://localhost:8080/talks/titles/venkat)
* To get information based on [likes](http://localhost:8080/talks/likes/from=10&to=900)
* To get information based on [views](http://localhost:8080/talks/views/from=10&to=900)

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[IODigital](https://iodigital.com/licenses/mit/)

# spring-frontend-integration-example

An example of integration between Spring Boot aplication and frontend development

This example is also a tutorial refered from http://blog.keik.info/2016/02/28/java-with-frontend/ .


## Layout

```
.
├── README.md
├── todo-app                         ... for sources of a Spring Boot server app
│  ├── pom.xml
│  └── src
│      └── main
│          ├── java
│          └── resources
│              ├── application.yml
│              ├── static
│              │  └── bundle.js      ... built from todo-client/scripts/main.js
│              └── templates
└── todo-client                      ... for sources of client resources
    ├── Makefile
    ├── package.json
    └── scripts                      ... for sources of a JavaScript to bundle
        └── main.js                  ... entry point of JavaScript
```


## Requirements

* JDK 8+
* Maven 3+
* Node 4+
* Gnu Make
* Unix-like shell environment (like MSYS or Cygwin on Windows)


## Development workflow

### Run development server

Move todo-app directory and

```
% mvn spring-boot:run
```

then embedded Jetty server will run and deploy application to http://localhost:8080/ .


### Build frontend

For manual build, move todo-client directory and

```
% make all
```

then built results will be outputted to todo-app/src/main/resources/static directory.


## License

Public Domain

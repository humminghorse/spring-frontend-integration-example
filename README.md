# spring-frontend-integration-example

An example of integration between Spring Boot aplication and frontend development

This example is also a tutorial refered from http://blog.keik.info/2016/02/28/java-with-frontend/ .

![](./screenshot.png)


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
│              │  ├── bundle.js      ... built from todo-client/scripts/main.js
│              │  └── style.css      ... built from todo-client/styles/main.less
│              └── templates
└── todo-client                      ... for sources of client resources
    ├── Makefile
    ├── package.json
    ├── scripts                      ... for sources of a JavaScript to bundle
    │  ├── main.js                   ... entry point of JavaScript
    │  └── page-specifics            ... for store page-specific scripts
    └── styles                       ... for sources of a CSS to bundle
        ├── main.less                ... entry point of CSS
        └── page-specifics           ... for store page-specific styles
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

For auto building, move todo-client directory and

```
% make watch
```

then auto building process, that watching change on files (scripts and styles) and run build automatically, will start.
Built results will be outputted to todo-app/src/main/resources/static directory.

For manual build, move todo-client directory and

```
% make all
```

then built results will be outputted to todo-app/src/main/resources/static directory.


## License

Public Domain

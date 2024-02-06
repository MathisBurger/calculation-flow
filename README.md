# Calculation flow

This application is built for implementation in standard software. It helps to make it easier to 
customize specific calculation flows for companies. 

## Getting started

Just edit `the application.yml` file for your needs and start the application.
Under `http://localhost:8080` you can find the online configuration web panel. It kinda looks
like from the 90s. This was my intention, because I wanted it to look like modern SSW. 



## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be built using:

```shell script
./gradlew build
# or
./gradlew build -Dquarkus.package.type=native
```

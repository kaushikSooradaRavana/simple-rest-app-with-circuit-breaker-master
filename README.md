# Simple REST Sample Application using Hystrix Circuit Breaker

A simple Spring Boot based sample application that uses Hystrix circuit breakers and connects to the Hystrix circuit breaker dashboard. The application uses the following:

- A user-provided service instance in the target space that references the global circuit breaker dashboard in the GLOBAL-SERVICES-* PCF org. The user-provided service must be named `ow-circuit-breaker`. The corresponding service binding can be found in the `services` section of the `manifest.yml` file.
- A user-provided service instance in the target space that references the global service registry server in the GLOBAL-SERVICES-* PCF org. The user-provided service must be named `ow-service-registry`. The corresponding service binding can be found in the `services` section of the `manifest.yml` file.

## Build the application

Build the project with Maven:

```
mvn clean package
```

## Run the application

Deploy the application to Cloud Foundry:

```
cf push
```

Access the application remotely at: https://simple-rest-app-with-circuit-breaker-v1.apps.dev.api.mbusa.oneweb.mercedes-benz.cinteo.de/simple-rest-app-with-circuit-breaker/v1/proxy/hello/MBUSA

Depending on whether an odd or even random number is generated, the endpoint either returns the response of the remote call or a string from the Hystrix command's fallback method:

Response from the remote call:

```
Guten Tag MBUSA!
``` 

Response from the fallback method:

```
FALLBACK
```

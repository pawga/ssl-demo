### Building a docker image
```
./gradlew clean bootJar

docker build --rm -t pawga777/pawga_ssl_demo:0.0.1 .

```

### Verification:
```
docker run -d -p 8443:8443 pawga777/pawga_ssl_demo:0.0.1

https://127.0.0.1:8443/actuator/health
https://127.0.0.1:8443/actuator/info
https://127.0.0.1:8443/
https://127.0.0.1:8443/say-hello?username=Serg
```

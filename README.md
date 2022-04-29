## Webservices Labb 2

| Environment Variables | Description                         | Default   |
|-----------------------|-------------------------------------|-----------|
| MONGO_USERNAME        | The username for the MongoDB Server | root      |
| MONGO_PASSWORD        | The password for the MongoDB Server | password  |
| MONGO_HOST            | The host for the MongoDB Server     | localhost |
| MONGO_PORT            | The port for the MongoDB Server     | 27017     |

To run the program try the following command:

The application should be launched on the same network as the MongoDB server, if the mongodb server is running on the
same machine as the application and in a docker container, use the following command:

```
docker run -e MONGO_HOST=<mongodb-container-name> --network <mongodb-network-name> -p 8080:8080 ghcr.io/darkendhall/webservices_labb_two:latest
```

Don't forget to add `-e MONGO_USERNAME=<username>` and `-e MONGO_PASSWORD=<password>` to set the username and password
for the MongoDB server.

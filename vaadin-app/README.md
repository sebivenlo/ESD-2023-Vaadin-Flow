# Deploying Docker container

## 1. Build Docker image
First you have to build the Docker image via the provided Dockerfile.
Do this by running the following command:\
```docker build -t esde-vaadin:latest .```

Now the image will be created, this might take a few seconds.

## 2. Start the Docker container
Now that the image is ready to be used, you can run a new container with it by typing:\
```docker run -p 8080:8080 -v .:/usr/app --name esde-vaadin esde-vaadin:latest```

Now your container called ``esde-vaadin`` is up and running and you can access the website by accessing [localhost:8080](http://localhost:8080) in your browser.

## 3. Bring your Changes to Docker
Once The docker Container is running, and you have changes, which you want to run you can use the following command:
```docker exec esde-vaadin mvn compile```

This will compile the changed source files, and will cause vaadin to perform a live reload

After vaadin has restarted, you can refresh your browser and the changes will be visible
Note: This might take a minute
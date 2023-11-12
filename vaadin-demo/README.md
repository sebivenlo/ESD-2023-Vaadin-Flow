# Deploying Docker container

## 1. Build Docker image
First you have to build the Docker image via the provided Dockerfile.
Do this by running the following command:\

Note: Command should be run from the directory, where this README.md is located!

```docker build -t esde-vaadin-demo:latest .```

OR:
You can pull our pre buitld image with the following command:
```docker pull apavlitschenko/esde-vaadin-demo```


Now the image will be created, this might take a few seconds.

## 2. Start the Docker container
Now that the image is ready to be used, you can run a new container with it by typing:\
Windows:

```docker run -p 8081:8080  --name esde-vaadin-demo esde-vaadin-demo:latest```


This will download all maven dependencies automatically and eventually run the vaadin app. 
Now your container called ``esde-vaadin-demo`` is up and running and you can access the website by accessing [localhost:8081](http://localhost:8081) in your browser.


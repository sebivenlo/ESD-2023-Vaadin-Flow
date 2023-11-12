# Workshop

## 1. Setup the Docker Environment

CAUTION: make sure no application is listening on port 8080 before running this command, or change the port in the following commands!

Windows/Mac:

```docker pull apavlitschenko/esde-vaadin && docker run -d --name esde-vaadin-tmp apavlitschenko/esde-vaadin:latest && docker cp esde-vaadin-tmp:usr/app/ vaadin-workshop && docker stop esde-vaadin-tmp && docker rm esde-vaadin-tmp && cd vaadin-workshop && docker run --rm -p 8080:8080 -v .:/usr/app --name esde-vaadin apavlitschenko/esde-vaadin:latest```

Linux:

```sudo docker pull apavlitschenko/esde-vaadin && sudo docker run -d --name esde-vaadin-tmp apavlitschenko/esde-vaadin:latest``` 

```mkdir vaadin-workshop && mkdir vaadin-workshop/app```

```sudo docker cp esde-vaadin-tmp:usr/app/ vaadin-workshop && sudo docker stop esde-vaadin-tmp && sudo docker rm esde-vaadin-tmp``` 

```cd vaadin-workshop/app && sudo docker run --rm -p 8080:8080 -v ./:/usr/app --name esde-vaadin apavlitschenko/esde-vaadin:latest```

This command will pull our esde workshop image. Afterwards it will create a temporary container, and copy the sources into the vaadin-workshop folder. Afterwards the temporary Container will be stopped and removed.
Then the proper vaadin container will be created with the correct directory mounted, and the ports forwarded. 

Now your container called ``esde-vaadin`` is up and running and you can access the website by accessing [localhost:8080](http://localhost:8080) in your browser.

## 2. Bring your Changes to the Docker Environment
Once The docker Container is running, and you have changes, which you want to run you can use the following command:
```docker exec esde-vaadin mvn compile```

This will compile the changed source files, and will cause vaadin to perform a live reload

After vaadin has automatically restarted, you can refresh your browser and the changes will be visible
Note: This might take a minute

# Demo

## 1. Pull Image
Pull the image with the following command 

```docker pull apavlitschenko/esde-vaadin-demo```



## 2. Run

Run the Container with the following command

```docker run -p 8081:8080 --name esde-vaadin-demo apavlitschenko/esde-vaadin-demo:latest```

Now your container called ``esde-vaadin-demo`` is up and running and you can access the website by accessing [localhost:8081](http://localhost:8081) in your browser.



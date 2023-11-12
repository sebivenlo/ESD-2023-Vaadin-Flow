# Workshop

## 1. Setup the Docker Environment

CAUTION: make sure no application is listening on port 8080 before running this command!

Windows:

```docker pull apavlitschenko/esde-vaadin && docker run -d --name esde-vaadin-tmp apavlitschenko/esde-vaadin:latest && docker cp esde-vaadin-tmp:usr/app/ vaadin-workshop && docker stop esde-vaadin-tmp && docker rm esde-vaadin-tmp && cd vaadin-workshop && docker run --rm -p 8080:8080 -v .:/usr/app --name esde-vaadin apavlitschenko/esde-vaadin:latest```

Linux:

```TBD```

This command will pull our esde workshop image. Afterwards it will create a temporary container, and copy the sources into the vaadin-workshop folder. Afterwards the temporary Container will be stopped and removed.
Then the proper vaadin container will be created with the correct directory mounted, and the ports forwarded. 

## 2. Bring your Changes to the Docker Environment
Once The docker Container is running, and you have changes, which you want to run you can use the following command:
```docker exec esde-vaadin mvn compile```

This will compile the changed source files, and will cause vaadin to perform a live reload

After vaadin has automatically restarted, you can refresh your browser and the changes will be visible
Note: This might take a minute

# Demo

# ESD template

Please make sure all artifacts are in this GitHub repository.  
That includes:

- Code
- Workshop materials
- Presentation (if applicable)
- References.
- Docker (compose) file (if applicable)

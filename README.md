# REST API endpoints with Spring WebFlux 

This project including two REST API endpoints: one for a list of bookings, and one for fetching a single booking.
You do not have to set any database because the project uses it mock database classes. Java 10 or newer is required.

## Good to know

Some useful tips.

### How to build .jar file?

Open for example Git Bash and go to project root dir. After that run ./mvnw clean install

### How I can run .jar file?

java -jar target/ay-booking-service-0.0.1-SNAPSHOT.jar

### Project Lombok

If you want to develop this project you have to install [Project Lombok](https://projectlombok.org/) first. Otherwise you have
to generate, for example, Getters and Setters in a traditional way. 

### Main Method

You will find main method from: fi.ay.booking.AyBookingServiceApplication

### Spring profiles

You do not have to set any Spring profiles, because this project uses the default profile.

### Logs

You will find a log files from the project root directory. See logback.xml file.

## Improvement proposals

See [improvement proposals file.](improvement_proposals.txt)

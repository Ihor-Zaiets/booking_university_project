#  Booking university project

## Description

Project created as my diploma work for university. Simple booking web application. 
Created using java 17 + Angular 16.

Main features of the projects are:
1. CRUD operations for main entities: Appartments, Users and Roles
2. User signing up and loginng in
3. Authentication and authorization
4. Email notification sending

## Installation guide

1. Download source code
2. Download and configure Docker
3. Configure google account to have an app password
4. Create <code>secrets.properties</code> file in <code>back-end/src/main/resources</code> directory and set values for:
   1. secret.application.email.login - as your Google account email
   2. secret.application.email.password - as your Google account app password
   3. secret.datasource.username - default "postgres", you can change it in docker-compose.yml
   4. secret.datasource.password - default "postgres", you can change it in docker-compose.yml
   5. secret.jwt.key - any key for signing jwt tokens
5. <code>cd</code> into project folder and run <code>docker-compose up</code> to create database
6. <code>cd</code> into fron-end directory and run <code>npm install</code> to download dependencies
7. Start front-end module using IDE or run command <code>npm run start</code> from ```front-end``` directory 
8. Start backend module using IDE or cmd

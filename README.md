# project-boot
Spring boot application
Use Spring Data JPA to create database tables: Country (columns: Name, Code. both - required), Person (columns: Name, Surname, Phone, Email, Updated as Date, Country ID as foregin key to Country table. Name, Surname, Updated, Country must be required) with all CRUD operations on business facade.
Create a task (frequency 1 day) to import all countries from any xml file.
Register the embedded tomcat and create REST API for actions below:
 - select all persons
 - insert new person
 - delete person
 - update person
Create a task (frequency 1 day) to delete persons which are not updated in last 60 days.

# Java_Server_Programming
Excercises from Java Server Programming course in Oulu AMK. 
I used NetBeans 8.0.2 IDE to run these exercises on Glassfish server 4.1.
Some of these projects create tables on Java Db, so you need to create JDBC connection pools and JDBC Resourses.
Select Services tab in NetBeans. Select GlassFish from Servers. 
Right-click GlassFish Server and select View Admin Domain Console. Configure then JDBC connection pools and JDBC Resources.
Read more project specific instructions below.

Some projects use MySQL instead. You need to copy MySQL driver file to GlassFish folder.
For example "C:\Program Files\glassfish-4.1\glassfish\lib", if you have installed GlassFish there.
I used mysql-connector-java-5.1.23-bin.jar file.
Create JDBC connection pools and add jdbc Resourses using MySql.
Create databases and tables on MySQL server by running sql-files inside project folders. 
You can use MySQL WorkBench for checking tables.
Read more project specific instructions below.

Instructions for 07-Nokia Java project: 

This project reads nokia financial statistics from the NOK1V-2000-01-01-2014-12-31.csv-file, creates the table "Kurssit" to "timo" database. It also stores the values read to the "timo" database table "Kurssit".

Make sure you can connect to jdbc:derby://localhost:1527/07-nokia. Check the instructions from NetBeans IDE tutorial, how to connect to the Java DB. I used GlassFish version 4.1.

Instructions for 08-Nokian-Kurssit Java project: 

This project reads nokia financial statistics from the "timo" database table "Kurssit" and shows them on localhost:8080. Make sure you are connected to jdbc:derby://localhost:1527/07-nokia.

Instructions for 09-try-with-resources Java project: 

This project reads McDonalds products categories, product names and prices from zip-file mcdonaldsprices.zip. The project creates two tables ("TUOTERYHMÄT" ja "TUOTTEET" to database "DEMO". Make sure you are connected to jdbc:derby://localhost:1527/po-demo.

Instructions for 11-mcdonalds-jpa-otmud Java project: 

This project reads McDonalds product categories, product names and prices from zip-file mcdonaldsprices.zip. The project creates three tables ("TUOTERYHMÄ", "TUOTE" and "TUOTERYHMÄ_TUOTE" to database "DEMO". Make sure you are connected to jdbc:derby://localhost:1527/11-jpa.

Instructions for 12-restaurant Java project:

This project reads the menu of a restaurant from the restaurant database. This is the first project to use MySQL connection.

Instructions for 13-classicmodels Java project:

This project reads the customer names and phone numbers from the database "classicmodels". In this project we used CustomerPhoneBean and named query "Customers.findCustomerPhones". This project uses MySQL connection.

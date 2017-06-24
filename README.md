# Java_Server_Programming
Excercises from Java Server Programming course in Oulu AMK. I used NetBeans 8.0.2 IDE to run these exercises. I used Glassfish server 4.1.

Instructions for 07-Nokia Java project: 

This project reads nokia financial statistics from the NOK1V-2000-01-01-2014-12-31.csv-file, creates the table "Kurssit" to "timo" database. It also stores the values read to the "timo" database table "Kurssit".

Make sure you can connect to jdbc:derby://localhost:1527/07-nokia. Check the instructions from NetBeans IDE tutorial, how to connect to the Java DB. I used GlassFish version 4.1.

Instructions for 08-Nokian-Kurssit Java project: 

This project reads nokia financial statistics from the "timo" database table "Kurssit" and shows them on localhost:8080. Make sure you are connected to jdbc:derby://localhost:1527/07-nokia.

Instructions for 09-try-with-resources Java project: 

This project reads McDonalds products categories, product names and prices from zip-file mcdonaldsprices.zip. The project creates two tables ("TUOTERYHMÄT" ja "TUOTTEET" to database "DEMO". Make sure you are connected to jdbc:derby://localhost:1527/po-demo.


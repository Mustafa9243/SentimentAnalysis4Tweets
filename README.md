SentimentAnalysis4Tweets
========================

Sentiment Analysis of tweets using SVM

Status of the Project: Able to pull in tweets using search query and insert them
into the local MySQL >v5.0 database server.


How to use the program:

Changes to the persistence.xml:
-------------------------------
Chnage the database server properties to your local or remote settings; add user
and password for connection authorization. Create a database and modify the 
connection URL by appending the database name.


Changes in Main.java:
---------------------
Log in to the URL given in Main.buildConfig(). Sign in with your twitter id and 
password. Then create an application and use the data that is given at summary
page when your application has been successfully created.
You need:
    (1) Consumer Key
    (2) Consumer Secret
    (3) Access Token
    (4) Access Token Secret
    

Build the program and run it. Then type in your search query; you will see how 
many tweets have been pulled with that query and those tweets are then inserted 
into your database using JPA-2.0

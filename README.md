# Mobile_Automation_Challenge

1. Automate the following test case (optional or create a new one of your choice)
- Given the application IMDB 
- Login Into the application
- Search for a movie
- And click on the first result
- Then the overview must match with an existing overviewed text

2. Automate the following test case
- Given the application IMDB
- Login into the application
- Search for a movie
- And click on any result 
- And click on Add to watch list
- Click on you global navigation option
- Click on your watchlist
- Then the watch list must contain the previous movie selected

3. Automate the following test case
- Given the application IMDB 
- Login Into the application
- Search for a movie
- And click on the first result
- Scroll down to User reviews
- Click on rate
- And select a rate
- Then a saved message must be displayed

We want to test the imdb app on android, for that appium and Android studio were used, in addition selenium and testng were used. The project is built with page object model where each screen and popup used are in the screens folder, in addition the data of the movies are in the movies.properties file.
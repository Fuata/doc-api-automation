# doc-api-automation
Framework to test Deck of Cards API

## Tests Covered
I decided to cover two test cases in the end, as they are both very similar, but use two different API endpoints to ultimately achieve the same thing.

**Create new deck, draw cards and verify the remaining cards is as expected**
1. Call the New Deck Endpoint
2. Draw from the deck five times, drawing 1 card first, then 2, continuing sequentially to 5 (15 cards total)
3. Call the Deck by Deck ID Endpoint and verify that the remaining count of the deck returned is as expected (52 - 15 = 37)

**Create new deck and draw cards in the same API call, and verify the remaining cards is as expected**
1. Call the Draw from New Deck Endpoint, drawing 1 card
2. Draw from the deck four more times, drawing 2 cards first, then 3, continuing sequentially to 5 (15 cards total)
3. Call the Deck by Deck ID Endpoint and verify that the remaining count of the deck returned is as expected (52 - 15 = 37)

## Tools Used
### IntelliJ IDEA
I am a big fan of JetBrains products, and IntelliJ IDEA is the reason why. Of all the IDEs I have used across quite a few different languages, IntelliJ seems to be the most feature-rich and streamlined. I use this for all of my Java projects.

### Maven
I used this as my build management tool, as it is the build management tool I am most familiar with. It is very easy to use with IntelliJ IDEA, and it makes the project build process very easy, by dealing with dependencies and their configurations, along with other project settings.

### TestNG
TestNG and JUnit are the two most well-known test frameworks implemented for Java. Although TestNG currently possesses more features than JUnit, the reason I went for using TestNG on this project was simply because it is the framework I have used across all projects I have been on so far.

### REST Assured
REST Assured is a Java library that makes it possible to test API services that follow the RESTful design approach. It allows for sending requests (POST, GET, PUT, DELETE etc.) to web services, and receiving and parsing response data.

### GSON
GSON is a Java library, created by Google, to allow for easy serialisation from and deserialisation to JSON. This allows my framework to take responses returned through REST Assured and convert them to a data object for easy comparison in assertions, reducing the need to use the JSON fields directly in assertions. I could have done this with REST Assured directly, but evaluating assertions in this way allows for a greater degree of abstraction.

## Other Tools Considered
### Lombok
Lombok allows for the creation of getter and setter methods without the need to explicitly declare them in source code, along with other features. As I decided to use data access objects (DAOs) in my framework, this library comes in very handy when the DAOs become exceptionally large, and every field requires its own getter method.

### Allure
I did try to implement this as my reporting tool, as Allure allows for very expressive reporting. However, I was unable to get the tool working, as one of the dependencies was not picked up correctly, and adding it manually stopped the surefire logging system from binding properly (log4j).

### Simple Logging Facade for Java (SLF4J)
SLF4J allows for easy management of logging within projects, as it allows you to add any compatible logging framework to the project. Adding expressive logging to the framework, along with establishing a consistent and robust logging process as the automation solution expands, would allow for easier debugging of issues and the ability to track the test run throughout its run.

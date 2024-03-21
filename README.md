# Target Application
An application designed to help managing the delivery and expiration dates of products in the stores.

## Tech Stack
### Backend:
+ Java
+ Spring Boot
+ Spring Security
+ Twilio API
### Frontend:
+ ReactJS
+ SCSS
+ MaterialUI

## Description
The backend is made with Java and Spring Boot.  
The application is also integrated with Twilio API to ensure quick and accurate alerts for mobile phones if the products are close to their expiration date.  
The application uses Spring Security to ensure the confidential data is kept secure.  
The frontend is made mainly with ReactJS and some lightweight styling libraries to ensure smooth user experience while also maintaining quick response time and up to no delay in data transfer.
### Summary
The application is basically a cloud database, which main purpose is to serve as a reminder of possible close expiration dates.  
It uses spring security to ensure the personal info is kept secure.  
The application allows to maintain the products in the store, their expiration dates as well as delivery dates to keep track of any formalities.
Would the product be close to its expiration date, the system will just send an alert message to the person responsible for its unloading to the shelf and therefore help to keep any product from being spoiled on a shelf. 


## Goals
+ Integrate the Twilio API (for mobile msg) or other API (for whatsapp msg) to get alerts when a product is close to its expiration date
+ Make a new DB table to keep track of the users and their "posts" to know who added which products to the server (which basically adds up to 3 tables at total, 1 of which is a "connection" one)
+ Make a fully functioning frontend and integrate it with backend
+ Also add UI to:
  * manage adding new products, along with their images, expiration and delivery dates,
  * show all the products in the database (preferably paginated to avoid overloading the server),
  * show the user/worker who added the product to know who to talk to if something happens to the said product
+ Also add a "category" column to each product so that they can be filtered into sub groups (categories) for easier searching
  > For EVEN BETTER experience, allow the products to have multiple categories, to further ease the searching process (ex. Lays Chips, could have categories such as "chips", "pack", "lays")
  > On the other hand, it can be made in a way that allows for only 1 category, but still finds the similar category while searching (ex. The user searches for "lays", and finds Lays Chips, even though its category is "chips")
  > The searching (and filtering) should account for both THE NAMES and THE CATEGORIES = 1 searchbar, typing in either the name, or the right category, finds the correct product
+ that also means adding a new button to CREATE a new category, and integrate it with database, so that every category (both already created and new ones) get their respective items under them
+ There should be 3 dates:
   * a delivery date (when the product arrived)
   * an accepted into system date (when the product was accepted and put into the system)
   * an expiration date 
  ### *Eventually:
  + Add spring security to the project and make it work on basic dummy tests
  + For the frontend, add a simple register form, login form
  

Feature: Create a new product

  Scenario: user is logged in
    Given user logins to ECOM app with "loginResourceURL" endpoint with userName "newfcid1903@gmail.com" and password "Honda@2022"

  Scenario Outline: Create a new product for API application
    Given user wants to create a new product "<productName>","<description>"
    When user hits the "createProductResourceURL" endpoint
    Then "Product Added Successfully" message is received at backend for "createProductTest"
    Examples:
      |productName|description|
      |Samsung    |Tablet     |
#      |Apple      |Phone      |
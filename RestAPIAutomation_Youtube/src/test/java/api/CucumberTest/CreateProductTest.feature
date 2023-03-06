Feature: ECOM App

  Scenario Outline: Create new Product
    Given user wants to add new product "<productName>" ,"<productDescription>" ,"createProductURL"
    Then "Product Added Successfully" message is received at backend for "createProductTest"
    Examples:
    |productName|productDescription|
    |Samsung    |Tablet            |
    |Apple      |Phone             |
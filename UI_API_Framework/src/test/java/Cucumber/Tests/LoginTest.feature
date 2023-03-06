Feature: Login to API application

  Scenario Outline: Login to API application
    Given user logins to ECOM app via API
    When user hits the "loginResourceURL" endpoint with userName "<userName>" and password "<userPassword>"
    Then "Login Successfully" message is received at backend for "loginTest"
    Examples:
      |userName             |userPassword |
      |newfcid1903@gmail.com|Honda@2022   |
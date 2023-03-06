Feature: Login to API application

Scenario: Login to API application
  Given user logins to ECOM app via API
  When user hits the "loginURL" endpoint with userName "newfcid1903@gmail.com" and password "Honda@2022"
  Then "Login Successfully" message is received at backend for "loginTest"
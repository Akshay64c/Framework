Feature: Purchase the order from ECommerce Website

  Background:
    Given user has opened the ECommerce Website

  @SubmitOrder
  Scenario Outline: Submit order E2E
    Given user has logged in with email "<email>" and password "<password>"
    When user adds the product "<productName>" to cart
    And submits the order for the product "<productName>" for country "<country>"
    Then "<confirmationMessage>" message is displayed on the confirmation page

    Examples:
      |email                |password   |productName    |country              |confirmationMessage         |
      |newfcid1903@gmail.com|Honda@2022 |adidas original|United Kingdom       |THANKYOU FOR THE ORDER.     |

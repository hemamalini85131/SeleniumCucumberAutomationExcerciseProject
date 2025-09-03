
@Sanity @Regression
Feature: Add Products to Shopping Cart

  # Background ensures login and navigation to the Products page
  Background:
    Given User launches the AutomationExercise website
    And User logs in with valid credentials from "UserCredentials.json"
    And User is on the Products page
#
  #@Sanity @Regression
  #Scenario Outline: Add "<product>" from "<categoryName>" -> "<productType>" to cart
    #When User selects "<categoryName>" category and "<productType>" productType
    #And User adds "<product>" to cart
    #Then "<product>" should be added successfully to the cart    
    #Examples:
      #| categoryName | productType   | product        |
      #| Women        | Dress         | Rose Pink Embroidered Maxi Dress |
      #| Women        | Dress         | Stylish Dress |
      #| Men          | Tshirts       | Premium Polo T-Shirts    |
      #| Kids         | Tops & Shirts | Printed Off Shoulder Top - White|
      #
  @Regression
  Scenario: Add multiple products to cart and verify in cart
    When User adds following products to cart:
      | Product Name   | Quantity |
      | Winter Top     | 2        |
      | Sleeves Top and Short - Blue & Pink   | 1  |
    And User navigates to the Cart page
    Then All added products should reflect in the cart with correct details

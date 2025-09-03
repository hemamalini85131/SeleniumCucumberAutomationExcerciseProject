
# Feature 1: User Registration and Login
@Smoke @Sanity @Regression
Feature: User Registration and Login on AutomationExercise

  Scenario Outline: Successful user registration with valid details
    Given User launches the AutomationExercise website
    When User clicks on Signup/Login link
    And User enters name "<name>" and email "<email>" for signup
    And User fills personal details: "<password>", "<firstName>", "<lastName>","<day>","<month>","<year>" "<address>", "<city>", "<state>", "<zipcode>", "<mobile>"
    And User clicks on Create Account	
    Then Account should be created successfully

    Examples:
      | name   | email             | password | firstName | lastName | day | month | year | address     | city      | state     | zipcode | mobile     |
      | fiya   | abca@test.com     | Test@111 | fiya      | M        | 10  | May   | 1995 | 12A Street  | Bangalore | Karnataka | 560001  | 9999999999 |
      | Radha  | radha@test.com    | Pass@456 | Radha     | R        | 20  | June  | 2000 | 34B Lane    | Mumbai    | Maharashtra | 400001 | 8888888888 |

  @Smoke @Sanity @Regression
  Scenario Outline: Login with existing user credentials
    Given User is on the Login page
    When User enters email "<email>" and password "<password>"
    And User clicks on Login
    Then "<user>" should be logged in successfully
    

    Examples:
      | email            | password  | user  |
      | hema1@test.com   | Test@123  | Hema  |
      | hina@test.com    | hina@123  | hina |

  @Negative @Regression
  Scenario Outline: Login with invalid credentials
    Given User is on the Login page
    When User enters email "<email>" and password "<password>"
    And User clicks on Login
    Then Error message should be displayed

    Examples:
      | email               | password   |
      | fakeuser@test.com  | Wrong@123  |

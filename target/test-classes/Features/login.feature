@login_feature
Feature: Test login functionalities

  Background:
    Given a user navigates to Account tab


  @positive_test
  Scenario: Check login is successful with valid credentials
    When user enters username "tasin.chowdhury1@gmail.com" and password "Chowdhury12!!"
    And click on login button
    Then user is navigated to Dashboard

  @negative_test
  Scenario: Check login is unsuccessful with invalid credentials
    When user enters username "tasin.chowdhury1@gmail.com" and password "Newyorkcity12"
    And click on login button
    Then user is failed to login

  @dataDriven_test
  Scenario Outline: Check login is successful with valid credentials for multiple users
    When user enters username "<username>" and password "<password>"
    And click on login button
    Then user is navigated to Dashboard

    Examples:
    |username|password|
    |tasin.chowdhury1@gmail.com   |Chowdhury12!!|
    |tasinchowdhury9.0@gmail.com   |Chowdhury12!!|

  @dataTable_test
  Scenario: Check login is successful using data table
    When user click on login button entering credentials
    |username|password|
    |Tasin   |12345   |
    Then user is navigated to Dashboard


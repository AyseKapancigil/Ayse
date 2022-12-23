Feature:Calculate optimal change post api

  As a user of the API
  I want to be able to submit a pence amount and receive the optimal change calculation
  So that I can determine the minimum number of pounds and pence denominations needed to make the specified amount

  Scenario Outline:Submitting valid pence amount with boundary values optimal change calculation
  Given user has submitted a value of  "<penceSubmitted>"
  And  User generates token for Authorization
  When user send a post request with the required  payload
  Then user should receive a response with a status code of 201
  Then user validates the response data
  Examples: data
  |penceSubmitted|
  |50122 |
  |234|
  |0  |
  |123456789|



  Scenario Outline: Submitting invalid  pence amount for destructive optimal change calculation
    Given user has submitted a value of  "<penceSubmitted>"
    And  User generates token for Authorization
    When user send a post request with the required  payload
    Then user should receive a response with a status code of 4XX
    Then user validates the response data

    Examples: data
      | penceSubmitted |
      |-3456|
      |#2345|
      |564er|








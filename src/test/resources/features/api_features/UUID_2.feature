  Feature:optimal_change_api
  Scenario Outline:external_id
     Given user sends a get request for optimal change with "<external
      When user converts json data to java
      Then user verifies the response contain external ID
    Examples: data
    |external ID|
    |UU
  Feature:optimal_change_api
  Scenario Outline:external_id
     Given user sends a get request for optimal change with "<externalID>"
      When user converts json data to java for deserilization
      Then user verifies the response data
    Examples: data
    |externalID|
    |UUID_1    |
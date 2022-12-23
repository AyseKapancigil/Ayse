@UUID_1 @url @smoke
 Feature:Calculate optimal change get api

  I assume that "UUID_num" is the externalID format.I validate my get request with "externalID" field.
  "penceSubmitted" field has been used for post requests.


  Scenario Outline:Retrieving optimal change calculation by valid external ID
  Given user sends a get request for submitting with "<externalID>"
  And user generates token for authorization
  When user retrieves the optimal change using the external ID
  And user converts json data to java with de-serialization
  Then I should receive a response with a status code of 200
  Then user should receive a response with the following  information pounds and pence

  Examples: data
  |externalID|
  |"UUID_1"|


  Scenario Outline:Retrieving optimal change calculation by invalid external ID
  Given user sends a get request for submitting with invalid "<externalID>"
  And user generates token for authorization
  When user retrieves the optimal change using the invalid external ID
  And user converts json data to java with de-serialization
  Then I should receive a response with a status code of 4XX
  Then user should receive a response with the following  information pounds and pence

  Examples: data
    |externalID|
    |"YU_98"|
    |"DR_786|



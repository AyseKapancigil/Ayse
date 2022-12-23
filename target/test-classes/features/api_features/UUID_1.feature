@UUID_1 @url
 Feature:Calculate optimal change get api
  Scenario Outline:Retrieving optimal change calculation by external ID
  Given user sends a get request for submitting with "<externalID>"
   And user generates token for authorization
   When user retrieves the optimal change using the external ID
  And user converts json data to java with de-serialization
   Then I should receive a response with a status code of 200
   Then user should receive a response with the following  information pounds and pence

   Examples: data
|externalID|
| "UUID_1" |






  And the response body should contain a JSON object with the following properties
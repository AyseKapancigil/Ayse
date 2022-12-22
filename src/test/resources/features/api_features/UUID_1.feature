@UUID_1 @url
 Feature: optimal_change_api
 Scenario Outline: Submitting a value in pence and receiving optimal change
  Given user sends a get request for  submitting a value of "<penceSubmitted>" pence with external ID "<externalID>"
   When user retrieves the optimal change for the submitted value using the external ID
  And user converts json data to java
   Then user should receive a response with the following  information "<pounds>" "<pence>" and "<dateTime>"

    Examples: data
| penceSubmitted | externalID    | pounds|          pence                                                      | dateTime                 |
| 50122          | "UUID_1"      | { "50": 10 }    | { "20": 1 } ,{"10" :0 } , {"5" :0 } , {"2" :0 },{"1" :0 } |"2022-04-30T10:56:59.138" |




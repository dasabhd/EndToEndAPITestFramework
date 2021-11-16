Feature: Test Library API features

  @AddBook
  Scenario Outline: To validate whether AddBook API functionality is working correctly
    Given AddBook Payload with "<Name>","<ISBN>","<Aisle>","<Author>"
    When User places AddBook request through POST method
    Then Msg of response is successfull

    Examples:
        | Name | ISBN | Aisle | Author |
        | Abhishek Das1 | 457786312 | A732111GH2 | Ravana |
        | Kushol Bhowmick1 | 789211412 | ER123341AS2 | Ramaan |


    @GetBook
    Scenario Outline: To validate whether GetBook API functionality is working correctly
      Given Query Parameters Given "<Author>"
      When User places GetBook request through GET method
      Then Msg of response is successfull
      And Book Name is "<BookName>"

      Examples:
         | Author | BookName |
         | Ravana | Abhishek Das1 |


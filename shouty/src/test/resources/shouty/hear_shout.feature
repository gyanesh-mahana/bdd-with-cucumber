Feature: Shout
  Description-
  This is a piece in feature file which is not a part of gherkin
  This is just for the purpose of writing important comments or to-do lost etc.
  
  Shouty allows users to "hear" other users "shouts" when they are close enough
  Rule keyword is used
  To do:
  -Data table implementation
  
  Tips:
  -Business Rules are defines with Rule tag, after Gherkin V6 (here shows Suntax error :()
  -Backgrounds a
  	-Used to avoid repeated contexts and to improve readability, also they are written before the Business rules are defined
  	-Sometimes they can reduce readability and maintainability
  -Table can be used to represent data with pipe(|) separators, gherkin removes the spaces trailing |

  #Rule: Shouts can be heard from other users
  Scenario: Listener hears the message
    Given the range is 100
    And persons are located at
      | name | location |
      | Lucy |        0 |
      | Sean |       50 |
    When Sean shouts "free bagels at Sean's"
    Then Lucy should hear Sean's message

  #Rule:	Shouts can only be heard within range
  Scenario: Listener is within range
    Given the range is 100
    And persons are located at
      | name | location |
      | Lucy |        0 |
      | Sean |       50 |
    When Sean shouts "free bagels at Sean's"
    Then Lucy should hear Sean's message

  Scenario: Listener is out of range
    Given the range is 100
    And persons are located at
      | name  | location |
      | Larry |        0 |
      | Mohan |      150 |
    When Mohan shouts "free bagels at Mohan's"
    Then Larry should not hear Mohan message

Feature: Shout

	Description-
		This is a piece in feature file which is not a part of gherkin
		This is just for the purpose of writing important comments or to-do lost etc.
	
	Shouty allows users to "hear" other users "shouts" when they are close enough
	
	To do:
		-only shout to people within a certain distance
	
	Tips:
		-Business Rules are defines with Rule tag
		-Backgrounds a
			-Used to avoid repeated contexts and to improve readability, also they are written before the Business rules are defined
			-Sometimes they can reduce readability and maintainability	
	
	Rule: Shouts can be heard from other users
			
	  Scenario: Listener hears the message
	  	Given the range is 100
	  	And a person named Lucy is located at 0
	    And a person named Sean is located at 50
	    When Sean shouts "free bagels at Sean's"
	    Then Lucy should hear Sean's message
	    
	Rule:	Shouts can only be heard within range
	    
		Scenario: Listener is within range
			Given the range is 100
			And a person named Lucy is located at 0
	    And a person named Sean is located at 50
	    When Sean shouts "free bagels at Sean's"
	    Then Lucy should hear Sean's message
		
		Scenario: Listener is out of range
			Given the range is 100
			And a person named Larry is located at 0
	    And a person named Mohan is located at 120
	    When Mohan shouts "free bagels at Mohan's"
	    Then Larry should not hear Mohan's message

		
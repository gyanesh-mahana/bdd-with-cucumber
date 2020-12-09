
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
		
	Background:    
			Given a person named Lucy
	    And a person named Sean  	
	
	Rule: Shouts can be heard from other users
			
	  Scenario: Listener hears the message
	    When Sean shouts "free bagels at Sean's"
	    Then Lucy should hear Sean's message
	
	  Scenario: Listener hears a different message
	    When Sean shouts "Free coffee!"
	    Then Lucy should hear Sean's message
	    
	Rule: Shouts should only be heard to listener within range
	
		Scenario: Listener is within range
		
		Scenario: Listener is out of range
		
		
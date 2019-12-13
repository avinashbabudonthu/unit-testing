Feature: Calculator functionalities 
	All functionalities of calculator Add, Subtract, Multiply, Divisions
	
Background: 
	Given Calculate Operations: 
		| add |
		| subtract |
		
Scenario Outline: Calcualte 2 numbers 
	Given Two numbers 
	When Numbers are <Number1> and <Number2> 
	Then Addition is <Addition> and Subtraction is  <Subtraction> 
	
	Examples: 
		| Number1 | Number2 | Addition | Subtraction |
		| 0 | 10 | 10 | -10 |
		| 20 | 10 | 30 | 10 |
		| 40 | 20 | 60 | 20 |
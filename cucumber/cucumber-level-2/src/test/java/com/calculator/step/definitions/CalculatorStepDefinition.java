package com.calculator.step.definitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class CalculatorStepDefinition {

	private List<Integer> results = new ArrayList<>();
	private List<String> operations;

	@Given("Calculate Operations:")
	public void calculateOperations(DataTable dataTable) {
		operations = dataTable.asList();

	}

	@Given("Two numbers")
	public void weHaveTwoNumbers() {
		System.out.println("addition of 2 numbers");
	}

	@When("Numbers are {int} and {int}")
	public void additionInput(Integer num1, Integer num2) {
		operations.stream().forEach(operation -> {
			switch (operation) {
			case "add":
				results.add(num1 + num2);
				break;
			case "subtract":
				results.add(num1 - num2);
				break;
			}
		});

	}

	@Then("Addition is {int} and Subtraction is  {int}")
	public void additionResult(Integer addition, Integer subtraction) {
		Assert.assertEquals(addition.toString(), results.get(0).toString());
		Assert.assertEquals(subtraction.toString(), results.get(1).toString());
	}
}

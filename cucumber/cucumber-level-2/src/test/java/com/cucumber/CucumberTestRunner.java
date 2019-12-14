package com.cucumber;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber" }, snippets = SnippetType.CAMELCASE, glue = {
		"com.cucumber.step.definitions" }, features = { "classpath:features/calculator.sum",
				"classpath:features/scenario.outline", "classpath:features/mockito" })
public class CucumberTestRunner {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
}
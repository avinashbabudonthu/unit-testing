package com.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber" }, snippets = SnippetType.CAMELCASE, glue = {
		"com.calculator.step.definitions" }, features = { "classpath:features" })
public class CucumberTestRunner {
}
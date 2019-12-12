package com.calculate;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" }, snippets = SnippetType.CAMELCASE, features = "classpath:StepDefinition")
public class CucumberTest {

}

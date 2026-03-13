package com.automation.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

/**
 * JUnit 5 test suite entry point for Serenity + Cucumber.
 *
 * Using the JUnit Platform Suite API (@Suite) instead of the legacy
 * JUnit 4 @RunWith(CucumberWithSerenity) runner ensures that the
 * parallel execution settings in junit-platform.properties are
 * honoured by the test engine.
 */
@Suite
@IncludeEngines("cucumber")
@ConfigurationParameter(key = "cucumber.glue",   value = "com.automation.steps.definitions")
@ConfigurationParameter(key = "cucumber.features", value = "src/test/resources/features")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty,net.serenitybdd.cucumber.core.plugin.SerenityReporter")
public class CucumberTestSuite {
}

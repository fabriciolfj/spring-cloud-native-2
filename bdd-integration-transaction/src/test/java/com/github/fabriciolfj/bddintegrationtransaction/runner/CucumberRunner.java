package com.github.fabriciolfj.bddintegrationtransaction.runner;

import com.github.fabriciolfj.bddintegrationtransaction.BddIntegrationTransactionApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features/"},
        plugin = { "pretty", "html:target/site/cucumber-pretty","json:target/cucumber.json" },
        glue = { "cucumber.api.spring", "com.github.fabriciolfj.bddintegrationtransaction"}
)
@CucumberContextConfiguration
@ContextConfiguration(classes = BddIntegrationTransactionApplication.class)
public class CucumberRunner {
}

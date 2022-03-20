package br.com.fcsilva.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/inserir-conta.feature",
        glue = "br.com.fcsilva",
        //tags = "~@ignore",
        plugin = {"pretty", "html:target/report-html", "json:target/report.json" },
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false


)
public class RunnerTest { }

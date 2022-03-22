package br.com.fcsilva.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "br.com.fcsilva.steps",
        //tags = "~@ignore",
        plugin = {"pretty", "html:target/report-html", "json:target/report.json" },
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false


)
public class RunnerTest {

//    // resetando o bando
//    @BeforeClass
//    public static void resetaBanco(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://srbarriga.herokuapp.com");
//        driver.findElement(By.id("email")).sendKeys("");
//        driver.findElement(By.id("")).sendKeys("");
//        driver.findElement(By.id("")).click();
//        driver.findElement(By.id("")).click();
//        driver.quit();
//    }

}

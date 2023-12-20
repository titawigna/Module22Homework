package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepDef"}, //dimana step definition disimpan
        features = {"src/test/java/features"}, //dimana feature file disimpan
        plugin = {"pretty", "html:reports/cucumber-report.html"},
        //menambahkan informasi mengenai step yg dieksekusi,
        tags = "@login-valid-emailandpass"
        ,
        monochrome = true
)
public class Runner {
}

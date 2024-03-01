package Test_Runner;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/Feature_files/loginPage.feature",
	    glue = "Stepdefination",
	    plugin = {"pretty", "html:target/cucumber-reports/login.html"},
	    dryRun = false
	    ,tags = ("@ValidLogin")

	    
	)

@Test(testName = "Login Functionality")
public class LoginPageRunner extends AbstractTestNGCucumberTests {

}

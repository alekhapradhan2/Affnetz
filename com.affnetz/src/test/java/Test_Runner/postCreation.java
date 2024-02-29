package Test_Runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/Feature_files/postCreation.feature",
	    glue = "Stepdefination",
	    plugin = {"pretty", "html:target/cucumber-reports"},
	    dryRun = false
	    
	    
	)

@Test(testName = "PostCreation")
public class postCreation extends AbstractTestNGCucumberTests {

}

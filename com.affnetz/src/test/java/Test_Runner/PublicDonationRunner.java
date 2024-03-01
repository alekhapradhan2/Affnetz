package Test_Runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/Feature_files/publicDonation.feature",
	    glue = "Stepdefination",
	    plugin = {"pretty", "html:target/cucumber-reports/login.html"},
	    dryRun = false
	   

	    
	)

@Test(testName = "Public Donation")

public class PublicDonationRunner extends AbstractTestNGCucumberTests{
	
	

}

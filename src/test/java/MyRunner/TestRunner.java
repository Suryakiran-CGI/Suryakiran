package MyRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

/*import org.junit.runner.RunWith;
import io.cucumber.junit.*;
*/
//@RunWith(Cucumber.class)
@CucumberOptions( 
		        
     features = "./src/test/java/Features",
     glue = "StepDefinition",
     dryRun = false,
    /* plugin = {
    		     "pretty","html:Reports/HTMLReport.html",
    		     "json:Reports/Jsonreport.json",
    		     "junit:Reports/Junitreport.xml"
    		 })*/
     plugin= {"pretty","html:target/AdvanceReport/demowebshop.html","json:target/cucumber1/cucumber.json"})

     


public class TestRunner extends AbstractTestNGCucumberTests{

	
}






















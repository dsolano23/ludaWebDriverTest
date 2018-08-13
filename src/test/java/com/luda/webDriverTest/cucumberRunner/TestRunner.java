package com.luda.webDriverTest.cucumberRunner;

import com.luda.webDriverTest.enviroment.BrowserCodes;
import com.luda.webDriverTest.enviroment.Environment;
import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.exception.NotFoundResourceException;
import com.luda.webDriverTest.utilsType.FileWriter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)


@CucumberOptions(
				plugin = { 
						"pretty",
						"json:target/cucumber.json", 
						//"html:target/site/cucumber-pretty",
						},
		
				//Used only if you want run a specific feature by tag : @login, @search or @filter
				tags = {"@createFinalUser"},
				
				features = {"src/test/resources/features"},
				glue = {"com.luda.webDriverTest.stepDefinition"}
				)

public class TestRunner {
	
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TestRunner.class);
	

		@BeforeClass
        public static void startEnvironment() throws Exception {

			if (FileWriter.getEnvProps().getProperty(BrowserCodes.BROWSER) != null && FileWriter.getEnvProps().getProperty(BrowserCodes.BROWSER) != null) {
				String browser = FileWriter.getEnvProps().getProperty(BrowserCodes.BROWSER);
				String mainURL = "";
		    	Environment environment = new Environment(browser, mainURL );
		    	LOGGER.debug("Generating masterthought HTML reports .......");
		    	Hooks.setEnvironment(environment);

		        LOGGER.info("*************************************");
			}

		}


		@AfterClass
	    public static void generateHTMLReport() throws InterruptedException, NotFoundResourceException {

	        LOGGER.debug("Generating masterthought HTML reports .......");

			File reportOutputDirectory = new File("target");
			List<String> jsonFiles = new ArrayList<>();
			jsonFiles.add("target/cucumber.json");

			String buildNumber = "1";
			String projectName = "cucumberProject";
			boolean runWithJenkins = false;
			boolean parallelTesting = false;

			Configuration configuration = new Configuration(reportOutputDirectory, projectName);
			// optional configuration

			configuration.setParallelTesting(parallelTesting);
			configuration.setRunWithJenkins(runWithJenkins);
			configuration.setBuildNumber(buildNumber);
			// addidtional metadata presented on main page
			configuration.addClassifications("Platform", "Windows");
			configuration.addClassifications("Browser", "Firefox");
			configuration.addClassifications("Branch", "release/1.0");

			ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
			Reportable result = reportBuilder.generateReports();
			// and here validate 'result' to decide what to do
			// if report has failed features, undefined steps etc
			LOGGER.debug("Generated Masterthought HTML reports");


	    }
    }



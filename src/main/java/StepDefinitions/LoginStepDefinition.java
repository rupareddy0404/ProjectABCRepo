package StepDefinitions;

import java.io.IOException;
//import java.time.Duration;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import AllPages.LoginPage;
import GenericMethods.AllGenericMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends LoginPage
{
	@Given("user is on login page")
	public void user_is_on_login_page() throws IOException
	{
		
		Application_Launch();
		ExtentCucumberAdapter.addTestStepLog("Launched successfully");
		ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(AllGenericMethods.TakeScreenCapture());
	}

	@When("^user enters valid username\"([^\"]*)\"$")
	public void user_enters_valid_username(String emailid) throws IOException
	{
		Enter_Email(emailid);
		ExtentCucumberAdapter.addTestStepLog("Username entered successfully");
		ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(AllGenericMethods.TakeScreenCapture());
	}


	@When("^user enters valid password\"([^\"]*)\"$")
	public void user_enters_valid_password(String password) throws IOException
	{
		Enter_Password(password);
		ExtentCucumberAdapter.addTestStepLog("Password entered successfully");
		ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(AllGenericMethods.TakeScreenCapture());
	}
	
	
	@When("clicks on submit")
	public void clicks_on_submit() throws IOException
	{
		Click_Submit();
		ExtentCucumberAdapter.addTestStepLog("Loggedin successfully");
		ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(AllGenericMethods.TakeScreenCapture());
	}
	
}





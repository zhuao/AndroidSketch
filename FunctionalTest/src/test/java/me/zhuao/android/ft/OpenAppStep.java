package me.zhuao.android.ft;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class OpenAppStep {

    private AndroidDriver driver;

    @When("^I navigate to \"([^\"]*)\"$")
    public void i_navigate_to(String screenTitle) throws Throwable {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.SELENDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nexus5");
        capabilities.setCapability(MobileCapabilityType.APP, new File("").getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.APP_WAIT_ACTIVITY, "de.komoot.android.app.JoinKomootActivity");

        driver = new AndroidDriver(new URL(""), capabilities);
        driver.startActivity("me.zhuao.android.sample", "MainActivity");
    }

    @Then("^I see \"([^\"]*)\"$")
    public void iSee(String content) throws Throwable {

        List elements = driver.findElements(new MobileBy.ByAndroidUIAutomator(content));
    }
}

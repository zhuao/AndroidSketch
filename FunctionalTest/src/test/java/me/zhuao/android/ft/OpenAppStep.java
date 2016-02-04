package me.zhuao.android.ft;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpenAppStep {

    @When("^I navigate to \"([^\"]*)\"$")
    public void i_navigate_to(String arg1) throws Throwable {
        System.out.print("I navigate to" + arg1);
    }

    @Then("^I see \"([^\"]*)\"$")
    public void iSee(String content) throws Throwable {
        System.out.print("I saw " + content);
    }
}

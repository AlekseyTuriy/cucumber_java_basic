package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Given("^I am on the locators page$")
    public void iAmonTheLocatorsPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    @Then("^I should see both locators page headers$")
    public void iShouuldSeeBothLocatorsPageHeaders() throws Throwable {
        assertEquals("Heading 1",
                driver.findElement(By.id("heading_1")).getText());
        assertEquals("Heading 2 text",
                driver.findElement(By.id("heading_2")).getText());
    }

    @And("^Buttons in Locators page are clickable$")
    public void buttonsInLocatorsPageAreClickible() throws Throwable {
        assertTrue(driver.findElement(By.name("randomButton1")).isEnabled());
        assertTrue(driver.findElement(By.id("buttonId")).isEnabled());
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) page age$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }


    @Then("^I see error: \"([^\"]*)\"$")
    public void youHaventEnteredAnythingInAgeField(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("error")).getText());
    }
    @Then("^I am not navigated to age message page")
    public void iAmNotNavigatedToAgePage()  throws Throwable {
         assertTrue(driver.getCurrentUrl().contains("https://kristinek.github.io/site/examples/age"));}



    @Given("^I (?:am on|open) age page feedback$")
    public void iAmOnFeedbackAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");}
    @When("^I enter feedback name: \"([^\"]*)\"$")
    public void iEnterFeedbackName(String name) throws Throwable {
        driver.findElement(By.id("fb_name")).clear();
        driver.findElement(By.id("fb_name")).sendKeys(name);}
    @And("^I enter feedback age: (\\d+)$")
    public void iEnterFeedbackAge(int age) throws Throwable {
        driver.findElement(By.id("fb_age")).sendKeys(String.valueOf(age));}

    @And("^I click send feedback age$")
    public void iClickSubmitFeedbackAge() throws Throwable {
        driver.findElement(By.cssSelector("#fb_form > form > button")).click();}
    @Then("^I see feedback name: \"([^\"]*)\"$")
    public void iSeeFeedbackName(String name) throws Throwable {
        assertEquals(name,driver.findElement(By.id("name")).getText());}
    @Then("^I see feedback age: \"([^\"]*)\"$")
    public void iSeeFeedbackAge(String age) throws Throwable {
        assertEquals(age,driver.findElement(By.id("age")).getText());}

// Task1features ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//    error cases Scenaroi Uotline

    @Given("^I am on age page error cases$")
    public void iAmOnPageErrorCases() throws Throwable {
    driver.get("https://kristinek.github.io/site/tasks/enter_a_number");}

    @When("^I enter number error case: \"([^\"]*)\"$")
    public void iEnterNumberErrorCase(String number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);}


    @And("^I click submit error cases$")
    public void iClickSubmitErrorCases() throws Throwable {
        driver.findElement(By.cssSelector("body > div.w3-row > div > div > div.w3-container.w3-card-4 > button")).click();}

    @Then("^I see message error cases: \"([^\"]*)\"$")
    public void iSeeMessageErrorCase(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());}


    //    correct number Scenario

    @When("^I enter number correct case: (\\d+)$")
    public void iEnterCorrectNumberCase(String number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);}


    @And("^I click submit correct cases$")
    public void iClickSubmitCorrectCases() throws Throwable {
        driver.findElement(By.cssSelector("body > div.w3-row > div > div > div.w3-container.w3-card-4 > button")).click();}

    @Then("^I see message correct cases:\"([^\"]*)\"$")
    public void iSeeMessageCorrectCase(String message) throws Throwable {
         assertEquals(message,driver.switchTo().alert().getText());
        }
    @When("^I enter number correct case simple : \"([^\"]*)\"$")
    public void iEnterCorrectNumberCaseSimple(String number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);}


}

package stepDefinitions;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static org.junit.Assert.*;

public class Test2featureSteps {
    private WebDriver driver;

    public Test2featureSteps() {
        this.driver = Hooks.driver;
    }


    @Given("^I am on People with jobs$")
    public void iIamonPeopleWithJobs() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people.html");
    }

    @When("^I press add person$")
    public void iPressAddPerson() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @And("^I put in Name \"([^\"]*)\"$")
    public void iPutInName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I put in Surname \"([^\"]*)\"$")
    public void iPutInSurname(String surname) throws Throwable {
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys(surname);
    }

    @And("^I put in Job \"([^\"]*)\"$")
    public void iPutInSJob(String job) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^I put in Dateofbirth \"([^\"]*)\"$")
    public void iPutInDate(String date) throws Throwable {
        driver.findElement(By.id("dob")).clear();
        driver.findElement(By.id("dob")).sendKeys(date + "\n");
    }

    @And("^I put in language \"([^\"]*)\"$")
    public void iPutInLanguage(String language) throws Throwable {
        driver.findElement(By.id(language)).click();
    }

    @And("^I put in Gender \"([^\"]*)\"$")
    public void iPutInGender(String gender) throws Throwable {
        driver.findElement(By.id(gender)).click();
    }

    @And("^I put in Emplyeestatus \"([^\"]*)\"$")
    public void iPutInEmployeeStatus(String status1) throws Throwable {
        Select dropdown = new Select(driver.findElement(By.id("status")));
        dropdown.selectByValue(status1);
        Thread.sleep(3000);
    }

    @Then("^I click Add$")
    public void iClickAdd() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"modal_button\"][1]")).click();
    }

    @And("^I put in all Date$")
    public void iPutInAllDate(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
//    public void iPutInAllDates(DataTable inputtable) throws Throwable {
//        for (Map<String, String> feedbackinput : inputtable.asMaps(String.class, String.class)) {
//
//            driver.findElement(By.id("fb_name")).sendKeys("name");
//            driver.findElement(By.id("name")).clear();
//            driver.findElement(By.id("name")).sendKeys(feedbackinput.get("name"));
//            driver.findElement(By.id("surname")).clear();
//            driver.findElement(By.id("surname")).sendKeys(feedbackinput.get("surname"));
//            driver.findElement(By.id("job")).clear();
//            driver.findElement(By.id("job")).sendKeys(feedbackinput.get("job"));
//            driver.findElement(By.id("dob")).clear();
//            driver.findElement(By.id("dob")).sendKeys("dob" + "\n");
//            driver.findElement(By.xpath("//*[@id=\"" + language + "\"]")).click();
//            driver.findElement(By.xpath("//*[@id=\"" + gender + "\"]")).click();
//            driver.findElement(By.xpath("//*[@id='status']/option[value=" + getClass(iPutInEmployeeStatus() + "]")).isSelected());
        }
    }

//    @When("^I go to Edit Person$")
//    public void iGoToEditPerson() throws Throwable {
//        name1=driver.findElement(By.cssSelector("#person0 > div > span.name")).getAttribute("value");
//        String name2 = "Mike";
//        if( name1 = "name2" );
//        driver.findElement(By.className("fa fa-pencil")).click();}

    @And("^I change Name to \"([^\"]*)\"$")
    public void iChangeName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @Then("^I dont see Mike")
    public void iDontSeeMike() throws Throwable {
        assertNotEquals("Mike", driver.findElement(By.className("name")).getAttribute("value"));
        assertNotEquals("Kid",driver.findElement(By.className("surname")).getAttribute("value"));
    }

    @When("^I Remove Person Mike")
    public void iRemovePersonMike() throws Throwable {
        driver.findElement(By.cssSelector("#person1 > span.w3-closebtn.closebtn.w3-padding.w3-margin-right.w3-medium")).click(); }

    @When("^I press edit Mike")
    public void iPressEditMike() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"person1\"]/span[2]/i")).click(); }

    @And("^I change name Mike to \"([^\"]*)\"$")
    public void iChengeNameMikeTo(String change) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(change);; }

    @And("^I click Edit Mike")
    public void iClickEditMike() throws Throwable{
        driver.findElement(By.id("modal_button")).click();}

    @And("^I see changed Mike name\"([^\"]*)\"$")
    public void iChangedMikeName(String name) throws Throwable {
        assertNotEquals(name, driver.findElement(By.cssSelector("#person1 > div > span.name")).getAttribute("value")); }




}










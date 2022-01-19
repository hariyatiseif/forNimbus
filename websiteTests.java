package staffManagement;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class websiteTests {

    @Test
    public void loginSuccessTest() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://AutoTest.Time2Work.com");

        driver.manage().window().maximize();

        WebElement username=driver.findElement(By.xpath("//input[@id='tbUsername']"));
        WebElement password=driver.findElement(By.xpath("//input[@id='tbPassword']"));
        WebElement clickLoginButton=driver.findElement(By.xpath("//input[@id='btnLogin_btn_btnLogin_input']"));
        username.sendKeys("Seiftie@time2work.com");
        password.sendKeys("@Seiftie");

        clickLoginButton.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //===================================================//
        //click STAFF from Nav menu
        WebElement staffMenuNav = driver.findElement(
                By.xpath("//span[normalize-space()='Staff']"));

        //click Staff
        staffMenuNav.click();

        WebElement staffManagementNavMenu = driver.findElement(By.xpath("//span[normalize-space()='Staff Management']"));
        new Actions(driver).moveToElement(staffManagementNavMenu).perform();

        WebElement selectStaffManagementFromNavMenu = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Staff Management']")));
        new Actions(driver).moveToElement(selectStaffManagementFromNavMenu).perform();

        selectStaffManagementFromNavMenu.click();

        //===================================================//
        //web elements on Staff Management - title + add new record

        WebElement webpageTitle = driver.findElement(By.id("pageTitle"));

        //verified page title
        webpageTitle.getText();
        assertEquals(webpageTitle.getText(), "Staff Management", "Incorrect title");

        WebElement addNewRecordButton = driver.findElement(
                By.xpath("//span[contains(text(),'Add new record')]"));

        //click add new record
        addNewRecordButton.click();

        //web elements on new staff editor:
        WebElement usernameStaffEditor = driver.findElement(
                By.xpath("//input[@id='cphContent_cphContent_frmEdit_Username']"));

        WebElement passwordStaffEditor = driver.findElement(
                By.xpath("//input[@id='cphContent_cphContent_frmEdit_tbStaffPassword']"));

        WebElement clickDropdownTitle = driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_frmEdit_TitleDescription_cb_TitleDescription_Arrow"));

        WebElement knownAsStaffEditor = driver.findElement(
                By.xpath("//input[@id='cphContent_cphContent_frmEdit_PreferedName']"));

        WebElement firstnameStaffEditor = driver.findElement(
                By.xpath("//input[@id='cphContent_cphContent_frmEdit_Forename']"));

        WebElement middlenameStaffEditor = driver.findElement(
                By.xpath("//input[@id='cphContent_cphContent_frmEdit_Middlename']"));

        WebElement lastnameStaffEditor = driver.findElement(
                By.xpath("//input[@id='cphContent_cphContent_frmEdit_Surname']"));

        WebElement payrollStaffEditor = driver.findElement(
                By.xpath("//input[@id='cphContent_cphContent_frmEdit_Payroll']"));

        WebElement startDateStaffEditor = driver.findElement(
                By.cssSelector("#ctl00_ctl00_cphContent_cphContent_frmEdit_StartDate_popupButton"));

        WebElement genderStaffEditor = driver.findElement(
                By.cssSelector("#ctl00_ctl00_cphContent_cphContent_frmEdit_GenderDescription_cb_GenderDescription_Arrow"));

        WebElement dobStaffEditor = driver.findElement(
                By.cssSelector("#ctl00_ctl00_cphContent_cphContent_frmEdit_DateOfBirth_dateInput"));

        WebElement terminationDate = driver.findElement(
                By.cssSelector("#ctl00_ctl00_cphContent_cphContent_frmEdit_dpTerminationDate_popupButton"));

        WebElement timezoneStaffEditor = driver.findElement((
                By.cssSelector("#ctl00_ctl00_cphContent_cphContent_frmEdit_TimezoneDescription_cb_TimezoneDescription_Arrow")));

        //untick checkbox rosterable
        WebElement rosterableStaffEditor = driver.findElement(
                By.id("cphContent_cphContent_frmEdit_Rosterable"));

        WebElement saveButtonStaffEditor = driver.findElement(
                By.id("ctl00_ctl00_cphContent_cphContent_frmEdit_btnSave_btn_btnSave"));


        //fill username staff editor form -TEST SIDE
        String usernameRandom1 = RandomStringUtils.randomAlphabetic(10);
        usernameStaffEditor.sendKeys(usernameRandom1 + "@time2work");

        //password reverse from username
        passwordStaffEditor.clear();
        //passwordStaffEditor.sendKeys(usernameRandom1);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        StringBuffer sb = new StringBuffer(usernameRandom1);
        sb.reverse();
        passwordStaffEditor.sendKeys(String.valueOf(sb));

        //fill "Title" from dropdown, click on "title
        clickDropdownTitle.click();
        //hovering to Ms.
        Actions actions = new Actions(driver);
        //retrieve web element Ms. to perform mouse hover
        WebElement msOption = driver.findElement(By.xpath(".//li[contains(text(),'Ms.')]"));
        //mouse hove option Ms. and click Ms.
        actions.moveToElement(msOption).perform();
        msOption.click();

        //5first char of username
        String firstFiveUsernameRandom1 = "";

        if(usernameRandom1.length() > 5){
            firstFiveUsernameRandom1 = usernameRandom1.substring(0, 5);
        } else {
            firstFiveUsernameRandom1 = usernameRandom1;
        }
        firstnameStaffEditor.sendKeys(firstFiveUsernameRandom1);

        knownAsStaffEditor.sendKeys(RandomStringUtils.randomAlphabetic(5));
        middlenameStaffEditor.sendKeys(RandomStringUtils.randomAlphabetic(5));

        //5last char of username
        String lastFiveUsernameRandom1 = "";
        if(usernameRandom1.length()>5){
            lastFiveUsernameRandom1 = usernameRandom1.substring(usernameRandom1.length() - 5);
        } else {
            lastFiveUsernameRandom1 = usernameRandom1;
        }
        lastnameStaffEditor.sendKeys(lastFiveUsernameRandom1);

        //payroll, select chars from 3rd to 7th
        String third = String.valueOf(usernameRandom1.charAt(2));
        String four = String.valueOf(usernameRandom1.charAt(3));
        String five = String.valueOf(usernameRandom1.charAt(4));
        String six = String.valueOf(usernameRandom1.charAt(5));
        String seven = String.valueOf(usernameRandom1.charAt(6));
        payrollStaffEditor.sendKeys(third+four+five+six+seven);

        //date picker start dateDD/MM/YYY Format, Add 7 Days from today’s
        //fill "Start date" from dropdown, click on "calendar" icom
        startDateStaffEditor.click();
        startDateStaffEditor.sendKeys("26/01/2022");

        dobStaffEditor.click();
        dobStaffEditor.sendKeys("01/01/2000");

        terminationDate.click();
        terminationDate.sendKeys("01/01/2025");

        //fill gender from dropdown- female
        //fill "Female" from dropdown, click on "title
        genderStaffEditor.click();
        //hovering to Ms.
        Actions actionsGender = new Actions(driver);
        //retrieve web element Ms. to perform mouse hover
        WebElement femaleOption = driver.findElement(By.xpath(".//li[contains(text(),'Female')]"));
        //mouse hove option Ms. and click Ms.
        actions.moveToElement(femaleOption).perform();
        femaleOption.click();

        //fill timezone from
        timezoneStaffEditor.click();
        Actions actionAus = new Actions(driver);
        WebElement ausOption = driver.findElement(By.xpath(".//li[contains(text(),'AEST (AUS Eastern Standard Time')]"));
        actionAus.moveToElement(ausOption).perform();
        ausOption.click();

        rosterableStaffEditor.click();

        //click save button
        saveButtonStaffEditor.click();
    }
}

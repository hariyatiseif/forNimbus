package staffManagement;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class locationStaffProfileTests {

    @Test
    public void editProfileTest() throws InterruptedException {
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

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement staffManagementNavMenu = driver.findElement(By.xpath("//span[normalize-space()='Staff Management']"));
        new Actions(driver).moveToElement(staffManagementNavMenu).perform();

        WebElement selectStaffManagementFromNavMenu = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Staff Management']")));
        new Actions(driver).moveToElement(selectStaffManagementFromNavMenu).perform();

        selectStaffManagementFromNavMenu.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //===================================================//

        //identify elements username1
        WebElement selectUser1 = driver.findElement(By
                .xpath("//td[normalize-space()='jEqbVFeREa@time2work']"));

        selectUser1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //navigate to location
        Actions actionLoc1 = new Actions(driver);
        WebDriverWait waitForLoc = new WebDriverWait(driver,30);
        //WebElement loc1Option = waitForLoc.until(ExpectedConditions.elementToBeClickable(By.cssSelector("//div[@class='page-body-container']//li[5]//a[1]")));
        WebElement loc1Option = driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]"));
        Thread.sleep(10000);
        actionLoc1.moveToElement(driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")).click();


        //add new record on location
        WebElement addNewRecordOnLocation = driver.findElement(By
                .cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                        "span[class='rbText rbPrimary']"));

        addNewRecordOnLocation.click();

        //Test side
        //Drop down calendar "from"
        Actions actionsCalendarFrom = new Actions(driver);
        actionsCalendarFrom.moveToElement(driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput")));
        actionsCalendarFrom.click();
        actionsCalendarFrom.build().perform();

        WebElement calendarFromField = driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        calendarFromField.clear();
        calendarFromField.sendKeys("26/01/2022");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        calendarFromField.sendKeys(Keys.TAB);

        //drop down location
        WebElement locationOnProfile = driver.findElement(By
                .cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow"));

        locationOnProfile.click();

        Actions actionLoc = new Actions(driver);
        WebElement locOption = driver.findElement(By.xpath(".//li[contains(text(),'Test Location')]"));
        actionLoc.moveToElement(locOption).perform();
        locOption.click();

        //click save on profile
        WebElement saveOnProfile = driver.findElement(By
                .id("ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_PerformInsertButton"));
        saveOnProfile.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //===click STAFF for user 2===//
        //click STAFF from Nav menu
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Actions actionUser2 = new Actions(driver);
        WebDriverWait waitForUser2 = new WebDriverWait(driver,30);
        Thread.sleep(10000);
        actionUser2.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Staff']")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[normalize-space()='Staff']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //staffMenuNav.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //select staff mgmt from nav menu
        driver.findElement(By.xpath("//span[normalize-space()='Staff Management']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //====USER-2===//
        WebElement selectUser2 = driver.findElement(By.xpath("//td[normalize-space()='VtwWPFSbzc@time2work']"));
        selectUser2.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navigate to location
        Actions actionLoc2 = new Actions(driver);
        WebDriverWait waitForLoc2 = new WebDriverWait(driver,30);
        WebElement loc2Option = driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]"));
        Thread.sleep(10000);
        actionLoc2.moveToElement(driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")).click();

        //add new record on location - 2
        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                        "span[class='rbText rbPrimary']"));

        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Drop down calendar "from" - 2
        Actions actionsCalendarFrom2 = new Actions(driver);
        actionsCalendarFrom2.moveToElement(driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput")));
        actionsCalendarFrom2.click();
        actionsCalendarFrom2.build().perform();

        WebElement calendarFromField2 = driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        calendarFromField2.clear();
        calendarFromField2.sendKeys("26/01/2022");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        calendarFromField2.sendKeys(Keys.TAB);

        //drop down location Test 2
        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow"));

        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow")).click();

        actionLoc2 = new Actions(driver);
        WebElement locOption2 = driver.findElement(By.xpath(".//li[contains(text(),'Test Location')]"));
        actionLoc2.moveToElement(locOption2).perform();
        locOption2.click();

        //click save on profile-2
        driver.findElement(By.id("ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_PerformInsertButton")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //===click STAFF for user 3===//
        //click STAFF from Nav menu
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Actions actionUser3 = new Actions(driver);
        WebDriverWait waitForUser3 = new WebDriverWait(driver,30);
        Thread.sleep(10000);
        actionUser3.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Staff']")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[normalize-space()='Staff']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //select staff mgmt from nav menu
        driver.findElement(By.xpath("//span[normalize-space()='Staff Management']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //====USER-3===//
        WebElement selectUser3 = driver.findElement(By.xpath("//td[normalize-space()='IUAwEiShZR@time2work']"));
        selectUser3.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navigate to location
        Actions actionLoc3 = new Actions(driver);
        WebDriverWait waitForLoc3 = new WebDriverWait(driver,30);
        WebElement loc3Option = driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]"));
        Thread.sleep(10000);
        actionLoc3.moveToElement(driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")).click();

        //add new record on location - 3
        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']"));

        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Drop down calendar "from" - 3
        Actions actionsCalendarFrom3 = new Actions(driver);
        actionsCalendarFrom3.moveToElement(driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput")));
        actionsCalendarFrom3.click();
        actionsCalendarFrom3.build().perform();

        WebElement calendarFromField3 = driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        calendarFromField3.clear();
        calendarFromField3.sendKeys("26/01/2022");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        calendarFromField3.sendKeys(Keys.TAB);

        //drop down location Test 3
        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow"));

        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow")).click();

        actionLoc3 = new Actions(driver);
        WebElement locOption3 = driver.findElement(By.xpath(".//li[contains(text(),'Test Location')]"));
        actionLoc3.moveToElement(locOption3).perform();
        locOption3.click();

        //click save on profile-3
        driver.findElement(By.id("ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_PerformInsertButton")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //===click STAFF for user 4===//
        //click STAFF from Nav menu
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Actions actionUser4 = new Actions(driver);
        WebDriverWait waitForUser4 = new WebDriverWait(driver,30);
        Thread.sleep(10000);
        actionUser4.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Staff']")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[normalize-space()='Staff']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //select staff mgmt from nav menu
        driver.findElement(By.xpath("//span[normalize-space()='Staff Management']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //====USER-4===//
        WebElement selectUser4 = driver.findElement(By.xpath("//td[normalize-space()='mDgoZnYxUz@time2work']"));
        selectUser4.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navigate to location
        Actions actionLoc4 = new Actions(driver);
        WebDriverWait waitForLoc4 = new WebDriverWait(driver,30);
        WebElement loc4Option = driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]"));
        Thread.sleep(10000);
        actionLoc4.moveToElement(driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")).click();

        //add new record on location - 4
        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']"));

        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Drop down calendar "from" - 4
        Actions actionsCalendarFrom4 = new Actions(driver);
        actionsCalendarFrom4.moveToElement(driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput")));
        actionsCalendarFrom4.click();
        actionsCalendarFrom4.build().perform();

        WebElement calendarFromField4 = driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        calendarFromField4.clear();
        calendarFromField4.sendKeys("26/01/2022");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        calendarFromField4.sendKeys(Keys.TAB);

        //drop down location Test 4
        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow"));

        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow")).click();

        actionLoc4 = new Actions(driver);
        WebElement locOption4 = driver.findElement(By.xpath(".//li[contains(text(),'Test Location')]"));
        actionLoc4.moveToElement(locOption4).perform();
        locOption4.click();

        //click save on profile-4
        driver.findElement(By.id("ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_PerformInsertButton")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //===click STAFF for user 5===//
        //click STAFF from Nav menu
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Actions actionUser5 = new Actions(driver);
        WebDriverWait waitForUser5 = new WebDriverWait(driver,30);
        Thread.sleep(10000);
        actionUser5.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Staff']")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[normalize-space()='Staff']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //select staff mgmt from nav menu
        driver.findElement(By.xpath("//span[normalize-space()='Staff Management']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //===USER-5===//
        WebElement selectUser5 = driver.findElement(By.xpath("//td[normalize-space()='FWvCXpJDsl@time2work']"));
        selectUser5.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navigate to location
        Actions actionLoc5 = new Actions(driver);
        WebDriverWait waitForLoc5 = new WebDriverWait(driver,30);
        WebElement loc5Option = driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]"));
        Thread.sleep(10000);
        actionLoc5.moveToElement(driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //add new record on location - 5
        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']"));

        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Drop down calendar "from" - 5
        Actions actionsCalendarFrom5 = new Actions(driver);
        actionsCalendarFrom5.moveToElement(driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput")));
        actionsCalendarFrom5.click();
        actionsCalendarFrom5.build().perform();

        WebElement calendarFromField5 = driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        calendarFromField5.clear();
        calendarFromField5.sendKeys("26/01/2022");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        calendarFromField5.sendKeys(Keys.TAB);

        //drop down location Test 5
        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow"));

        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow")).click();

        actionLoc5 = new Actions(driver);
        WebElement locOption5 = driver.findElement(By.xpath(".//li[contains(text(),'Test Location')]"));
        actionLoc5.moveToElement(locOption5).perform();
        locOption5.click();

        //click save on profile-5
        driver.findElement(By.id("ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_PerformInsertButton")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //===click STAFF for user 6===//
        //click STAFF from Nav menu
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Actions actionUser6 = new Actions(driver);
        WebDriverWait waitForUser6 = new WebDriverWait(driver,30);
        Thread.sleep(10000);
        actionUser6.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Staff']")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[normalize-space()='Staff']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //select staff mgmt from nav menu
        driver.findElement(By.xpath("//span[normalize-space()='Staff Management']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //===USER-6===//
        WebElement selectUser6 = driver.findElement(By.xpath("//td[normalize-space()='SmyfiQKvYI@time2work']"));
        selectUser6.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navigate to location
        Actions actionLoc6 = new Actions(driver);
        WebDriverWait waitForLoc6 = new WebDriverWait(driver,30);
        WebElement loc6Option = driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]"));
        Thread.sleep(10000);
        actionLoc6.moveToElement(driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //add new record on location - 6
        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']"));

        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Drop down calendar "from" - 6
        Actions actionsCalendarFrom6 = new Actions(driver);
        actionsCalendarFrom6.moveToElement(driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput")));
        actionsCalendarFrom6.click();
        actionsCalendarFrom6.build().perform();

        WebElement calendarFromField6 = driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        calendarFromField6.clear();
        calendarFromField6.sendKeys("26/01/2022");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        calendarFromField6.sendKeys(Keys.TAB);

        //drop down location Test 6
        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow"));

        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow")).click();

        actionLoc6 = new Actions(driver);
        WebElement locOption6 = driver.findElement(By.xpath(".//li[contains(text(),'Test Location')]"));
        actionLoc6.moveToElement(locOption6).perform();
        locOption6.click();

        //click save on profile-6
        driver.findElement(By.id("ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_PerformInsertButton")).click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        //===click STAFF for user 7===//
        //click STAFF from Nav menu
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Actions actionUser7 = new Actions(driver);
        WebDriverWait waitForUser7 = new WebDriverWait(driver,30);
        Thread.sleep(10000);
        actionUser7.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Staff']")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[normalize-space()='Staff']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //select staff mgmt from nav menu
        driver.findElement(By.xpath("//span[normalize-space()='Staff Management']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //===USER-7===//
        WebElement selectUser7 = driver.findElement(By.xpath("//td[normalize-space()='NlnXauggpz@time2work']"));
        selectUser7.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navigate to location
        Actions actionLoc7 = new Actions(driver);
        WebDriverWait waitForLoc7 = new WebDriverWait(driver,30);
        WebElement loc7Option = driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]"));
        Thread.sleep(10000);
        actionLoc7.moveToElement(driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //add new record on location - 7
        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']"));

        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Drop down calendar "from" - 7
        Actions actionsCalendarFrom7 = new Actions(driver);
        actionsCalendarFrom7.moveToElement(driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput")));
        actionsCalendarFrom7.click();
        actionsCalendarFrom7.build().perform();

        WebElement calendarFromField7 = driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        calendarFromField7.clear();
        calendarFromField7.sendKeys("26/01/2022");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        calendarFromField7.sendKeys(Keys.TAB);

        //drop down location Test 7
        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow"));

        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow")).click();

        actionLoc7 = new Actions(driver);
        WebElement locOption7 = driver.findElement(By.xpath(".//li[contains(text(),'Test Location')]"));
        actionLoc7.moveToElement(locOption7).perform();
        locOption7.click();

        //click save on profile-7
        driver.findElement(By.id("ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_PerformInsertButton")).click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll page to end
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        //===click STAFF for user 8===//
        //click STAFF from Nav menu
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Actions actionUser8 = new Actions(driver);
        WebDriverWait waitForUser8 = new WebDriverWait(driver,30);
        Thread.sleep(10000);
        actionUser8.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Staff']")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[normalize-space()='Staff']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //select staff mgmt from nav menu
        driver.findElement(By.xpath("//span[normalize-space()='Staff Management']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //==USER-8===//
        WebElement selectUser8 = driver.findElement(By.xpath("//td[normalize-space()='PkpVYUkVfI@time2work']"));
        selectUser8.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navigate to location
        Actions actionLoc8 = new Actions(driver);
        WebDriverWait waitForLoc8 = new WebDriverWait(driver,30);
        WebElement loc8Option = driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]"));
        Thread.sleep(10000);
        actionLoc8.moveToElement(driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //add new record on location - 8
        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']"));

        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Drop down calendar "from" - 8
        Actions actionsCalendarFrom8 = new Actions(driver);
        actionsCalendarFrom8.moveToElement(driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput")));
        actionsCalendarFrom8.click();
        actionsCalendarFrom8.build().perform();

        WebElement calendarFromField8 = driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        calendarFromField8.clear();
        calendarFromField8.sendKeys("26/01/2022");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        calendarFromField8.sendKeys(Keys.TAB);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //drop down location Test 8
        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow"));

        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow")).click();

        actionLoc8 = new Actions(driver);
        WebElement locOption8 = driver.findElement(By.xpath(".//li[contains(text(),'Test Location')]"));
        actionLoc8.moveToElement(locOption8).perform();
        locOption8.click();

        //click save on profile-8
        driver.findElement(By.id("ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_PerformInsertButton")).click();

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);


        //===click STAFF for user 9===//
        //click STAFF from Nav menu
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Actions actionUser9 = new Actions(driver);
        WebDriverWait waitForUser9 = new WebDriverWait(driver,30);
        Thread.sleep(10000);
        actionUser9.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Staff']")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[normalize-space()='Staff']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //select staff mgmt from nav menu
        driver.findElement(By.xpath("//span[normalize-space()='Staff Management']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //===USER-9===//
        WebElement selectUser9 = driver.findElement(By.xpath("//td[normalize-space()='PiekQUVayw@time2work']"));
        selectUser9.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navigate to location
        Actions actionLoc9 = new Actions(driver);
        WebDriverWait waitForLoc9 = new WebDriverWait(driver,30);
        WebElement loc9Option = driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]"));
        Thread.sleep(10000);
        actionLoc9.moveToElement(driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //add new record on location - 9
        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']"));

        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Drop down calendar "from" - 9
        Actions actionsCalendarFrom9 = new Actions(driver);
        actionsCalendarFrom9.moveToElement(driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput")));
        actionsCalendarFrom9.click();
        actionsCalendarFrom9.build().perform();

        WebElement calendarFromField9 = driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        calendarFromField9.clear();
        calendarFromField9.sendKeys("26/01/2022");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        calendarFromField9.sendKeys(Keys.TAB);

        //drop down location Test 9
        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow"));

        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow")).click();

        actionLoc9 = new Actions(driver);
        WebElement locOption9 = driver.findElement(By.xpath(".//li[contains(text(),'Test Location')]"));
        actionLoc9.moveToElement(locOption9).perform();
        locOption9.click();

        //click save on profile-9
        driver.findElement(By.id("ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_PerformInsertButton")).click();

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);


        //===click STAFF for user 10===//
        //click STAFF from Nav menu
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Actions actionUser10 = new Actions(driver);
        WebDriverWait waitForUser10 = new WebDriverWait(driver,30);
        Thread.sleep(10000);
        actionUser10.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Staff']")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[normalize-space()='Staff']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //select staff mgmt from nav menu
        driver.findElement(By.xpath("//span[normalize-space()='Staff Management']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //===USER-10===//
        WebElement selectUser10 = driver.findElement(By.xpath("//td[normalize-space()='UcAJVWpCWp@time2work']"));
        selectUser10.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navigate to location
        Actions actionLoc10 = new Actions(driver);
        WebDriverWait waitForLoc10 = new WebDriverWait(driver,30);
        WebElement loc10Option = driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]"));
        Thread.sleep(10000);
        actionLoc10.moveToElement(driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class='page-body-container']//li[5]//a[1]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //add new record on location - 10
        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']"));

        driver.findElement(By.cssSelector("span[id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl00_hdrAddHist_InitInsertButton'] " +
                "span[class='rbText rbPrimary']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Drop down calendar "from" - 10
        Actions actionsCalendarFrom10 = new Actions(driver);
        actionsCalendarFrom10.moveToElement(driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput")));
        actionsCalendarFrom10.click();
        actionsCalendarFrom10.build().perform();

        WebElement calendarFromField10 = driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        calendarFromField10.clear();
        calendarFromField10.sendKeys("26/01/2022");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        calendarFromField10.sendKeys(Keys.TAB);

        //drop down location Test 10
        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow"));

        driver.findElement(By.cssSelector("#ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow")).click();

        actionLoc10 = new Actions(driver);
        WebElement locOption10 = driver.findElement(By.xpath(".//li[contains(text(),'Test Location')]"));
        actionLoc10.moveToElement(locOption10).perform();
        locOption10.click();

        //click save on profile-10
        driver.findElement(By.id("ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_PerformInsertButton")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
}

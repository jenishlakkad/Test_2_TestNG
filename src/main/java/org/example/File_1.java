package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.time.Duration;

public class File_1 {
    protected static WebDriver driver;
    public String getTimeStamp(){
        //Method for time stamp for ddhhmmss
        return new SimpleDateFormat("ddHHmmss").format(new java.util.Date());
    }
    public String getText(By by){
        //Method "getText" to get text from website. By passing one parameter 'by'
        String regMsg=driver.findElement(by).getText();
         System.out.println(regMsg);
         // To print message
        return regMsg;
        //return method
    }
    public void clickFunction(By by)
    {
        //Method to click on button,image,text,field, etc. By passing one parameter 'by'
        driver.findElement(by).click();
    }

    public void sendText(By by,String name){
        //Method "sendText" to write any text on website, by passing two parameter 'By' and 'String'
        driver.findElement(by).sendKeys(name);
    }

    @BeforeMethod
    public void openBrowser(){
        //BeforeMethod to run code before executing every Test cases
        System.setProperty("webdriver.chrome.driver","src/test/java/Driver/chromedriver.exe");
        driver=new ChromeDriver();    //Obj of Chrome Driver

        driver.manage().window().maximize();  //Command for maximizing Screen
        driver.get("https://demo.nopcommerce.com/");   // Giving command to drive to go to given URL
    }
    @Test public void homePage(){
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());  //Storing Obj(of Date Formate) in Variable(String)
        System.out.println(timeStamp);   //Print out timeStamp
        clickFunction(By.className("ico-register"));
          // Method to click on button
        clickFunction(By.name("Gender"));
        // Method to click on radio button

        sendText(By.id("FirstName"),"jenish");
        // Method to write "my name"
        sendText(By.id("LastName"),"Lakkad");
          // Method to write "my last name"
        Select select=new Select(driver.findElement(By.name("DateOfBirthDay")));
        select.selectByVisibleText("6");
        Select select2=new Select(driver.findElement(By.name("DateOfBirthMonth")));
        select2.selectByVisibleText("June");
        Select select3=new Select(driver.findElement(By.name("DateOfBirthYear")));
        select3.selectByVisibleText("1977");
        sendText(By.id("Email"),"jenish"+timeStamp+"@gmail.com");
        // Method to write "email ID"
        sendText(By.id("Company"),"Lakkad & Son's");
        // Method to write "Company name"
        sendText(By.id("Password"),"Jenish123");
        // Method to write "password"
        sendText(By.id("ConfirmPassword"),"Jenish123");
         // Method to write "confirm password"
        clickFunction(By.id("register-button"));
         //Method to click on "Register button" button

        getText(By.className("result"));//Method to get text from website
    }


    @Test void Email_A_Friend(){
        clickFunction(By.xpath("//img[@src=\"https://demo.nopcommerce.com/images/thumbs/0000024_apple-macbook-pro-13-inch_415.jpeg\"]"));
        //Method to redirect page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Obj to call an inbuild class(JavascriptExecutor) :- for hovering mouse

        js.executeScript("window.scrollBy(0,370)", "");

        clickFunction(By.xpath("//button[@class='button-2 email-a-friend-button']"));
          //Method to Click on 'email a friend ' button

        sendText(By.id("FriendEmail"),"black@gmail.com");
         //Method to write text in 'friendEmail' area

        sendText(By.id("YourEmailAddress"),"white@gmail.com");
       //Method to write text in 'your Email Address area

        sendText(By.id("PersonalMessage"),"Hello Everyone");
         //Method to write text in personal message area

        clickFunction(By.xpath("//div[@class=\"buttons\"]/button[@type=\"submit\"]"));
        //Method to Click on 'submit' button

        getText(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul[1]/li[1]"));
        //Method to getText form website
    }
    @Test void Home_page_Categories(){
        getText(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]/a[@href=\"/computers\"]"));
        //Method to get text from website

        getText(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a[@href=\"/electronics\"]"));
        //Method to get text from website

        getText(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[3]/a[@href=\"/apparel\"]"));
        //Method to get text from website

        getText(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[4]/a[@href=\"/digital-downloads\"]"));
        //Method to get text from website


        getText(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[5]/a[@href=\"/books\"]"));
        //Method to get text from website

        getText(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[6]/a[@href=\"/jewelry\"]"));
        //Method to get text from website

        getText(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[7]/a[@href=\"/gift-cards\"]"));
        //Method to get text from website

    }

    @Test  void  News_comment(){
        getTimeStamp();
        //Method to get time Stamp
        JavascriptExecutor js = (JavascriptExecutor) driver;   //Obj to call an inbuild class(JavascriptExecutor) :- for hovering mouse
        js.executeScript("window.scrollBy(0,1570)", "");  //Command to how much scroll down

        clickFunction(By.xpath("//div[@class=\"buttons\"]/a[@href=\"/nopcommerce-new-release\"]"));
        //Method to Click on Details button

        sendText(By.className("enter-comment-title"),"News"+getTimeStamp());
        // Method to write text on 'Title' field and also concatenating timeStamp(variable) to aad Change in text field

        sendText(By.className("enter-comment-text"),"Today is a Beautiful day");
        //Method to write text on 'Comment' field

        clickFunction(By.xpath("//button[@class=\"button-1 news-item-add-comment-button\"]"));
        //Method to click on 'New Comment'(button)

        getText(By.className("result"));
        //Method to store text and Command to get text from website to here

    }

    @Test void Product(){

        Actions action=new Actions(driver);     //obj to hover mouse
        WebElement element=driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]/a[@href=\"/computers\"]"));   //Command to hover mouse on required element
        action.moveToElement(element).build().perform();  //Command to make actions
//      WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));   //Obj to set duration
//      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]/ul[@class=\"sublist first-level\"]/li[1]/a[@href=\"/desktops\"]")));
        //Command to wait 5 sec( if network is slow or low
        WebElement element1=driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]/ul[@class=\"sublist first-level\"]/li[1]/a[@href=\"/desktops\"]"));
        action.moveToElement(element1);
        action.click().build().perform();

        getText(By.xpath("//h2[@class=\"product-title\"]/a[@href=\"/build-your-own-computer\"]"));
        //making variable to store text and Command to get text from website to here

        getText(By.xpath( "//h2[@class=\"product-title\"]/a[@href=\"/digital-storm-vanquish-3-custom-performance-pc\"]"));
        //making variable to store text and Command to get text from website to here

        getText(By.xpath(  "//h2[@class=\"product-title\"]/a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\"]"));
        //making variable to store text and Command to get text from website to here
    }

    @AfterMethod
    //AfterMethod to run code after executing every Test cases

    public void closeBrowser(){

        driver.close();
    }
}

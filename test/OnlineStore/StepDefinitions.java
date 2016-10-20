/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineStore;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author AsphaltPanthers
 */
public class StepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private final String HOME_PAGE = "http://store.demoqa.com/";
    
    //Begin to Define Shpping Cart Feature
    @Given("that I am on iPhone 5 product page")
    public void openiPhonePage() {
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        //System.setProperty("webdriver.gecko.driver", "libs\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
        driver.get("http://store.demoqa.com/products-page/product-category/n/");
    }
    
    @When("I add an iPhone 5 and click check out")
    public void addiPhone() {
        WebElement buy = driver.findElement(By.name("Buy"));
        buy.submit();
        wait = new WebDriverWait(driver, 15);
        WebElement goToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Go to Checkout")));
        goToCart.click();
    }
       
    @Then("the iPhone 5 is added to the shopping cart")
    public void checkShoppingCart() {
        wait = new WebDriverWait(driver, 15);
        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.slide1")));
        String str = cart.getText();
        assertTrue(str.contains("iPhone 5"));  
    }
    
    @When("I add an iPhone 5 and continue shopping")
    public void continueShopping() {
        WebElement buy = driver.findElement(By.name("Buy"));
        buy.submit();
        wait = new WebDriverWait(driver, 15);
        WebElement continueShopping = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Continue Shopping")));
        continueShopping.click();
    }
    
    @Then("I will stay in current page and iPhone 5 is added to the shopping cart")
    public void afterContinueShopping() {
        WebElement title = driver.findElement(By.cssSelector("h1.prodtitle"));
        assertEquals("iPhone 5",title.getText());
        wait = new WebDriverWait(driver, 15);
        driver.get("http://store.demoqa.com/products-page/checkout/");
        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.slide1")));
        String str = cart.getText();
        assertTrue(str.contains("iPhone 5"));  
    }
    
    @Given("a shopping cart with only one Magic Mouse")
    public void shoppingCart() {
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 15);
        driver.get("http://store.demoqa.com/products-page/product-category/accessories/magic-mouse/");
        WebElement buy = driver.findElement(By.name("Buy"));
        buy.submit();
        WebElement goToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Go to Checkout")));
        goToCart.click();
    }
    
    @When("I remove a Magic Mouse")
    public void removeItem() {
        wait = new WebDriverWait(driver, 15);
        WebElement remove = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form.adjustform.remove > input[name=\"submit\"]")));
        remove.click();
    }
    
    @Then("the Magic Mouse should not appear in shopping cart")
    public void checkRemovingItem() {      
        wait = new WebDriverWait(driver, 15);
        if(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("form.adjustform.remove > input[name=\"submit\"]")))) {
            WebElement cart = driver.findElement(By.cssSelector("div.entry-content"));
            String str = cart.getText();
            assertFalse(str.contains("Magic Mouse"));  
        }       
    }
    
    @Given("a shopping cart with an iPhone 5")
    public void shoppingCartwithItem() {
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 15);
        driver.get("http://store.demoqa.com/products-page/product-category/n/");
        WebElement buy = driver.findElement(By.name("Buy"));
        buy.submit();
        WebElement goToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Go to Checkout")));
        goToCart.click();
    }
    
    @When("I increase the quantity of iphone 5 from 1 to 2")
    public void increaseQuantity() {
        wait = new WebDriverWait(driver, 15);
        WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("quantity")));
        quantity.clear();
        quantity.sendKeys("2");
        WebElement update = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));
        update.click();
    }
    
    @Then("iPhone 5 quantity and total should be updated")
    public void afterUpdate() throws InterruptedException {
        Thread.sleep(5000);
        WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("quantity")));
        assertEquals("2",quantity.getAttribute("value"));
        WebElement total = driver.findElement(By.cssSelector("td.wpsc_product_price.wpsc_product_price_0"));
        assertEquals("$24.00",total.getText());
    }
    
    //Begin to Define Log In Feature        
    @Given("log in page of the e-commerce website")
    public void openLoginPage() {
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
        driver.get("http://store.demoqa.com/products-page/your-account/");
    }
    @When("I log in with correct username and password")
    public void logInSuccess() {
        WebElement username = driver.findElement(By.id("log"));       
        WebElement password = driver.findElement(By.id("pwd"));
        username.sendKeys("huz25");
        password.sendKeys("MuFtUnwUkBDE6eDk");
        WebElement login = driver.findElement(By.id("login"));
        login.click();
    }
    @Then("I should see log out button")
    public void purchaseHistoryLink() {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("(Logout)")));
        driver.findElement(By.linkText("(Logout)"));
    }
   
    @When("I log in with correct username and incorrect password")
    public void logInNotSuccess() {
        WebElement username = driver.findElement(By.id("log"));       
        WebElement password = driver.findElement(By.id("pwd"));
        username.sendKeys("huz25");
        password.sendKeys("wrong");
        WebElement login = driver.findElement(By.id("login"));
        login.submit();
    }
    @Then("an error message should appear")
    public void checkErrorMessage() {
        wait = new WebDriverWait(driver, 15);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.response")));
        assertEquals("ERROR: Invalid login credentials.", message.getText());
    }   
    
    @When("I log in without username and password")
    public void logInEmpty() {
        WebElement username = driver.findElement(By.id("log"));       
        WebElement password = driver.findElement(By.id("pwd"));
        username.clear();
        password.clear();
        WebElement login = driver.findElement(By.id("login"));
        login.submit();
    }
    @Then("a notice message should appear")
    public void checkNotice() {
        wait = new WebDriverWait(driver, 15);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.response")));
        assertEquals("Please enter your username and password.", message.getText());
    }
    
    //Begin to Define Search Feature
    @Given("home page of the e-commerce website")
    public void openHomePage() {
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        //System.setProperty("webdriver.gecko.driver", "libs\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
        driver.get(HOME_PAGE);
    }
    @When("I search magic mouse")
    public void searchMagicMouse() {
        WebElement searchbox = driver.findElement(By.name("s"));
        searchbox.clear();
        searchbox.sendKeys("magic mouse");
        searchbox.sendKeys(Keys.RETURN);
    }
    @Then("I should see the product listed in the result")
    public void checkResult() {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.prodtitle")));
        WebElement result = driver.findElement(By.cssSelector("div.product_grid_display.group"));
        assertTrue(result.getText().contains("Magic Mouse"));
    }
    @When("I search iphone7")
    public void searchiPhone7() {
        WebElement searchbox = driver.findElement(By.name("s"));
        searchbox.clear();
        searchbox.sendKeys("iphone7");
        searchbox.sendKeys(Keys.RETURN);
    }
    @Then("I should see the notice of nothing matched")
    public void searchMessage() throws InterruptedException {
        wait = new WebDriverWait(driver, 15);
        Thread.sleep(5000);
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
        assertEquals("Sorry, but nothing matched your search criteria. Please try again with some different keywords.",result.getText());      
    }
    @When("I search with empty search box")
    public void searchNothing() {
        WebElement searchbox = driver.findElement(By.name("s"));
        searchbox.clear();
        searchbox.sendKeys(Keys.RETURN);
    }
    @Then("I should still see some products displaying in the result")
    public void displayResult() {
        wait = new WebDriverWait(driver, 15);
        //Only when there is product return, css=div.product_grid_display.group will appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product_grid_display.group")));
        driver.findElement(By.cssSelector("h2.prodtitle"));      
    }
    
        
    @After
    public void cleanUp() {
        wait = new WebDriverWait(driver, 200);
        driver.quit();
    }
    
}

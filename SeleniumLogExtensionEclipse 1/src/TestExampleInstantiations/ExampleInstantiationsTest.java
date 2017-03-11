
package TestExampleInstantiations;

import SeleniumLogger.SeleniumLog;
import SeleniumLogger.SeleniumLogEventListener;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class TestClass
{
    public void Message(String msg)
    {
        try
        {
            SeleniumLog log = SeleniumLog.Instance();
            log.Info(String.format("TestClass :: Message :: %s", msg));
        }
        catch (Exception e)
        {
            SeleniumLog log = SeleniumLog.Instance();
            log.Error().Info(String.format("TestClass :: Exception :: %s", e.getMessage()));
        }
    }
    public TestClass() { }
}

public class ExampleInstantiationsTest {
    
    static void TestIndents()
    {
        SeleniumLog log = SeleniumLog.Instance();
        log.Info("line 1");
        log.Info("line 2");
        log.Indent().Indent().Info("line 3");
        log.SaveIndent("ID1");
        log.Info("line 4");
        log.Indent().Indent().Indent().Indent().Indent().Info("line 5");
        log.Unindent().Unindent().Info("line 6");
        log.Info("line 7");
        log.Info("line 8");
        log.Info("line 9");
        log.Info("line 10");
        log.Info("line 11");
        log.Info("line 12");
        log.Info("line 13");
        log.Info("line 14");
        log.Info("line 15");
        log.Info("line 16");
        log.Info("line 17");
        log.Info("line 18");
        log.Info("line 19");
        log.RestoreIndent("ID1");
        log.Info("line 20");
        log.Info("line 21");
        log.Info("line 22");
        log.Info("line 23");
        log.Info("line 24");
        log.Info("line 25");
        log.Info("line 26");
        log.Info("line 27");
        log.Info("line 28");
        log.Info("line 29");
        log.Info("line 30");
    }
    
    static void TestIndents2() {
    	SeleniumLog log = SeleniumLog.Instance();
        int L = 0;

        log.Info("line 1");
        log.Info("line 2");
        log.Info("line 3");
        log.Info("line 4");
        log.Info("line 5");
        log.Indent();
        log.Indent();
        log.Info("line 6");
        log.Info("line 7");
        log.Info("line 8");
        log.Info("line 9");
        log.Info("line 10");
        log.Info("line 11");
        log.Info("line 12");
        log.Info("line 13");
        log.Info("line 14");
        log.Info("line 15");
        log.Indent();
        log.Info("line 16");
        log.Info("line 17");
        log.Info("line 18");
        log.Info("line 19");
        log.Info("line 20");
        log.Info("line 21");
        log.Info("line 22");
        log.Info("line 23");
        log.Info("line 24");
        log.Pass().Info("line 25");
        log.Info("line 26");
        log.Info("line 27");
        log.Info("line 28");
        log.SaveIndent("id"); //
        log.Indent();
        log.Info("line 29");
        log.Warning().Info("line 30");
        log.Info("line 31");
        log.Info("line 32");
        log.Info("line 33");
        log.Info("line 34");
        log.Info("line 35");
        log.Info("line 36");
        log.Unindent().Unindent();
        log.Info("line 37");
        log.Info("line 38");
        log.Indent().Info("line 39");
        log.Info("line 40");
        log.Indent().Info("line 41");
        log.Info("line 42");
        log.Info("line 43");
        log.Indent().Info("line 44");
        log.Indent().Info("line 45");
        log.Info("line 46");
        log.Fail().Info("line 47");
        log.Indent();
        log.Info("line 48");
        log.Info("line 49");
        log.Info("line 50");
        log.Info("line 51");
        log.Error().Info("line 52");
        log.Info("line 53");
        log.Info("line 54");
        log.Info("line 55");
        log.Info("line 56");
        log.Info("line 57");
        log.Info("line 58");
        log.Info("line 59");
        log.Info("line 60");
        log.Info("line 61");
        log.Unindent().Unindent().Unindent();
        log.Info("line 62");
        log.Info("line 63");
        log.Info("line 64");
        log.Info("line 65");
        log.Info("line 66");
        log.Info("line 67");
        log.Info("line 68");
        log.Info("line 69");
        log.Info("line 70");
        log.RestoreIndent("id");  //
        log.Info("line 71");
        log.Info("line 72");
        log.Info("line 73");
        log.Info("line 74");
        log.Info("line 75");
        log.Info("line 76");
        log.Info("line 77");
        log.Info("line 78");
        log.Info("line 79");
        log.Info("line 80");
        log.Info("line 81");
        log.Info("line 82");
        log.Info("line 83");
        log.Info("line 84");
        log.Info("line 85");
        log.Info("line 86");
        log.Info("line 87");
        log.Info("line 88");
        log.Info("line 89");
        log.Info("line 90");
        log.Info("line 91");
        log.Info("line 92");
        log.Info("line 93");
        log.Info("line 94");
        log.Info("line 95");
        log.Info("line 96");
        log.Info("line 97");
        log.Info("line 98");
        log.Info("line 99");
        log.Info("line 100");
    }
    
    static void TestColors() {
    	SeleniumLog log = SeleniumLog.Instance();
    	log.Blue().Info("Blue");
    	log.BlueGreen("BlueGrn");
    	log.Orange("Orange");
    	log.Red().Info("Red");    	
    }
    
    static void TestSeleniumWebdriverIntegration() {
        FirefoxDriver driver0 = new FirefoxDriver();
        SeleniumLogEventListener driver = new SeleniumLogEventListener(driver0);        
        
        // This works
        driver0.get("http://google.com/");

        // Test PASS - This also works fine. So SeleniumLogEvenListener() is probably returning a proper Selenium object.
        // Test FAIL - However, if you leave it running for about a minute, exceptions are thrown. Need to fix this.
        driver.get("http://upwork.com/");
        
        // Test FAIL - This somehow causes some exceptions when I pass in driver or driver0 object to Instance().
        SeleniumLog log = SeleniumLog.Instance(driver);
        log.Info("Testing Selenium Webdriver Integration");
        log.Screenshot();
        log.Pass();
    }
    
    static void TestScreenshots() {
    	FirefoxDriver driver0 = new FirefoxDriver();
    	SeleniumLog log = SeleniumLog.Instance();
    	
    	log.Info("Testing Screenshots");
    	driver0.get("http://google.com");
    	//log.Screenshot();
    	log.Info("Screenshot complete");
    	
    }
    
    static void TestSeleniumLogEventListener() {
    	ChromeDriver driver0 = new ChromeDriver();
        SeleniumLogEventListener driver = new SeleniumLogEventListener(driver0); 
    	SeleniumLog log = SeleniumLog.Instance(driver);
    	
        log.Info("Step 1-: Goto Seleniumlog.com website");
        driver.get("http://seleniumlog.com");

        log.Info("Step 2: Goto Downloads page");
        driver.findElement(By.xpath("//li/a[@href='/downloads.html']")).click();
        
        log.Info("Step 3: Goto Contact Us page");
        driver.findElement(By.xpath("//li/a[@href='/contact-us.html']")).click();

        log.Info("Step 4: Enter First Name");
        driver.findElement(By.id("input-780482698489254089")).sendKeys("Harold");

        log.Info("Step 5: Enter Last Name");
        driver.findElement(By.id("input-780482698489254089-1")).sendKeys("Chung");

        log.Info("Step 6: Enter Email address");
        driver.findElement(By.id("input-465062639798639934")).sendKeys("jredimer@yahoo.com.au");

        log.Info("Step 7: Enter Comments");
        driver.findElement(By.id("input-417418761492911507")).sendKeys("JAVA Extension");

        log.Info("Step 8: Click on Submit button");
        driver.findElement(By.xpath("//span[contains(text(),'Submit')]/..")).click();    
    }
    
    static WebDriver _testSingletonA() {
    	ChromeDriver driver0 = new ChromeDriver();
        SeleniumLogEventListener driver = new SeleniumLogEventListener(driver0); 
    	SeleniumLog log = SeleniumLog.Instance(driver);
    	
        log.Info("Step 1-: Goto Seleniumlog.com website");
        driver.get("http://seleniumlog.com");

        log.Info("Step 2: Goto Downloads page");
        driver.findElement(By.xpath("//li/a[@href='/downloads.html']")).click();
        
        log.Info("Step 3: Goto Contact Us page");
        driver.findElement(By.xpath("//li/a[@href='/contact-us.html']")).click();

        log.Info("Step 4: Enter First Name");
        driver.findElement(By.id("input-780482698489254089")).sendKeys("Harold");
        
        return driver;
    }
    
    static void _testSingletonB(WebDriver driver) {
    	//ChromeDriver driver0 = new ChromeDriver();
        //SeleniumLogEventListener driver = new SeleniumLogEventListener(driver0); 
    	SeleniumLog log = SeleniumLog.Instance();
    	
        log.Info("Step 5: > Enter Last Name");
        driver.findElement(By.id("input-780482698489254089-1")).sendKeys("Chung");

        log.Info("Step 6: Enter Email address");
        driver.findElement(By.id("input-465062639798639934")).sendKeys("jredimer@yahoo.com.au");

        log.Info("Step 7: Enter Comments");
        driver.findElement(By.id("input-417418761492911507")).sendKeys("JAVA Extension");

        log.Info("Step 8: Click on Submit button");
        driver.findElement(By.xpath("//span[contains(text(),'Submit')]/..")).click(); 
    }
    
    static void TestSingleton() {
    	WebDriver driver = _testSingletonA();
    	_testSingletonB(driver);
    }
    
    static void TestXPathDiagnostics() {
    	ChromeDriver driver0 = new ChromeDriver();
        SeleniumLogEventListener driver = new SeleniumLogEventListener(driver0); 
    	SeleniumLog log = SeleniumLog.Instance(driver);
    	
        log.Info("Step 1-: Goto Seleniumlog.com website");
        driver.get("http://seleniumlog.com");

        log.Info("Step 2: Goto Downloads page");
        driver.findElement(By.xpath("//li/a[@href='/downloads.html']")).click();
        
        log.Info("Step 3: Goto Contact Us page");
        driver.findElement(By.xpath("//li/a[@href='/contact-us2.html']")).click();

        log.Info("Step 4: Enter First Name");
        driver.findElement(By.id("input-780482698489254089")).sendKeys("Harold");

        log.Info("Step 5: Enter Last Name");
        driver.findElement(By.id("input-780482698489254089-1")).sendKeys("Chung");

        log.Info("Step 6: Enter Email address");
        driver.findElement(By.id("input-465062639798639934")).sendKeys("jredimer@yahoo.com.au");

        log.Info("Step 7: Enter Comments");
        driver.findElement(By.id("input-417418761492911507")).sendKeys("JAVA Extension");

        log.Info("Step 8: Click on Submit button");
        driver.findElement(By.xpath("//span[contains(text(),'Submit')]/..")).click();
    }
    
    public static void main(String[] args) throws ParseException {
    	
    	TestIndents2();
    	//TestColors();
    	//TestSeleniumWebdriverIntegration();
    	//TestScreenshots();
    	//TestSeleniumLogEventListener();
    	//TestSingleton();
    	//TestXPathDiagnostics();
    	
    	/*
        FirefoxDriver driver0 = new FirefoxDriver();
        SeleniumLogEventListener driver = new SeleniumLogEventListener(driver0);
        SeleniumLog log = SeleniumLog.Instance(driver);

        TestClass tobj = new TestClass();

        log.Info("Main");
        Foo();
        tobj.Message("hi there");
        
        driver.get("http://www.google.com");
        driver.navigate().to("http://www.upwork.com");
        driver.navigate().back();
        */
    }
}

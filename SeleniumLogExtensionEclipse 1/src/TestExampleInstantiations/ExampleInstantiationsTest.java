
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
            log.WriteLine(String.format("TestClass :: Message :: %s", msg));
        }
        catch (Exception e)
        {
            SeleniumLog log = SeleniumLog.Instance();
            log.Error().WriteLine(String.format("TestClass :: Exception :: %s", e.getMessage()));
        }
    }
    public TestClass() { }
}

public class ExampleInstantiationsTest {
    
    static void TestIndents()
    {
        SeleniumLog log = SeleniumLog.Instance();
        log.WriteLine("line 1");
        log.WriteLine("line 2");
        log.Indent().Indent().WriteLine("line 3");
        log.SaveIndent("ID1");
        log.WriteLine("line 4");
        log.Indent().Indent().Indent().Indent().Indent().WriteLine("line 5");
        log.Unindent().Unindent().WriteLine("line 6");
        log.WriteLine("line 7");
        log.WriteLine("line 8");
        log.WriteLine("line 9");
        log.WriteLine("line 10");
        log.WriteLine("line 11");
        log.WriteLine("line 12");
        log.WriteLine("line 13");
        log.WriteLine("line 14");
        log.WriteLine("line 15");
        log.WriteLine("line 16");
        log.WriteLine("line 17");
        log.WriteLine("line 18");
        log.WriteLine("line 19");
        log.RestoreIndent("ID1");
        log.WriteLine("line 20");
        log.WriteLine("line 21");
        log.WriteLine("line 22");
        log.WriteLine("line 23");
        log.WriteLine("line 24");
        log.WriteLine("line 25");
        log.WriteLine("line 26");
        log.WriteLine("line 27");
        log.WriteLine("line 28");
        log.WriteLine("line 29");
        log.WriteLine("line 30");
    }
    
    static void TestIndents2() {
    	SeleniumLog log = SeleniumLog.Instance();
        int L = 0;

        log.WriteLine("line 1");
        log.WriteLine("line 2");
        log.WriteLine("line 3");
        log.WriteLine("line 4");
        log.WriteLine("line 5");
        log.Indent();
        log.Indent();
        log.WriteLine("line 6");
        log.WriteLine("line 7");
        log.WriteLine("line 8");
        log.WriteLine("line 9");
        log.WriteLine("line 10");
        log.WriteLine("line 11");
        log.WriteLine("line 12");
        log.WriteLine("line 13");
        log.WriteLine("line 14");
        log.WriteLine("line 15");
        log.Indent();
        log.WriteLine("line 16");
        log.WriteLine("line 17");
        log.WriteLine("line 18");
        log.WriteLine("line 19");
        log.WriteLine("line 20");
        log.WriteLine("line 21");
        log.WriteLine("line 22");
        log.WriteLine("line 23");
        log.WriteLine("line 24");
        log.Pass().WriteLine("line 25");
        log.WriteLine("line 26");
        log.WriteLine("line 27");
        log.WriteLine("line 28");
        log.SaveIndent("id"); //
        log.Indent();
        log.WriteLine("line 29");
        log.Warning().WriteLine("line 30");
        log.WriteLine("line 31");
        log.WriteLine("line 32");
        log.WriteLine("line 33");
        log.WriteLine("line 34");
        log.WriteLine("line 35");
        log.WriteLine("line 36");
        log.Unindent().Unindent();
        log.WriteLine("line 37");
        log.WriteLine("line 38");
        log.Indent().WriteLine("line 39");
        log.WriteLine("line 40");
        log.Indent().WriteLine("line 41");
        log.WriteLine("line 42");
        log.WriteLine("line 43");
        log.Indent().WriteLine("line 44");
        log.Indent().WriteLine("line 45");
        log.WriteLine("line 46");
        log.Fail().WriteLine("line 47");
        log.Indent();
        log.WriteLine("line 48");
        log.WriteLine("line 49");
        log.WriteLine("line 50");
        log.WriteLine("line 51");
        log.Error().WriteLine("line 52");
        log.WriteLine("line 53");
        log.WriteLine("line 54");
        log.WriteLine("line 55");
        log.WriteLine("line 56");
        log.WriteLine("line 57");
        log.WriteLine("line 58");
        log.WriteLine("line 59");
        log.WriteLine("line 60");
        log.WriteLine("line 61");
        log.Unindent().Unindent().Unindent();
        log.WriteLine("line 62");
        log.WriteLine("line 63");
        log.WriteLine("line 64");
        log.WriteLine("line 65");
        log.WriteLine("line 66");
        log.WriteLine("line 67");
        log.WriteLine("line 68");
        log.WriteLine("line 69");
        log.WriteLine("line 70");
        log.RestoreIndent("id");  //
        log.WriteLine("line 71");
        log.WriteLine("line 72");
        log.WriteLine("line 73");
        log.WriteLine("line 74");
        log.WriteLine("line 75");
        log.WriteLine("line 76");
        log.WriteLine("line 77");
        log.WriteLine("line 78");
        log.WriteLine("line 79");
        log.WriteLine("line 80");
        log.WriteLine("line 81");
        log.WriteLine("line 82");
        log.WriteLine("line 83");
        log.WriteLine("line 84");
        log.WriteLine("line 85");
        log.WriteLine("line 86");
        log.WriteLine("line 87");
        log.WriteLine("line 88");
        log.WriteLine("line 89");
        log.WriteLine("line 90");
        log.WriteLine("line 91");
        log.WriteLine("line 92");
        log.WriteLine("line 93");
        log.WriteLine("line 94");
        log.WriteLine("line 95");
        log.WriteLine("line 96");
        log.WriteLine("line 97");
        log.WriteLine("line 98");
        log.WriteLine("line 99");
        log.WriteLine("line 100");
    }
    
    static void TestColors() {
    	SeleniumLog log = SeleniumLog.Instance();
    	log.Blue().WriteLine("Blue");
    	log.BlueGreen("BlueGrn");
    	log.Orange("Orange");
    	log.Red().WriteLine("Red");    	
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
        log.WriteLine("Testing Selenium Webdriver Integration");
        log.Screenshot();
        log.Pass();
    }
    
    static void TestScreenshots() {
    	FirefoxDriver driver0 = new FirefoxDriver();
    	SeleniumLog log = SeleniumLog.Instance();
    	
    	log.WriteLine("Testing Screenshots");
    	driver0.get("http://google.com");
    	//log.Screenshot();
    	log.WriteLine("Screenshot complete");
    	
    }
    
    static void TestSeleniumLogEventListener() {
    	ChromeDriver driver0 = new ChromeDriver();
        SeleniumLogEventListener driver = new SeleniumLogEventListener(driver0); 
    	SeleniumLog log = SeleniumLog.Instance(driver);
    	
        log.WriteLine("Step 1-: Goto Seleniumlog.com website");
        driver.get("http://seleniumlog.com");

        log.WriteLine("Step 2: Goto Downloads page");
        driver.findElement(By.xpath("//li/a[@href='/downloads.html']")).click();
        
        log.WriteLine("Step 3: Goto Contact Us page");
        driver.findElement(By.xpath("//li/a[@href='/contact-us.html']")).click();

        log.WriteLine("Step 4: Enter First Name");
        driver.findElement(By.id("input-780482698489254089")).sendKeys("Harold");

        log.WriteLine("Step 5: Enter Last Name");
        driver.findElement(By.id("input-780482698489254089-1")).sendKeys("Chung");

        log.WriteLine("Step 6: Enter Email address");
        driver.findElement(By.id("input-465062639798639934")).sendKeys("jredimer@yahoo.com.au");

        log.WriteLine("Step 7: Enter Comments");
        driver.findElement(By.id("input-417418761492911507")).sendKeys("JAVA Extension");

        log.WriteLine("Step 8: Click on Submit button");
        driver.findElement(By.xpath("//span[contains(text(),'Submit')]/..")).click();    
    }
    
    static WebDriver _testSingletonA() {
    	ChromeDriver driver0 = new ChromeDriver();
        SeleniumLogEventListener driver = new SeleniumLogEventListener(driver0); 
    	SeleniumLog log = SeleniumLog.Instance(driver);
    	
        log.WriteLine("Step 1-: Goto Seleniumlog.com website");
        driver.get("http://seleniumlog.com");

        log.WriteLine("Step 2: Goto Downloads page");
        driver.findElement(By.xpath("//li/a[@href='/downloads.html']")).click();
        
        log.WriteLine("Step 3: Goto Contact Us page");
        driver.findElement(By.xpath("//li/a[@href='/contact-us.html']")).click();

        log.WriteLine("Step 4: Enter First Name");
        driver.findElement(By.id("input-780482698489254089")).sendKeys("Harold");
        
        return driver;
    }
    
    static void _testSingletonB(WebDriver driver) {
    	//ChromeDriver driver0 = new ChromeDriver();
        //SeleniumLogEventListener driver = new SeleniumLogEventListener(driver0); 
    	SeleniumLog log = SeleniumLog.Instance();
    	
        log.WriteLine("Step 5: > Enter Last Name");
        driver.findElement(By.id("input-780482698489254089-1")).sendKeys("Chung");

        log.WriteLine("Step 6: Enter Email address");
        driver.findElement(By.id("input-465062639798639934")).sendKeys("jredimer@yahoo.com.au");

        log.WriteLine("Step 7: Enter Comments");
        driver.findElement(By.id("input-417418761492911507")).sendKeys("JAVA Extension");

        log.WriteLine("Step 8: Click on Submit button");
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
    	
        log.WriteLine("Step 1-: Goto Seleniumlog.com website");
        driver.get("http://seleniumlog.com");

        log.WriteLine("Step 2: Goto Downloads page");
        driver.findElement(By.xpath("//li/a[@href='/downloads.html']")).click();
        
        log.WriteLine("Step 3: Goto Contact Us page");
        driver.findElement(By.xpath("//li/a[@href='/contact-us2.html']")).click();

        log.WriteLine("Step 4: Enter First Name");
        driver.findElement(By.id("input-780482698489254089")).sendKeys("Harold");

        log.WriteLine("Step 5: Enter Last Name");
        driver.findElement(By.id("input-780482698489254089-1")).sendKeys("Chung");

        log.WriteLine("Step 6: Enter Email address");
        driver.findElement(By.id("input-465062639798639934")).sendKeys("jredimer@yahoo.com.au");

        log.WriteLine("Step 7: Enter Comments");
        driver.findElement(By.id("input-417418761492911507")).sendKeys("JAVA Extension");

        log.WriteLine("Step 8: Click on Submit button");
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

        log.WriteLine("Main");
        Foo();
        tobj.Message("hi there");
        
        driver.get("http://www.google.com");
        driver.navigate().to("http://www.upwork.com");
        driver.navigate().back();
        */
    }
}

package test;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ravimeda on 8/4/17.
 */
public class SearchFlights {

    String URL = "https://www.cleartrip.com/";
    WebDriver driver;


    @Test
    public void openApp() {
        System.setProperty("webdriver.chrome.driver","/Users/ravimeda/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--kiosk");
        //options.addArguments("--start-maximized");
        driver=new ChromeDriver(options);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println(allLinks.size());

        for(WebElement element : allLinks){
            System.out.println(element.getText());
            if(element.getText().equalsIgnoreCase("Terms of Use")){
                element.click();
                break;
            }

        }

        driver.quit();

    }




}

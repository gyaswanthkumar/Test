package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Main {
    public static String text;

    public static String Month_Year="April 2024";


    public static void main(String[] args) throws InterruptedException {

     //   System.setProperty("webdriver.chrome.driver","C://Users//YaswanthKumarGollapo//eclipse-workspace//Test//chromedriver.exe");

        WebDriverManager.edgedriver().setup();
          WebDriver driver =new EdgeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(4000);
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
        //driver.get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");
        Thread.sleep(4000);
        System.out.println(driver.getTitle());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)", "");
        driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();

        while(true)
        {
            text=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText().toString();
            Thread.sleep(2000);
            if(text.equals(Month_Year))
            {
                break;
            }
            else
            {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            }
        }
        WebElement select_date=driver.findElement(By.xpath("//a[normalize-space()='30']"));
        select_date.click();
        Thread.sleep(4000);
        //select_date.sendKeys(Keys.TAB);
        System.out.println("execution is completed");
        driver.close();

    }

}

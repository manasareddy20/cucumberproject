package org.Browser.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Browser {
    public static WebDriver driver;
    /*
    Intialization is to open the Chrome Browser
     */
    public static WebDriver Intialization(){
        try {
            String Browserchoice = Browser.fileProperties("browser");
            if(Browserchoice.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (Browserchoice.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            else{
                System.out.println("Wrong data");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return driver;
    }
    /* To open the url (Dynamic) */
    public static void Setup(String url){
try {
    driver.get(url);
    driver.manage().window().maximize();
}
catch(Exception e){
    System.out.println(e);
}
    }
    public static String fileProperties(String propertiesData)//browser
    {
        String returnData = null;
        try {
            String filelocation = System.getProperty("user.dir") + "//src//main//resources//Configuration//Configure.properties";
            File file = new File(filelocation);
            FileInputStream fileinput = new FileInputStream(file);
            Properties prop = new Properties();
            prop.load(fileinput);
            returnData = prop.getProperty(propertiesData); //browser
        }catch(Exception e)
        {
            System.out.println("Properties" + e);
        }
        return returnData;
    }
/* To close the Browser*/
    public static void Close(){
        try {
            driver.quit();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

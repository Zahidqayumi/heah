package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.velocity.tools.view.tools.BrowserSnifferTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

 
	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;
	private String propertypath= ".\\scr\\test\\resourses\\input\\property.properties";
	private String log4jpath = ".\\scr\\test\\resourses\\input\\log4j.properties";
	public base() {
		//bufferedreader to read data from file
		try {
			BufferedReader reader = new BufferedReader(new FileReader(propertypath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger = logger.getLogger("logger file");
		PropertyConfigurator.configure(log4jpath);
		//everything here is about input files
	}
	public static String GetBrowserName() {
		String browserName = properties.getProperty("browser");
		return browserName;
		
	}
	public static String getUrl() {
		String url = properties.getProperty("url");
		return url;
	}
	public static void openbrowser() {
		driver.get(getUrl());
	}
	public static void teardown() {
		driver.close();
		driver.quit();
	}
	public static void selectbrowser() {
		String browser = GetBrowserName();
		if (browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
}

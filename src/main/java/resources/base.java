package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class base {

	public 	WebDriver driver;
	public Properties prop;


public WebDriver initializedriver() throws IOException
{
	//Loading Property file
	 prop=new Properties();
	FileInputStream fis=new FileInputStream("//Users//naveenpavithran//eclipse-Interviews//GenProInterview//src/main//java//resources//data.properties");
	prop.load(fis);
	
	String browsername = prop.getProperty("browser");
	
	System.out.println(browsername);
	
	
	if(browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "//Users//naveenpavithran//chromedriverfile//chromedriver");
		 driver=new ChromeDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	return driver;
	
}

//Method to take Screenshot of failed Tests
public void takeScreenshot(String testMethodName, WebDriver driver)
{
String screenName= testMethodName+ ".png";
File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
try
{
FileHandler.copy(src, new File(System.getProperty("user.dir")+"/target/Screenshots/"+screenName+""));
}
catch(IOException e)
{
System.out.println(e.getMessage());
}
}

}


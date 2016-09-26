/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesForce;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.QueryParam;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
/**

/**
 * REST Web Service
 *
 * @author Administrator
 */
@Path("ContainerTracker")
public class ContainerTrackerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ContainerTrackerResource
     */
    public ContainerTrackerResource() {
    }
    @GET
    @Path("/getContainerStatus")
    @Produces(MediaType.TEXT_PLAIN)
    public String getContainerStatus(@QueryParam("param1") String id)
    {
        String ReturnText="";
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        //WebDriver driver = new FirefoxDriver();

       // Capabilities caps = new DesiredCapabilities();
         //       ((DesiredCapabilities) caps).setJavascriptEnabled(true);                
           //     ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);  
             //   ((DesiredCapabilities) caps).setCapability(
               //         PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                 //       "D:\\phantom\\phantomjs.exe"
                   // );
        //WebDriver driver = new  PhantomJSDriver(caps);
        
        // And now use this to visit Google
        //driver.get("http://denvycom.com/blog/");
        //Alternatively the same thing can be done like this
        driver.navigate().to("http://146.145.36.162/ContainerLookup1.php");

        // Find the Denvycom search input element by its name
        WebElement element = driver.findElement(By.name("ContNo"));

        // Enter something to search for
        element.sendKeys(id);

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        // Should see: "All Articles on Denvycom related to the Keyword "Research""

        //Get the title of all posts
        ///html/body/form/table[3]/tbody/tr/td/div/b/font
        WebElement titles = driver.findElement(By.xpath("/html/body"));
        //List<WebElement> dates = driver.findElements(By.cssSelector("span.entry-date"));
        System.out.println(" =============== Denvycom Articles on Research ================= ");
		System.out.println(titles.getText()+" get Table tags");

        //Close the browser
        ReturnText = titles.getText();
        driver.quit();
        return ReturnText;
    }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

      
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 1); // 1 = Allow
        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.get("https://dev-dash.janitri.in/");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}

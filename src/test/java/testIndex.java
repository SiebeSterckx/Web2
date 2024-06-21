import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class testIndex {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/Sterckx_Siebe_war_exploded/Servlet?command=index");
    }

    @Test
    public void testLinkNaarVoegToe() {
        WebElement formulierKnop = driver.findElement(By.linkText("dit formulier"));
        formulierKnop.click();
        assertEquals("Voeg Toe", driver.getTitle());
    }

    @After
    public void close() {
        driver.quit();
    }

}

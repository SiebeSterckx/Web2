import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class testZoeken {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/Sterckx_Siebe_war_exploded/Servlet?command=zoekFormulier");
    }

    @Test
    public void testZoekFunctie() {
        WebElement model = driver.findElement(By.id("Model"));
        model.clear();
        model.sendKeys("Enzo");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        assertEquals("Result", driver.getTitle());
    }

    @Test
    public void testZoekFunctieMetElementNietInOverzicht() {
        WebElement model = driver.findElement(By.id("Model"));
        model.clear();
        model.sendKeys("ppppppppp");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        assertEquals("Result", driver.getTitle());


    }

    @After
    public void close() {
        driver.quit();
    }

}

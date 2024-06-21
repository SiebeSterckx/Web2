import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidHtmlTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

   @After
    public void clean() {

        driver.quit();
    }

    @Test
    public void isValidHtml1() {
        driver.get("https://html5.validator.nu/");
        WebElement invulveld = driver.findElement(By.id("doc"));


        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Sterckx-Siebe_war/Servlet?command=index");

        WebElement button = driver.findElement(By.id("submit"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("#results .success"));
        assertEquals("The document is valid HTML5 + ARIA + SVG 1.1 + MathML 2.0 (subject to the utter previewness of this service).", pass.getText());
    }
    @Test
    public void isValidHtml2() {
        driver.get("https://html5.validator.nu/");
        WebElement invulveld = driver.findElement(By.id("doc"));


        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Sterckx-Siebe_war/Servlet?command=voegToe");

        WebElement button = driver.findElement(By.id("submit"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("#results .success"));
        assertEquals("The document is valid HTML5 + ARIA + SVG 1.1 + MathML 2.0 (subject to the utter previewness of this service).", pass.getText());
    }
    @Test
    public void isValidHtml3() {
        driver.get("https://html5.validator.nu/");
        WebElement invulveld = driver.findElement(By.id("doc"));


        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Sterckx-Siebe_war/Servlet?command=overzicht");

        WebElement button = driver.findElement(By.id("submit"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("#results .success"));
        assertEquals("The document is valid HTML5 + ARIA + SVG 1.1 + MathML 2.0 (subject to the utter previewness of this service).", pass.getText());
    }
    @Test
    public void isValidHtml4() {
        driver.get("https://html5.validator.nu/");
        WebElement invulveld = driver.findElement(By.id("doc"));


        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/Sterckx-Siebe_war/Servlet?command=zoekFormulier");

        WebElement button = driver.findElement(By.id("submit"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("#results .success"));
        assertEquals("The document is valid HTML5 + ARIA + SVG 1.1 + MathML 2.0 (subject to the utter previewness of this service).", pass.getText());
    }


}
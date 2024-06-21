import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class testOverzicht {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/Sterckx_Siebe_war_exploded/Servlet?command=overzicht");
    }

    @Test
    public void testVerwijderenMetBevestiging() {

        driver.findElement(By.linkText("Verwijder")).click();
        assertEquals("deleteBevestiging", driver.getTitle());
        driver.findElement(By.id("verwijderen")).click();
        assertEquals("Overzicht", driver.getTitle());


    }

    @Test
    public void testVerwijderenMetAfbraak() {

        driver.findElement(By.linkText("Verwijder")).click();
        assertEquals("deleteBevestiging", driver.getTitle());
        driver.findElement(By.id("nietVerwijderen")).click();
        assertEquals("Overzicht", driver.getTitle());

    }

    @Test
    public void testUpdateMetAfbraak() {

        driver.findElement(By.linkText("Update")).click();
        assertEquals("updateBevestiging", driver.getTitle());
        driver.findElement(By.id("annuleer")).click();
        assertEquals("Overzicht", driver.getTitle());

    }

    @Test
    public void testUpdateMetBevestiging() {

        driver.findElement(By.linkText("Update")).click();
        assertEquals("updateBevestiging", driver.getTitle());
        WebElement aantal = driver.findElement(By.id("Aantal"));
        aantal.clear();
        aantal.sendKeys("111");
        driver.findElement(By.id("submit")).click();
        assertEquals("Overzicht", driver.getTitle());

    }

    @After
    public void close() {
        driver.quit();
    }

}

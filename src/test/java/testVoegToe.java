import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class testVoegToe {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/Sterckx_Siebe_war_exploded/Servlet?command=voegToe");
    }


    @Test
    public void testVoegToeFunctie() {

        WebElement merk = driver.findElement(By.id("Merk"));
        merk.clear();
        merk.sendKeys("Koenigsegg");
        WebElement model = driver.findElement(By.id("Model"));
        model.clear();
        model.sendKeys("Agera R");
        WebElement pk = driver.findElement(By.id("Pk"));
        pk.clear();
        pk.sendKeys("1000");
        WebElement aantal = driver.findElement(By.id("Aantal"));
        aantal.clear();
        aantal.sendKeys("3");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        assertEquals("Overzicht", driver.getTitle());

    }

    @Test
    public void testVoegLeegToe() {
        WebElement merk = driver.findElement(By.id("Merk"));
        merk.clear();
        merk.sendKeys("");
        WebElement model = driver.findElement(By.id("Model"));
        model.clear();
        model.sendKeys("");
        WebElement pk = driver.findElement(By.id("Pk"));
        pk.clear();
        pk.sendKeys("");
        WebElement aantal = driver.findElement(By.id("Aantal"));
        aantal.clear();
        aantal.sendKeys("");
        driver.findElement(By.id("submit")).click();
        assertEquals("Voeg Toe", driver.getTitle());

    }

    @Test
    public void testVoegToeMetPkLeeg() {
        WebElement merk = driver.findElement(By.id("Merk"));
        merk.clear();
        merk.sendKeys("Lamborghini");
        WebElement model = driver.findElement(By.id("Model"));
        model.clear();
        model.sendKeys("Aventador");
        WebElement pk = driver.findElement(By.id("Pk"));
        pk.clear();
        pk.sendKeys("");
        WebElement aantal = driver.findElement(By.id("Aantal"));
        aantal.clear();
        aantal.sendKeys("15");
        driver.findElement(By.id("submit")).click();
        assertEquals("Overzicht", driver.getTitle());
    }

    @Test
    public void testVoegToeMetModelLeeg() {
        WebElement merk = driver.findElement(By.id("Merk"));
        merk.clear();
        merk.sendKeys("Koenigsegg");
        WebElement model = driver.findElement(By.id("Model"));
        model.clear();
        model.sendKeys("");
        WebElement pk = driver.findElement(By.id("Pk"));
        pk.clear();
        pk.sendKeys("1000");
        WebElement aantal = driver.findElement(By.id("Aantal"));
        aantal.clear();
        aantal.sendKeys("3");
        driver.findElement(By.id("submit")).click();
        assertEquals("Voeg Toe", driver.getTitle());

    }

    @Test
    public void testVoegToeMetAantalLeeg() {

        WebElement merk = driver.findElement(By.id("Merk"));
        merk.clear();
        merk.sendKeys("Koenigsegg");
        WebElement model = driver.findElement(By.id("Model"));
        model.clear();
        model.sendKeys("Agera R");
        WebElement pk = driver.findElement(By.id("Pk"));
        pk.clear();
        pk.sendKeys("1000");
        WebElement aantal = driver.findElement(By.id("Aantal"));
        aantal.clear();
        aantal.sendKeys("");
        driver.findElement(By.id("submit")).click();
        assertEquals("Voeg Toe", driver.getTitle());


    }

    @Test
    public void testVoegToeMetMerkLeeg() {

        WebElement merk = driver.findElement(By.id("Merk"));
        merk.clear();
        merk.sendKeys("");
        WebElement model = driver.findElement(By.id("Model"));
        model.clear();
        model.sendKeys("Agera R");
        WebElement pk = driver.findElement(By.id("Pk"));
        pk.clear();
        pk.sendKeys("1000");
        WebElement aantal = driver.findElement(By.id("Aantal"));
        aantal.clear();
        aantal.sendKeys("3");
        driver.findElement(By.id("submit")).click();
        assertEquals("Voeg Toe", driver.getTitle());

    }

    @After
    public void close() {

        driver.quit();
    }


}

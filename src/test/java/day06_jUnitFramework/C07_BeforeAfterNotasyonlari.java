package day06_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C07_BeforeAfterNotasyonlari {

    WebDriver driver;

    //Eger siradan bir method'un her test method'undan once calismasini isterseniz
    @BeforeEach
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //Eger siradan bir method'un her test method'undan sonra calismasini isterseniz
    @AfterEach
    public void teardown(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

    @Test
    @Disabled
    public void googleTesti(){

        // google anasayfaya gidin
        driver.get("https://www.google.com");
        // anasayfaya gittiginizi test edin
        String expectedUrlIcerik = "google";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("google testi PASSED");
        } else System.out.println("google testi FAILED");


    }

    @Test
    public void testotomasyonuTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // anasayfaya gittiginizi test edin

        String expectedUrlIcerik = "testotomasyonuppppp";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");

    }

    @Test
    public void wisequarterTest(){

        // wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");
        // anasayfaya gittiginizi test edin
        String expectedUrlIcerik = "wisequarterpppp";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        } else System.out.println("Wisequarter testi FAILED");


    }
}

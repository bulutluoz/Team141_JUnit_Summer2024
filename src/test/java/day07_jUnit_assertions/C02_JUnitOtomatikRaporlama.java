package day07_jUnit_assertions;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class C02_JUnitOtomatikRaporlama {

    static WebDriver driver;
    static List<WebElement> bulunanSonucElementleriList;

    @BeforeAll  // Hic bir @Test method'u calismadan en basta sadece 1 kere calisir
    public static void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll // Tum @Test method'lari calisip bittikten sonra en sonda sadece 1 kere calisir
    public static void teardown(){
        driver.quit();
    }

    @Test
    @Order(1)
    public void anasayfaTesti() throws InterruptedException {
        // 1- testotomasyonu anasayfaya gidin ve anasayfaya gittiginizi test edin
        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // testotomasyonu sayfasina gittiginizi test edin

        String expectedUrlIcerik = "testotomasyonuTTT";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");
        Thread.sleep(2000);
    }

    @Test @Order(2)
    public void phoneAramaTesti() throws InterruptedException {
        // 2- phone icin arama yaptirip,
        System.out.println(driver.getCurrentUrl());
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='global-search']"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //arama sonucunda urun bulunabildigini test edin
        bulunanSonucElementleriList =
                driver.findElements(By.xpath("//*[@*='prod-img']"));

        if (bulunanSonucElementleriList.size()>40){
            System.out.println("phone arama testi PASSED");
        }else System.out.println("phone arama testi FAILED");
        Thread.sleep(2000);
    }

    @Test @Order(3)
    public void ilkUrunIsimTesti() throws InterruptedException {
        // 3- ilk urunu tiklayip, urun isminde case sensitive olmaksizin phone gectigini test edin

        bulunanSonucElementleriList.get(0).click();

        WebElement ilkUrunIsimElementi =
                driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsimIcerigi = "phoneTTTT";
        String actualUrunIsmi = ilkUrunIsimElementi
                .getText()
                .toLowerCase();

        if (actualUrunIsmi.contains(expectedUrunIsimIcerigi)){
            System.out.println("Urun isim testi PASSED");
        }else System.out.println("Urun isim testi FAILED");
        Thread.sleep(2000);
    }

}

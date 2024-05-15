package day06_jUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_AramaTesti {

    // gerekli ayarlamalari yapip
    // 3 farkli test method'u olusturun
    // ve asagidaki testleri farkli test method'larinda calistirin
    // 1- testotomasyonu anasayfaya gidin ve anasayfaya gittiginizi test edin
    // 2- phone icin arama yaptirip, arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, urun isminde case sensitive olmaksizin phone gectigini test edin
    WebDriver driver;

    @Test
    public void test01_anasayfaTesti(){

        // gerekli ayarlamalari yapip
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1- testotomasyonu anasayfaya gidin ve anasayfaya gittiginizi test edin
        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // testotomasyonu sayfasina gittiginizi test edin

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");

    }

    @Test
    public void test02_phoneAramaTesti(){
        // 2- phone icin arama yaptirip,
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanSonucElementleriList =
                driver.findElements(By.xpath("//*[@*='prod-img']"));

        if (bulunanSonucElementleriList.size()>0){
            System.out.println("phone arama testi PASSED");
        }else System.out.println("phone arama testi FAILED");
    }

    @Test
    public void test03_ilkUrunIsimTesti(){
        // 3- ilk urunu tiklayip, urun isminde case sensitive olmaksizin phone gectigini test edin


    }


}

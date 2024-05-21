package day10_switchingWindows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_KontrolsuzAcilanYeniWindowaGecis extends TestBase {

    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedYazi = "Opening a new window";
        String actualyazi = driver.findElement(By.tagName("h3"))
                                    .getText();

        Assertions.assertEquals(expectedYazi,actualyazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        System.out.println("click yapmadan once driver whd : " + driver.getWindowHandle());
        System.out.println("click yapmadan acik olan tum window'larin WHD'leri : " + driver.getWindowHandles());

        //● Click Here butonuna basın.

        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();
        // bu linki tikladigimizda KONTROLSUZ yeni bir window aciliyor
        // driver, kontrolsuz acilan window'u BILMEZ ve otomatik olarak ILK WINDOW'da kalir
        // testimiz icin driver'i yeni window'a gecirmemiz gerekiyorsa
        // bunu BIZ YAPMALIYIZ
        // driver.switchTo().window(yeniAcilanWindowWHD)

        System.out.println("=====================================");
        System.out.println("click yaptiktan sonra driver whd : " + driver.getWindowHandle());
        System.out.println("click yaptiktan sonra olan tum window'larin WHD'leri : " + driver.getWindowHandles());



        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu test edin

        ReusableMethods.bekle(3);
    }
}

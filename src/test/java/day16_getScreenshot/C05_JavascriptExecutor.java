package day16_getScreenshot;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_JavascriptExecutor extends TestBase {

    @Test
    public void test01(){

        // Testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(2);

        // Best Sport Shoes For Multi Gender.  gorunene kadar asagi inin
        WebElement bestSportShoesElementi = driver.findElement(By.xpath("(//*[@class='blog-heading'])[2]"));
        System.out.println(bestSportShoesElementi.getText());


        Actions actions = new Actions(driver);
        actions.moveToElement(bestSportShoesElementi).perform();
        ReusableMethods.bekle(2);
        bestSportShoesElementi.click();

        ReusableMethods.bekle(2);


        // driver objesi bizim elimiz, gozumuz gibidir
        // normalde ekranda gorunmeyen bir elementi kullanamamasi beklenir
        // AMA bu developer'larin yazdigi koda gore degisir
        // bazi sayfalarda gorunmeyen elementleri kullanamazken
        // bazi sayfalarda kullanabiliriz


        driver.get("https://www.wisequarter.com");




        // why choose us linkine kadar asagi inelim
        ReusableMethods.bekle(2);

        WebElement whyChooseUsLinki = driver.findElement(By.xpath("//*[text()='Why '] "));


        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'}); ",whyChooseUsLinki);


        ReusableMethods.bekle(2);


        System.out.println(whyChooseUsLinki.getText());

        ReusableMethods.bekle(2);

        whyChooseUsLinki.click();

        ReusableMethods.bekle(3);

        jse.executeScript("alert('Yanlis giris yaptiniz....');");


        ReusableMethods.bekle(3);

    }
}

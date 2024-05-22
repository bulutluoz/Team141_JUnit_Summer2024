package day11_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_FormDoldurma extends TestBase {

    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
        //2- Account linkine tiklayin
        driver.findElement(By.xpath("//*[text()='Account']"))
                .click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath(" //*[text()=' Sign Up']"))
                .click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim

        WebElement firstnameKutusu= driver.findElement(By.id("firstName"));
        Actions actions = new Actions(driver);

        ReusableMethods.bekle(1);
        actions.click(firstnameKutusu)
                .sendKeys("Ilgar")
                .sendKeys(Keys.TAB)
                .sendKeys("Avluk")
                .sendKeys(Keys.TAB)
                .sendKeys("abcde@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .perform();
        //ve Sign Up butonuna basalim
        ReusableMethods.bekle(2);
        driver.findElement(By.id("btn-submit-form"))
                .click();

        //5- Kaydin olusturuldugunu test edin
        ReusableMethods.bekle(3);
        // test etmek icin sisteme giris yapalim
        WebElement emailAdresKutusu = driver.findElement(By.id("email"));

        actions.click(emailAdresKutusu)
                .sendKeys("abcde@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .perform();

        driver.findElement(By.id("submitlogin"))
                .click();


        WebElement logoutButonu = driver.findElement(By.xpath("//span[text()='Logout']"));

        Assertions.assertTrue(logoutButonu.isDisplayed());

        ReusableMethods.bekle(10);

    }
}

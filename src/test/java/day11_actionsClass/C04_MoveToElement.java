package day11_actionsClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_MoveToElement extends TestBase {

    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        ReusableMethods.bekle(2);



        //3- “Boys” linkine basin
        driver.findElement(By.linkText("Boys"))
                .click();

        //4- Acilan sayfadaki ilk urunu tiklayin
        //5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        ReusableMethods.bekle(2);
    }
}

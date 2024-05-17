package day08_dropdownMenuKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C05_DropdownMenu extends TestBase {

    /*
        Dropdown OZEL BIR acilir menudur.

        bir acilir menunun dropdown olup olmadigini anlamak icin
        asagidaki 2 sarti sagladigini kontol etmeliyiz
        1- select tag'i ile olusturulmalidir
        2- secim yapabilecegimiz opsiyonlar option tagi ile olusturulmalidir
     */


    @Test
    public void dropdownTesti(){
        //● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");
        //1. Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        WebElement gunDropdownElementi =
                driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));

        Select selectGun = new Select(gunDropdownElementi);

        selectGun.selectByIndex(5);

        //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        WebElement ayDropdownElementi = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDropdownElementi);
        selectAy.selectByValue("nisan");

        //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilDropdownElementi = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yilDropdownElementi);
        selectYil.selectByVisibleText("1990");


        //4. Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());

        //5. Ay dropdown menüdeki tum değerleri(value) yazdırın

        List<WebElement> ayMenusuTumOpsiyonElementleriListesi  = selectAy.getOptions();

        System.out.println(ReusableMethods.stringListesineDonustur(ayMenusuTumOpsiyonElementleriListesi));

        //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedOptionSayisi = 13;
        int actualOptionSayisi = ayMenusuTumOpsiyonElementleriListesi.size();

        Assertions.assertEquals(expectedOptionSayisi,actualOptionSayisi);

        ReusableMethods.bekle(2);
    }
}

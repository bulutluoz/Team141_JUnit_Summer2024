package day11_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_SurukleBirakTesti extends TestBase {

    @Test
    public void test(){
        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");
        ReusableMethods.bekle(1);

        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        Actions actions = new Actions(driver);

        WebElement acceptableButonu = driver.findElement(By.xpath("//*[@id='draggable2']"));
        WebElement dropHereElementi = driver.findElement(By.xpath("//*[@id='droppable2']"));

        actions.dragAndDrop(acceptableButonu,dropHereElementi)
                .perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        WebElement droppedYaziElementi = driver.findElement(By.xpath("//p[text()='Dropped!']"));

        String expectedYazi = "Dropped!";
        String actualYazi = dropHereElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //4- Sayfayi yenileyin
        driver.navigate().refresh();
        ReusableMethods.bekle(1);

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptableElementi = driver.findElement(By.xpath("//*[text()='Not Acceptable']"));
        dropHereElementi = driver.findElement(By.xpath("//*[@id='droppable2']"));


        actions.dragAndDrop(notAcceptableElementi,dropHereElementi)
                .perform();


        //6- “Drop Here” yazisinin degismedigini test edin
        WebElement dropHereYaziElementi = driver.findElement(By.xpath("//p[text()='Drop Here']"));

        expectedYazi = "Drop Here";
        actualYazi = dropHereYaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(1);
    }
}

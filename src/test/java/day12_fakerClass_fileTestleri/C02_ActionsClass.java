package day12_fakerClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_ActionsClass extends TestBase {

    @Test
    public void test01(){

        //1- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //2- video’yu gorecek kadar asagi inin

        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //3- videoyu izlemek icin Play tusuna basin

        // video iFrame icinde oldugundan once iFrame'e gecis yapalim
        WebElement videoIframeElementi = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(videoIframeElementi);


        // play tusuna basalim
        driver.findElement(By.xpath("//*[@title='Play']"))
                .click();
        ReusableMethods.bekle(1);
        //4- videoyu calistirdiginizi test edin

        WebElement pauseTusu = driver.findElement(By.xpath("//*[@aria-label='Pause keyboard shortcut k']"));

        Assertions.assertTrue(pauseTusu.isDisplayed());

        ReusableMethods.bekle(5);
    }
}

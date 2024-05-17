package day08_dropdownMenuKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_All;

public class C04_TestBaseKullanimi extends TestBase_All {


    @Test
    public void checkboxTesti(){
        //	a. Verilen web sayfasına gidin.
        //	     https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");


        //	b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1Elementi = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2Elementi = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        //	c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkbox1Elementi.isSelected()){
            checkbox1Elementi.click();
        }
        //	d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkbox2Elementi.isSelected()){
            checkbox2Elementi.click();
        }

        //	e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin

        Assertions.assertTrue(checkbox1Elementi.isSelected());

        Assertions.assertTrue(checkbox2Elementi.isSelected());
    }


}

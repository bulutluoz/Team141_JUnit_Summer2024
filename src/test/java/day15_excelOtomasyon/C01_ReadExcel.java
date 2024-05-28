package day15_excelOtomasyon;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

        @Test
    public void test01() throws IOException {

     // Ulkeler excel dosyasi, web'de olmadigindan
     // driver isimize yaramaz
     // bilgisayarimizdaki bir dosyaya ulasmak icin
     // Java'daki FileInputStream class'ini kullanabiliriz
     // Java'nin dosyaya ulasip bilgileri alabilmesi icin dosyaYolu'na ihtiyacimiz var

      String dosyaYolu = "src/test/java/day15_excelOtomasyon/ulkeler.xlsx";

      // 1.adim fileInputStream objesi olusturalim
      FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

            System.out.println(fileInputStream);
      // 2.adim fileInputStream'in okudugu bilgileri
      //        class'imizda olusturacagimiz bir workbook'a yukleyelim

      Workbook workbook = WorkbookFactory.create(fileInputStream);

      // ONEMLI NOT : workbook objesini bu class'da biz olusturduk
      // dolayisiyla workbook <=====> ulkeler excelidir demek YANLIS OLUR
      // dogrusu su cumle olur :
      // Java verilen dosya yolu sayesinde excel'e ulasti,
      // FileInputStream ile excel'deki tum bilgileri aldi
      // ve WorkbookFactory class'indaki create()'u alinan bilgileri
      // kodumuzun icinde EXCEL DOSYASININ KOPYASI olan "workbook" objesine yukledi

       // biz bu satirdan itibaren, excel dosyasi ile degil
       // onun kopyasi olan workbook ile calisacagiz
       // istedigimiz tum bilgileri workbook'dan alacagiz.

    }
}

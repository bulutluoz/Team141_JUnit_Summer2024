package day12_fakerClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_DinamikFileExistTesti {

    @Test
    public void test01(){

        // masaustumuzde upload.png isimli bir dosya oldugunu test edin

        String dosyaYolu = "/Users/ahmetbulutluoz/Desktop/upload.png";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //       /Users/ahmetbulutluoz                       /Desktop/upload.png
        //      C:\\Users\\Toshiba                          \\Desktop\\upload.png
        //      /Users/burhanakyuz                          /Desktop/upload.png

        // Tum bilgisayarlarda tanimli bir anaDosyaYolu vardir
        // Java bu temel dosya yolunu bize veren bir koda sahiptir

        System.out.println(System.getProperty("user.home")); //   /Users/ahmetbulutluoz



        dosyaYolu = System.getProperty("user.home") + "/Desktop/upload.png";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}

package day12_fakerClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExistsTesti {

    @Test
    public void test01(){

        // day12 package'i altinda upload.png dosyasinin oldugunu test edin

        // Selenium WebDriver ile calisir
        // WebDriver objesi olan driver ile istedigimiz sayfaya gider
        // istedigimiz webElementi kullanir, istedigimiz bilgileri aliriz

        // AMMA driver objemiz bilgisayarimiza mudahale edemez
        // bilgisayarimizdaki dosyalara erismek istersek
        // Java'dan yardim almaliyiz

        String dosyaYolu = "src/test/java/day12_fakerClass_fileTestleri/upload.png";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}

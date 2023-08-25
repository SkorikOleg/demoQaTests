package guru.qa.ex;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideFilesTest {

    static {
        Configuration.pageLoadStrategy = "eager";
    }

    //экспорт файла TXT
    @Test
    void downloadTxtFileTest() throws Exception {//добавляем исключение метода через throws
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloaded = $("a[href*='/junit-team/junit5/raw/main/README.md']").download();

        try (InputStream is = new FileInputStream(downloaded)) {
            byte[] bytes = is.readAllBytes();
            String content = new String(bytes, StandardCharsets.UTF_8);
            Assertions.assertTrue(content.contains("This repository is the home of _JUnit 5_"));
        } //всегда после чтения или записи нужно закрывать стрим, т.к. мы используем файловые дискрипторы своей ОС


//если хотим протестировать исключения, то нужно писать вот так
        /*Assertions.assertThrows(FileNotFoundException.class,
                () -> $("a[href*='/junit-team/junit5/raw/main/README.md']").download())*/

        /*
InputStream позволяет читать файл по байтово - универсален
reader позволяет читать файл по символьно - читает только текстовые

OutputStream позволяет записывать любой файл в виде байтов
writer позволяет записывать любой файл в виде символов
 */
    }

    //импорт файла любого
    @Test
    void uploadFileTest() {
        open("https://fineuploader.com/demos.html");
        $("input[type='file'").uploadFromClasspath("filesEx10/Cat.png");
        $(".qq-file-name").shouldHave(Condition.text("Cat.png"));

    }

    //экспорт файла PDF
    //для парсинга формата PDF нужно добавить библиотеку 'com.codeborne:pdf-test:1.8.1'
    @Test
    void downloadPdfFileTest() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File downloaded = $("a[href*='junit-user-guide-5.10.0.pdf']").download();
        PDF pdf = new PDF(downloaded);
        Assertions.assertEquals("JUnit 5 User Guide", pdf.title);
        System.out.println();
    }

    //экспорт файла XLS
    @Test
    void downloadXlsFileTest() throws Exception {

        open("http://vexcele.ru/load/dlja_biznesa/grafik_otpuskov/5-1-0-6");
        File downloaded = $("a[href*='Grafik_otpuskov_2016_full_holidays.xlsm']")
                .download();
        XLS xls = new XLS(downloaded);
        Assertions.assertEquals("Сотрудник 1",
                xls.excel.getSheetAt(0)
                        .getRow(8)
                        .getCell(0)
                        .getStringCellValue());
    }
}

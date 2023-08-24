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

    //������� ����� TXT
    @Test
    void downloadTxtFileTest() throws Exception {//��������� ���������� ������ ����� throws
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloaded = $("a[href*='/junit-team/junit5/raw/main/README.md']").download();

        try (InputStream is = new FileInputStream(downloaded)) {
            byte[] bytes = is.readAllBytes();
            String content = new String(bytes, StandardCharsets.UTF_8);
            Assertions.assertTrue(content.contains("This repository is the home of _JUnit 5_"));
        } //������ ����� ������ ��� ������ ����� ��������� �����, �.�. �� ���������� �������� ����������� ����� ��


//���� ����� �������������� ����������, �� ����� ������ ��� ���
        /*Assertions.assertThrows(FileNotFoundException.class,
                () -> $("a[href*='/junit-team/junit5/raw/main/README.md']").download())*/

        /*
InputStream ��������� ������ ���� �� ������� - �����������
reader ��������� ������ ���� �� ��������� - ������ ������ ���������

OutputStream ��������� ���������� ����� ���� � ���� ������
writer ��������� ���������� ����� ���� � ���� ��������
 */
    }

    //������ ����� ������
    @Test
    void uploadFileTest() {
        open("https://fineuploader.com/demos.html");
        $("input[type='file'").uploadFromClasspath("filesEx10/Cat.png");
        $(".qq-file-name").shouldHave(Condition.text("Cat.png"));

    }

    //������� ����� PDF
    //��� �������� ������� PDF ����� �������� ���������� 'com.codeborne:pdf-test:1.8.1'
    @Test
    void downloadPdfFileTest() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File downloaded = $("a[href*='junit-user-guide-5.10.0.pdf']").download();
        PDF pdf = new PDF(downloaded);
        Assertions.assertEquals("JUnit 5 User Guide", pdf.title);
        System.out.println();
    }

    //������� ����� XLS
    @Test
    void downloadXlsFileTest() throws Exception {

        open("http://vexcele.ru/load/dlja_biznesa/grafik_otpuskov/5-1-0-6");
        File downloaded = $("a[href*='Grafik_otpuskov_2016_full_holidays.xlsm']")
                .download();
        XLS xls = new XLS(downloaded);
        Assertions.assertEquals("��������� 1",
                xls.excel.getSheetAt(0)
                        .getRow(8)
                        .getCell(0)
                        .getStringCellValue());
    }
}

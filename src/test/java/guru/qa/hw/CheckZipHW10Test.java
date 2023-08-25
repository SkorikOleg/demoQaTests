package guru.qa.hw;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CheckZipHW10Test {

    private final ClassLoader cl = CheckZipHW10Test.class.getClassLoader();

    @DisplayName("Проверка наличия файлов в ZIP")
    private ZipInputStream openZipStream() {
        InputStream stream = cl.getResourceAsStream("filesHW10/hW10.zip");
        return new ZipInputStream(stream);
    }

    private boolean isFileInZip(String fileName, ZipInputStream zipInputStream) throws Exception {
        ZipEntry entry;
        while ((entry = zipInputStream.getNextEntry()) != null) {
            if (entry.getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }
@DisplayName("ZIP содержит нужный csv файл")
    @Test
    void checkCsvTest() throws Exception {
        try (ZipInputStream zip = openZipStream()) {
            Assertions.assertTrue(isFileInZip("test.csv", zip));
            Reader reader = new InputStreamReader(zip);
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> content = csvReader.readAll();
            Assertions.assertEquals(3, content.size());

            final String[] firstRow = content.get(0);
            final String[] secondRow = content.get(1);
            final String[] thirdRow = content.get(2);

            Assertions.assertArrayEquals(new String[]{"Film", " actor"}, firstRow);
            Assertions.assertArrayEquals(new String[]{"Dune", " Zendaya"}, secondRow);
            Assertions.assertArrayEquals(new String[]{"Mission: Impossible", " Tom Cruise"}, thirdRow);
        }
    }

    @DisplayName("ZIP содержит нужный pdf файл")
    @Test
    void checkPdfTest() throws Exception {
        try (ZipInputStream zip = openZipStream()) {
            Assertions.assertTrue(isFileInZip("deadSouls.pdf", zip));
            PDF pdf = new PDF(zip);
            Assertions.assertTrue(pdf.text.contains("Мертвые души"));
        }
    }

    @DisplayName("ZIP содержит нужный xls файл")
    @Test
    void checkXlsTest() throws Exception {
        try (ZipInputStream zip = openZipStream()) {
            Assertions.assertTrue(isFileInZip("Sample.xlsx", zip));
            XLS xls = new XLS(zip);
            Assertions.assertEquals("Brad Bird",
                    xls.excel.getSheetAt(0)
                            .getRow(4)
                            .getCell(2)
                            .getStringCellValue());
        }
    }
}

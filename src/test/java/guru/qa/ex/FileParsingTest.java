package guru.qa.ex;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import guru.qa.model.GlossaryModelExample;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileParsingTest {
    private final ClassLoader cl = FileParsingTest.class.getClassLoader();
    private final Gson gson = new Gson();

    //чтение csv файлов
    @Test
    void csvTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("filesEx10/test.csv");
             Reader reader = new InputStreamReader(stream)) {
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> content = csvReader.readAll();//лист массивов List[]
            Assertions.assertEquals(3, content.size());

            final String[] firstRow = content.get(0);
            final String[] secondRow = content.get(1);
            final String[] thirdRow = content.get(2);

            Assertions.assertArrayEquals(new String[]{"Teacher", "lesson"}, firstRow);
            Assertions.assertArrayEquals(new String[]{"Tuchs", "Files"}, secondRow);
            Assertions.assertArrayEquals(new String[]{"Vasenkov", "REST Assured"}, thirdRow);
        }
    }

    @Test
    void zipTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("filesEx10/Test.zip");
             ZipInputStream zip = new ZipInputStream(stream)) {

            ZipEntry entry;//файлик внутри архива
            while ((entry = zip.getNextEntry()) != null) {
                final String name = entry.getName();
                Assertions.assertEquals("Cat.png", name);
            }
        }
    }
//более сложный вариант
    @Test
    void jsonTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("filesEx10/sample.json");
             Reader reader = new InputStreamReader(stream)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            Assertions.assertEquals("example glossary", jsonObject.get("title").getAsString());

            Assertions.assertEquals("S", jsonObject.get("gloss_div")
                    .getAsJsonObject().get("title").getAsString());

            Assertions.assertTrue(jsonObject.get("gloss_div")
                    .getAsJsonObject().get("flag").getAsBoolean());

        }
    }
    //более простой и понятный через глоссарий
    @Test
    void improvedJsonTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("filesEx10/sample.json");
             Reader reader = new InputStreamReader(stream)) {
            GlossaryModelExample glossary = gson.fromJson(reader, GlossaryModelExample.class);

            Assertions.assertEquals("example glossary", glossary.getTitle());

            Assertions.assertEquals("S", glossary.getGlossDiv().getTitle());

            Assertions.assertTrue(glossary.getGlossDiv().getFlag());

        }
    }
}

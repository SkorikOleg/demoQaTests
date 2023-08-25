package guru.qa.hw;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.model.ModelHW10;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class CheckJsonWithJacksonHW10Test {

    private final ClassLoader cl = CheckJsonWithJacksonHW10Test.class.getClassLoader();


    @DisplayName("Использование jackson для чтения json")
    @Test
    void useJacksonForJson() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("filesHW10/hW10.json");
             Reader reader = new InputStreamReader(stream)) {
            ObjectMapper mapper = new ObjectMapper();
            ModelHW10 modelHW10 = mapper.readValue(reader, ModelHW10.class);


            Assertions.assertEquals("toyota", modelHW10.getBrand());

            Assertions.assertEquals("allion", modelHW10.getModel());

            Assertions.assertEquals(1.5, modelHW10.getCharacteristics().getCapacityEngine());

            Assertions.assertEquals("grey", modelHW10.getCharacteristics().getColourBody());

            Assertions.assertEquals("black", modelHW10.getCharacteristics().getColourInterior());

            Assertions.assertEquals(2008, modelHW10.getCharacteristics().getIssueYear());
            
        }
    }
}

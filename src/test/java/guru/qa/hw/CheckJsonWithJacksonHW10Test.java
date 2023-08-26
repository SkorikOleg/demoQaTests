package guru.qa.hw;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.model.ModelHW10;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


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

            assertThat(modelHW10.getBrand()).isEqualTo("toyota");

            assertThat(modelHW10.getModel()).isEqualTo("allion");

            assertThat(modelHW10.getCharacteristics().getCapacityEngine())
                    .isEqualTo(1.5);

            assertThat(modelHW10.getCharacteristics().getColourBody())
                    .isEqualTo("grey");

            assertThat(modelHW10.getCharacteristics().getColourInterior())
                    .isEqualTo("black");

            assertThat(modelHW10.getCharacteristics().getIssueYear())
                    .isEqualTo(2008);
        }
    }
}

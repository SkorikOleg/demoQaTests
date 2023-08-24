package guru.qa.model;

import com.google.gson.annotations.SerializedName;

public class GlossaryModelExample {
    /* {
         "title": "example glossary",
             "gloss_div": {
         "title": "S",
                 "flag": true
     }
     }*/


    private String title;

    @SerializedName("gloss_div")
    private GlossDivModel glossDiv;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GlossDivModel getGlossDiv() {
        return glossDiv;
    }

    public void setGlossDiv(GlossDivModel glossDiv) {
        this.glossDiv = glossDiv;
    }

    public static class GlossDivModel {
        private String title;
        private Boolean flag;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Boolean getFlag() {
            return flag;
        }

        public void setFlag(Boolean flag) {
            this.flag = flag;
        }
    }

}

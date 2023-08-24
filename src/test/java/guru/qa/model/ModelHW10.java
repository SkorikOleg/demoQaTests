package guru.qa.model;

public class ModelHW10 {
    /*{
        "brand": "toyota",
            "model": "allion",
            "characteristics": {
        "capacityEngine": 1.5,
                "colourBody": "grey",
                "colourInterior": "black",
                "issueYear": 2008
    }
    }*/
    private String brand;

    public String getBrand() {
        return brand;
    }


    public String getModel() {
        return model;
    }


    public CharacteristicsModel getCharacteristics() {
        return characteristics;
    }


    private String model;
    private CharacteristicsModel characteristics;

    public static class CharacteristicsModel {
        private double capacityEngine;
        private String colourBody;

        public double getCapacityEngine() {
            return capacityEngine;
        }


        public String getColourBody() {
            return colourBody;
        }


        public String getColourInterior() {
            return colourInterior;
        }


        public int getIssueYear() {
            return issueYear;
        }


        private String colourInterior;
        private int issueYear;

    }

}

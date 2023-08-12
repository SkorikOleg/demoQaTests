package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;


public class RandomUtils {

    static Faker faker = new Faker();

    public static String getRandomFirstName() {
        return faker.name().firstName();

    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {

        return faker.internet().emailAddress();
    }

    public static String getRandomPhoneNumber() {

        return faker.numerify("##########");
    }

    public static String getRandomDay() {
        int day = faker.number().numberBetween(01, 28);
        if (day < 10) {
            return "0" + day;
        } else {
            return Integer.toString(day);
        }
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return getRandomItemFromArray(months);
    }

    public static String getRandomYear() {
        int year = faker.number().numberBetween(1980, 2010);
        return Integer.toString(year);
    }

    public static String getRandomSubjects() {
        String[] subject = {"Hindi", "English", "Maths", "Physics", "Chemistry",
                "Biology", "Computer Science", "Commerce", "Accounting", "Economics",
                "Arts", "Social Studies", "History", "Civics"};
        return getRandomItemFromArray(subject);
    }

    public static String getRandomHobbies() {
        String[] hobby = {"Sports", "Reading", "Music"};

        return getRandomItemFromArray(hobby);
    }

    public static String getRandomPicture() {
        String[] picture = {"test.jpg", "test2.jpg", "test3.jpg"};

        return getRandomItemFromArray(picture);
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return getRandomItemFromArray(state);
    }

    public static String getRandomCity(String randomCity) {
        String[] cityNCR = {"Delhi", "Gurgaon", "Noida"};
        String[] cityUttar = {"Agra", "Lucknow", "Merrut"};
        String[] cityHaryana = {"Karnal", "Panipat"};
        String[] cityRajasthan = {"Jaipur", "Jaiselmer"};
        switch (randomCity) {
            case "NCR":
                return getRandomItemFromArray(cityNCR);
            case "Uttar Pradesh":
                return getRandomItemFromArray(cityUttar);
            case "Haryana":
                return getRandomItemFromArray(cityHaryana);
            case "Rajasthan":
                return getRandomItemFromArray(cityRajasthan);
        }

        return null;
    }


    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        //System.out.println(getRandomEmail());
        System.out.println(getRandomInt(11, 220));
        System.out.println(getRandomPhone());
        System.out.println(getRandomGender());
    }

    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    /*public static String getRandomEmail() {
        return getRandomString(5) + "@qa.guru";
        //return getRandomString(15) + "@" + getRandomString(3) + "." + getRandomString(3);
        /*return String.format("%s@%s.%s", getRandomString(11),
                getRandomString(3), getRandomString(3));
    }*/

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);

    }

    // +3 (123) 123 - 12 - 12
    public static String getRandomPhone() {

        return String.format("+%d (%d) %d - %d - %d", getRandomInt(7, 7), getRandomInt(100, 999),
                getRandomInt(100, 999), getRandomInt(10, 99), getRandomInt(10, 99));

    }

    public static String getRandomGender() { //метод откуда берутся данные
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);

    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1); //метод для входа данных

        return array[index];
    }

}

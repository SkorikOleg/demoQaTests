package com.demoqa.utils;

public class UserVariables {
    public static String
            userFirstName = RandomUtils.getRandomFirstName(),
            userLastName = RandomUtils.getRandomLastName(),
            userEmail = RandomUtils.getRandomEmail(),
            userGender = RandomUtils.getRandomGender(),
            userPhone = RandomUtils.getRandomPhoneNumber(),
            userDay = RandomUtils.getRandomDay(),
            userMonth = RandomUtils.getRandomMonth(),
            userYear = RandomUtils.getRandomYear(),
            userSubjects = RandomUtils.getRandomSubjects(),
            userHobby = RandomUtils.getRandomHobbies(),
            userPicture = RandomUtils.getRandomPicture(),
            userAdress = RandomUtils.getRandomAddress(),
            userState = RandomUtils.getRandomState(),
            userCity = RandomUtils.getRandomCity(userState);
}

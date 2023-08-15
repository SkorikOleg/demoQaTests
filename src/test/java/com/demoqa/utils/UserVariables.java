package com.demoqa.utils;

public class UserVariables {
    RandomUtils randomUtils = new RandomUtils();

    public String
            userFirstName = randomUtils.getRandomFirstName(),
            userLastName = randomUtils.getRandomLastName(),
            userEmail = randomUtils.getRandomEmail(),
            userGender = randomUtils.getRandomGender(),
            userPhone = randomUtils.getRandomPhoneNumber(),
            userDay = randomUtils.getRandomDay(),
            userMonth = randomUtils.getRandomMonth(),
            userYear = randomUtils.getRandomYear(),
            userSubjects = randomUtils.getRandomSubjects(),
            userHobby = randomUtils.getRandomHobbies(),
            userPicture = randomUtils.getRandomPicture(),
            userAdress = randomUtils.getRandomAddress(),
            userState = randomUtils.getRandomState(),
            userCity = randomUtils.getRandomCity(userState);
}

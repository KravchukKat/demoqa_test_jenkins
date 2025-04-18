package tests;

import static utils.RandomUtils.*;

public class TestData {
    public static String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            userEmail = getRandomUserEmail(),
            genter = getRandomGenter(),
            userNumber = getRandomNumberPhone(),
            day = getRandomDateOfBirthDay(),
            month = getRandomDateOfBirthMonth(),
            year = getRandomDateOfBirthYear(),
            subjects = getRandomSubjects(),
            hobbies = getRandomHobbies(),
            picture = "cat.jpg",
            address = getRandomAddress(),
            state = getRandomState(),
            city = getRandomCity(state);
}



package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static String getRandomUserEmail() {
        return faker.internet().safeEmailAddress();
    }

    public static String getRandomAddress() {
        return faker.address().streetAddress();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    // +3 (263) 253 - 66 - 12
    public static String getRandomNumberPhone() {
        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomDateOfBirthDay() {

        Date fakerDateOfBirth = faker.date().birthday();
        SimpleDateFormat formatDay = new SimpleDateFormat("dd", Locale.ENGLISH);
        String day = formatDay.format(fakerDateOfBirth);

        return day;

    }

    public static String getRandomDateOfBirthMonth() {

        Date fakerDateOfBirth = faker.date().birthday();
        SimpleDateFormat formatMonth = new SimpleDateFormat("MMMMM", Locale.ENGLISH);
        String month = formatMonth.format(fakerDateOfBirth);

        return month;

    }

    public static String getRandomDateOfBirthYear() {

        Date fakerDateOfBirth = faker.date().birthday();
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy", Locale.ENGLISH);
        String year = formatYear.format(fakerDateOfBirth);

        return year;

    }

    public static String getRandomGenter() {
        String[] genter = {"Male", "Female", "Other"};

        return faker.options().option("Male", "Female", "Other");
    }


    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getRandomSubjects() {
        String[] subjects = {"Maths", "Accounting", "Arts", "Social Studies"};

        return faker.options().option("Maths", "Accounting", "Arts", "Social Studies");
    }

    public static String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getRandomCity(String state) {

        if (state.equals("NCR")) {

            String[] city = {"Delhi", "Gurgaon", "Noida"};

            return faker.options().option("Delhi", "Gurgaon", "Noida");

        } else if (state.equals("Uttar Pradesh")) {

            String[] city = {"Agra", "Lucknow", "Merrut"};

            return faker.options().option("Agra", "Lucknow", "Merrut");

        } else if (state.equals("Haryana")) {

            String[] city = {"Karnal", "Panipat"};

            return faker.options().option("Karnal", "Panipat");

        } else {

            String[] city = {"Jaipur", "Jaiselmer"};

            return faker.options().option("Jaipur", "Jaiselmer");
        }
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

}


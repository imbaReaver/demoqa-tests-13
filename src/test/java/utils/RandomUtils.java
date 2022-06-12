package utils;

import java.util.Random;

public class RandomUtils {
    public static String randomSubject() {
        String[] subject = {"Accounting", "Maths", "Arts", "Hindi", "Chemistry", "Civics", "Maths", "Social Studies",
                "Chemistry", "Hindi"};
        String random = (subject[new Random().nextInt(subject.length)]);
        return random;
    }

    public static String randomHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};
        String random = (hobby[new Random().nextInt(hobby.length)]);
        return random;
    }

    public static String randomGender() {
        String[] gender = {"Other", "Male", "Female"};
        String random = (gender[new Random().nextInt(gender.length)]);
        return random;
    }

    public static String randomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        String random = (month[new Random().nextInt(month.length)]);
        return random;
    }
    public static String randomYear(int min, int max) {
        Random r = new Random();
        int random = (r.nextInt((max - min) + 1) + min);
        return String.valueOf(random);
    }
    public static String randomDay(int min, int max) {
        Random r = new Random();
        int random = (r.nextInt((max - min) + 1) + min);
        String s = String.valueOf(random);
        if (random < 10) {
            s = "0" + s;
        }
        return s;
    }
}

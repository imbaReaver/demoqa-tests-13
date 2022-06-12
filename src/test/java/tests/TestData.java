package tests;

import com.github.javafaker.Faker;
import utils.RandomUtils;

public class TestData {

    Faker faker = new Faker();
    String firstName = faker.address().firstName(),
            lastName = faker.address().lastName(),
            email = faker.internet().emailAddress(),
            phone = String.valueOf(faker.number().digits(10)),
            currentAddress = faker.yoda().quote(),
            birthDay = RandomUtils.randomDay(1, 27),
            birthMonth = RandomUtils.randomMonth(),
            birthYear = RandomUtils.randomYear(1950, 2020),
            subject = RandomUtils.randomSubject(),
            hobby = RandomUtils.randomHobby(),
            picture = "example.png",
            gender = RandomUtils.randomGender(),
            state = "Rajasthan",
            city = "Jaiselmer";

}

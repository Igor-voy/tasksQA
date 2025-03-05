package utils;

import com.github.javafaker.Faker;

public class RandomTextGenerator {
    public static String generator() {
        Faker faker = new Faker();
        return faker.name().fullName();
    }
}

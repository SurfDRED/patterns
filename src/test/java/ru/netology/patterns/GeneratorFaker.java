package ru.netology.patterns;

import com.github.javafaker.Faker;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

public class GeneratorFaker {

    private GeneratorFaker() {
    }

    private static Faker faker = new Faker(new Locale("ru"));
    private static String city = faker.address().cityName();
    private static String name = faker.name().fullName();
    private static String phone = faker.phoneNumber().phoneNumber();

    static String getCity() {
        return city;
    }

    static String getName() {
        return name;
    }

    static String getPhone() {
        return phone;
    }

    static String getPlanData(int plusDate) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        LocalDate localDate = LocalDate.now();
        Date dataPlan = Date.valueOf(localDate.plusDays(plusDate));
        String dataPlanTxt = dateFormat.format(dataPlan);
        return dataPlanTxt;
    }
}

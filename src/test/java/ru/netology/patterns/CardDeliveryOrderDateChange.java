package ru.netology.patterns;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class CardDeliveryOrderDateChange {

    @Test
    void shouldSubmitRequest() {
        //Тестируемая функциональность: заполнить форму
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue(GeneratorFaker.getCity());
        $(".menu").waitUntil(exist,5000).click();
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        String dataVst = GeneratorFaker.getPlanData(8);
        $("[data-test-id=date] input").setValue(dataVst);
        $("[data-test-id='name'] input").setValue(GeneratorFaker.getName());
        $("[data-test-id='phone'] input").setValue(GeneratorFaker.getPhone());
        $("[data-test-id='agreement']").click();
        $$("button").find(exactText("Запланировать")).click();
        $(byText("Успешно!")).waitUntil(visible,4000);
        $(byText("Успешно!")).shouldBe(visible);
        // Тестируемая функциональность: если заполнить форму повторно теми же данными за исключением "Даты встречи"
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        dataVst = GeneratorFaker.getPlanData(9);
        $("[data-test-id=date] input").setValue(dataVst);
        $$("button").find(exactText("Запланировать")).click();
        $("[data-test-id=replan-notification]").waitUntil(Condition.visible, 4000);
        $$("[class=button__text]").find(exactText("Перепланировать")).click();
        $(byText("Успешно!")).waitUntil(visible,4000);
        $(byText("Успешно!")).shouldBe(visible);
    }
}

package ru.netilogy.deliverycard;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class NegativeDeliveryCardTest extends PreparingForTests {

    @Test
    void NegativeDeliveryCardTestInvalidDate() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Нижний Новгород");
        String setDate = setDateDeliveryCard(0);
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов Иван");
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("+71234567890");
        $x("//label[@data-test-id='agreement']").click();
        $(".button").click();
        $x("//span[contains(text(),'дату невозможен')]")
                .shouldBe(visible, Duration.ofSeconds(8))
                .should(exactText("Заказ на выбранную дату невозможен"));
    }

    @Test
    void NegativeDeliveryCardTestIncorrectlySelectedCity() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Нижний");
        String setDate = setDateDeliveryCard(8);
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов Иван");
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("+71234567890");
        $x("//label[@data-test-id='agreement']").click();
        $(".button").click();
        $x("//span[contains(text(),'город недоступна')]")
                .shouldBe(visible, Duration.ofSeconds(8))
                .should(exactText("Доставка в выбранный город недоступна"));
    }

    @Test
    void NegativeDeliveryCardTestIncorrectlySelectedCity_2() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Moscow");
        String setDate = setDateDeliveryCard(8);
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов Иван");
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("+71234567890");
        $x("//label[@data-test-id='agreement']").click();
        $(".button").click();
        $x("//span[contains(text(),'город недоступна')]")
                .shouldBe(visible, Duration.ofSeconds(8))
                .should(exactText("Доставка в выбранный город недоступна"));
    }

    @Test
    void NegativeDeliveryCardTestCityNotSelected() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").clear();
        String setDate = setDateDeliveryCard(8);
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов Иван");
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("+71234567890");
        $x("//label[@data-test-id='agreement']").click();
        $(".button").click();
        $x("//span[contains(text(),'обязательно для')]")
                .shouldBe(visible, Duration.ofSeconds(8))
                .should(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void NegativeDeliveryCardTestNameNotSelected() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Нижний Новгород");
        String setDate = setDateDeliveryCard(8);
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").clear();
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("+71234567890");
        $x("//label[@data-test-id='agreement']").click();
        $(".button").click();
        $x("//span[contains(text(),'обязательно для')]")
                .shouldBe(visible, Duration.ofSeconds(8))
                .should(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void NegativeDeliveryCardTestNameIncorrect() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Нижний Новгород");
        String setDate = setDateDeliveryCard(8);
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Ivanov Ivan");
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("+71234567890");
        $x("//label[@data-test-id='agreement']").click();
        $(".button").click();
        $x("//span[contains(text(),'указаные неверно')]")
                .shouldBe(visible, Duration.ofSeconds(8))
                .should(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void NegativeDeliveryCardTestPhoneNumberIsSpecifiedIncorrectly() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Нижний Новгород");
        String setDate = setDateDeliveryCard(8);
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов Иван");
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("+71234567890123");
        $x("//label[@data-test-id='agreement']").click();
        $(".button").click();
        $x("//span[contains(text(),'Телефон указан неверно')]")
                .shouldBe(visible, Duration.ofSeconds(8))
                .should(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void NegativeDeliveryCardTestPhoneNumberIsSpecifiedIncorrectly_2() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Нижний Новгород");
        String setDate = setDateDeliveryCard(8);
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов Иван");
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("89123456789");
        $x("//label[@data-test-id='agreement']").click();
        $(".button").click();
        $x("//span[contains(text(),'Телефон указан неверно')]")
                .shouldBe(visible, Duration.ofSeconds(8))
                .should(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void NegativeDeliveryCardTestCheckBoxIsNotPressed() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Нижний Новгород");
        String setDate = setDateDeliveryCard(3);
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов Иван");
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("+71234567890");
        $(".button").click();
        $x("//label[contains(@class, 'checkbox')]")
                .shouldBe(visible)
                .shouldHave(cssValue("color", "rgba(255, 92, 92, 1)")
                        , cssClass("input_invalid"));
    }

}

package ru.netilogy.deliverycard;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ComplexElementsDeliveryCardTest extends PreparingForTests {

    @Test
    void shouldCityNizhniyNovgorod() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Ни");
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(visible);
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]//span[contains(text(), 'Нижний Новгород')]").click();
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(hidden);
        String setDate = setDateDeliveryCard(3, "dd.MM.yyyy");
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов Иван");
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("+71234567890");
        $x("//label[@data-test-id='agreement']").click();
        $(".button").click();
        $x("//div[@class='notification__title']").shouldHave(text("Успешно!"),
                Duration.ofSeconds(12)).shouldBe(visible);
        $x("//div[@class='notification__content']")
                .shouldHave(text("Встреча успешно забронирована на " + setDate)
                        , Duration.ofSeconds(12)).shouldBe(visible);
    }

    @Test
    void shouldCityKaliningrad() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("ка");
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(visible);
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]//span[contains(text(), 'Калининград')]").click();
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(hidden);
        String setDate = setDateDeliveryCard(13, "dd.MM.yyyy");
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов Иван");
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("+71234567890");
        $x("//label[@data-test-id='agreement']").click();
        $(".button").click();
        $x("//div[@class='notification__title']").shouldHave(text("Успешно!"),
                Duration.ofSeconds(12)).shouldBe(visible);
        $x("//div[@class='notification__content']")
                .shouldHave(text("Встреча успешно забронирована на " + setDate)
                        , Duration.ofSeconds(12)).shouldBe(visible);
    }

    @Test
    void shouldCityChelyabinsk() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("ЧЕ");
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(visible);
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]//span[contains(text(), 'Челябинск')]").click();
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(hidden);
        String setDate = setDateDeliveryCard(100, "dd.MM.yyyy");
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов Иван");
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("+71234567890");
        $x("//label[@data-test-id='agreement']").click();
        $(".button").click();
        $x("//div[@class='notification__title']").shouldHave(text("Успешно!"),
                Duration.ofSeconds(12)).shouldBe(visible);
        $x("//div[@class='notification__content']")
                .shouldHave(text("Встреча успешно забронирована на " + setDate)
                        , Duration.ofSeconds(12)).shouldBe(visible);
    }
}

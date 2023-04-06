package ru.netilogy.deliverycard;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryCardTest extends PreparingForTests {

    @Test
    void testDeliveryCardPositive() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Нижний Новгород");
        String setDate = setDateDeliveryCard(3,"dd.MM.yyyy");
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
    void shouldDoubleSurnameCityMoscowFourDays() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Москва");
        String setDate = setDateDeliveryCard(4,"dd.MM.yyyy");
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов-Петров Иван Иванович");
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
    void shouldDoubleNameCitySaint_PetersburgInAWeek() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Санкт-Петербург");
        String setDate = setDateDeliveryCard(7,"dd.MM.yyyy");
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов Иван-Ииигорь Иванович");
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
    void shouldInitialsCityVladivostokInAMonth() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Владивосток");
        String setDate = setDateDeliveryCard(30,"dd.MM.yyyy");
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Лю Ив Нунь");
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
    void shouldInitialsCityKazanInAYear() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Казань");
        String setDate = setDateDeliveryCard(370,"dd.MM.yyyy");
        $x("//span[@data-test-id='date']//input[@placeholder='Дата встречи']").doubleClick().sendKeys(setDate);
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иван-Иван Иванович-Иванович Иванов");
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

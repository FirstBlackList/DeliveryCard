package ru.netilogy.deliverycard;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ComplexElementsDeliveryCardTest extends PreparingForTests {

    @Test
    void HappyTestDeliveryCardCityMenu_1() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Ни");
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(visible);
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]//span[contains(text(), 'Нижний Новгород')]").click();
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(hidden);
        String setDate = setDateDeliveryCard(3);
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
    void HappyTestDeliveryCardCityMenu_2() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("ка");
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(visible);
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]//span[contains(text(), 'Калининград')]").click();
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(hidden);
        String setDate = setDateDeliveryCard(13);
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
    void HappyTestDeliveryCardCityMenu_3() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("ЧЕ");
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(visible);
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]//span[contains(text(), 'Челябинск')]").click();
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(hidden);
        String setDate = setDateDeliveryCard(100);
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
    void HappyTestDeliveryCardCalendar__6_06_2023() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Нижний Новгород");
        $x("//span[contains(@class,'icon_name_calendar')]").click();
        while (!$x("//div[contains(@class,'calendar__name')]").getText().contains("Июнь 2023")) {
            $x("//div[contains(@class,'arrow_direction_right')][@data-step='1']").click();
        }
        int countDay = $$x("//table[@class='calendar__layout']").size();
        for (int i = 0; i < countDay; i++) {
            String text = $$x("//td[text()='6']")
                    .get(i).getText();
            if (text.equalsIgnoreCase("6")) {
                $$x("//td[text()='6']").get(i).click();
            }
        }
        SelenideElement day = $x("//td[@data-day='1685998800000']");
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов Иван");
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("+71234567890");
        $x("//label[@data-test-id='agreement']").click();
        $(".button").click();
        $x("//div[@class='notification__title']").shouldHave(text("Успешно!"),
                Duration.ofSeconds(12)).shouldBe(visible);
        $x("//div[@class='notification__content']")
                .shouldHave(text("Встреча успешно забронирована на " + day.getText())
                        , Duration.ofSeconds(12)).shouldBe(visible);
    }

}

package ru.netilogy.deliverycard;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CalendarWidgetTest extends PreparingForTests {

    public static String choosingADayFromADate(String currentDate) {
        return currentDate.substring(0, 1).contains("0")
                ? currentDate.substring(1, 2)
                : currentDate.substring(0, 2);
    }

    @Test
    void shouldCalendarValuePlusWeekFromTheCurrentDate() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Ни");
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(visible);
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]//span[contains(text(), 'Нижний Новгород')]").click();
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(hidden);
        $(".input__icon").click();

        String setDate = setDateDeliveryCard(07, "dd.MM.yyyy");
        String calendarDay = choosingADayFromADate(setDate);
        int addDay = 7;

        if (LocalDate.now().plusDays(addDay).getMonthValue() > LocalDate.now().getMonthValue()) {
            $("[data-step='1'].calendar__arrow_direction_right ").should(visible).click();
            $$(".calendar__day").findBy(text(calendarDay)).should(visible).click();
        } else {
            $$(".calendar__day").findBy(text(calendarDay)).should(visible).click();
        }
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов Иван");
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("+71234567890");
        $x("//label[@data-test-id='agreement']").click();
        $(".button").click();
        $("[data-test-id = notification]").shouldHave(text("Успешно!"),
                Duration.ofSeconds(20)).shouldBe(visible);
        $(".notification__content").shouldHave(text("Встреча успешно забронирована на " + setDate),
                Duration.ofSeconds(20)).shouldBe(visible);
    }

    @Test
    void shouldCalendarValuePlusWeekFromTheCurrentSelectionDate() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Ни");
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(visible);
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]//span[contains(text(), 'Нижний Новгород')]").click();
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(hidden);
        $(".input__icon").click();

        String setDate = setDateDeliveryCard(10, "dd.MM.yyyy");
        String calendarDay = choosingADayFromADate(setDate);
        int addDay = 10;

        if (LocalDate.now().plusDays(addDay).getMonthValue() > LocalDate.now().getMonthValue()) {
            $("[data-step='1'].calendar__arrow_direction_right ").should(visible).click();
            $$(".calendar__day").findBy(text(calendarDay)).should(visible).click();
        } else {
            $$(".calendar__day").findBy(text(calendarDay)).should(visible).click();
        }
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов Иван");
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("+71234567890");
        $x("//label[@data-test-id='agreement']").click();
        $(".button").click();
        $("[data-test-id = notification]").shouldHave(text("Успешно!"),
                Duration.ofSeconds(20)).shouldBe(visible);
        $(".notification__content").shouldHave(text("Встреча успешно забронирована на " + setDate),
                Duration.ofSeconds(20)).shouldBe(visible);
    }

    @Test
    void shouldCalendarValuePlusMonthFromTheCurrentDate() {

        $x("//span[@data-test-id='city']//input[@placeholder='Город']").setValue("Ни");
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(visible);
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]//span[contains(text(), 'Нижний Новгород')]").click();
        $x("//div[@class='popup__inner']//div[contains(@class,'menu_size_m')]").should(hidden);
        $(".input__icon").click();

        String setDate = setDateDeliveryCard(30, "dd.MM.yyyy");
        String calendarDay = choosingADayFromADate(setDate);
        int addDay = 30;

        if (LocalDate.now().plusDays(addDay).getMonthValue() > LocalDate.now().getMonthValue()) {
            $("[data-step='1'].calendar__arrow_direction_right ").should(visible).click();
            $$(".calendar__day").findBy(text(calendarDay)).should(visible).click();
        } else {
            $$(".calendar__day").findBy(text(calendarDay)).should(visible).click();
        }
        $x("//span[@data-test-id='name']//input[@name='name']").setValue("Иванов Иван");
        $x("//span[@data-test-id='phone']//input[@name='phone']").setValue("+71234567890");
        $x("//label[@data-test-id='agreement']").click();
        $(".button").click();
        $("[data-test-id = notification]").shouldHave(text("Успешно!"),
                Duration.ofSeconds(20)).shouldBe(visible);
        $(".notification__content").shouldHave(text("Встреча успешно забронирована на " + setDate),
                Duration.ofSeconds(20)).shouldBe(visible);
    }
}

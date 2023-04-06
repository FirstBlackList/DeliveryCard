package ru.netilogy.deliverycard;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Keys;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.codeborne.selenide.Selenide.*;

public class PreparingForTests {
    public static void clearDate() {
        SelenideElement date = $x("//input[@placeholder='Дата встречи']");
        while (date.val().length() != 0) {
            date.sendKeys(Keys.BACK_SPACE);
        }
    }

    public static String setDateDeliveryCard(int setDay) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, setDay);
        if (setDay == 3) {
            return dateFormat.format(calendar.getTime());
        } else if (setDay > 3) {
            clearDate();
            return dateFormat.format(calendar.getTime());
        } else {
            clearDate();
            return dateFormat.format(calendar.getTime());
        }
    }

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

}

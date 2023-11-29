package ru.netology.test;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static java.util.Calendar.DAY_OF_YEAR;
import static java.util.Calendar.YEAR;

public class CardDeliverySelenideTest {


    Calendar cal = new Calendar.Builder().setCalendarType("japanese")
            .setFields(YEAR, 1, DAY_OF_YEAR, 1).build();

    @Test
    void shouldSubmitForm() throws InterruptedException {
        open("http://localhost:9999");

        $("[data-test-id=city] input").setValue("Новосибирск");
        $("[data-test-id=date] input").sendKeys(cal.getCalendarType());
        $("[data-test-id=name] input").setValue("Эм Ольга");
        $("[data-test-id=phone] input").setValue("+79140000015");
        $("[data-test-id=agreement]").click();
        $(byText("Забронировать")).click();
        $(withText("Встреча успешно забронирована на")).shouldBe((visible), Duration.ofSeconds(15));
        Thread.sleep(5000);
    }
}

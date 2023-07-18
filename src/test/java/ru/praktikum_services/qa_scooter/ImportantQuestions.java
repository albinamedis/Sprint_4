package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

        @RunWith(Parameterized.class)

        public class ImportantQuestions {
            private WebDriver webDriver;
            private final String question;
            private final String answer;
            private final boolean isVisible;

        public ImportantQuestions (String question, String answer, boolean isVisible) {
            this.question = question;
            this.answer = answer;
            this.isVisible = isVisible;
        }

        @Parameterized.Parameters
        public static Object[][] getAnswer() {
            return new Object[][] {
                    { "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", true},
                    { "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", true},
                    { "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", true},
                    { "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", true},
                    { "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", true},
                    { "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", true},
                    { "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", true},
                    { "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", true},
            };
        }


        @Before
        public void setUp() {
             webDriver = new ChromeDriver();
            //webDriver = new FirefoxDriver();
            webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }

        @Test

        public void OpenQuestions () {
            MainObject mainObject = new MainObject(webDriver);
            mainObject.open();
            mainObject.scrollitQustions();
            mainObject.clickQuestion(question);
            mainObject.proverkaTextAnswer(question,answer,isVisible);
        }

        @After
        public void tearDown() {
            webDriver.quit();
        }
}


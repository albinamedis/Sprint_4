package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

        @RunWith(Parameterized.class)
        public class OrderSamokat {
            private WebDriver webDriver;
            private final String name;
            private final String surname;
            private final String address;
            private final String phone;
            private final String comments;

            public OrderSamokat(String name, String surname, String address, String phone, String comments) {
                this.name = name;
                this.surname = surname;
                this.address = address;
                this.phone = phone;
                this.comments = comments;
            }

            @Parameterized.Parameters
            public static Object[][] inputUser() {
                return new Object[][]{
                        {"Альбина", "Горелова", "г. Москва, ул. Маяковская д.1 кв.1", "79999999999", "Оставьте, пожалуйста, заказ у двери"},
                        {"Петя", "Иванов", "г. Пенза", "79019999911", ""},
                };
            }


            @Before
            public void setUp() {
                webDriver = new ChromeDriver();
                //webDriver = new FirefoxDriver();

            }

            @Test
            public void oformlenieOrderHeader() {

                AboutUserScooter aboutUserScooter = new AboutUserScooter(webDriver);
                aboutUserScooter.open();
                aboutUserScooter.clickOrderHeader();

                // Для кого самокат
                aboutUserScooter.inputAboutUserScooter(name, surname, address, phone);
                aboutUserScooter.clickNext();

                // Про аренду
                AboutRentScooter aboutRentScooter = new AboutRentScooter(webDriver);
                aboutRentScooter.inputAboutRentScooter(comments);
                aboutRentScooter.clickOrderButton();

                OrderDone orderDone = new OrderDone(webDriver);
                Assert.assertTrue("Не открылось модальное окно 'Хотите оформить заказ?'", orderDone.openPopupYesNo());
                orderDone.clickPopupYes();
                Assert.assertTrue("Не открылось окно успешного оформления заказа 'Заказ оформлен'", orderDone.openPopupDone());

            }

            @Test
            public void oformlenieOrderDown() {
                AboutUserScooter aboutUserScooter = new AboutUserScooter(webDriver);
                aboutUserScooter.open();
                aboutUserScooter.scrollitQustions();
                aboutUserScooter.clickOrderDown();

                // Для кого самокат
                aboutUserScooter.inputAboutUserScooter(name, surname, address, phone);
                aboutUserScooter.clickNext();

                // Про аренду
                AboutRentScooter aboutRentScooter = new AboutRentScooter(webDriver);
                aboutRentScooter.inputAboutRentScooter(comments);
                aboutRentScooter.clickOrderButton();

                OrderDone orderDone = new OrderDone(webDriver);
                Assert.assertTrue("Не открылось модальное окно 'Хотите оформить заказ?'", orderDone.openPopupYesNo());
                orderDone.clickPopupYes();
                Assert.assertTrue("Не открылось окно успешного оформления заказа 'Заказ оформлен'", orderDone.openPopupDone());
            }

            @After
            public void tearDown() {
                webDriver.quit();
            }
        }






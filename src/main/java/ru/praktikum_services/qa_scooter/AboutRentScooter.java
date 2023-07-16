package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutRentScooter {

    private final WebDriver webDriver;
    // Открыть календарь
    private By openKalendar = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Выбрать дату в календаре
    private By clickDateKalendar  = By.xpath(".//div[@aria-label='Choose воскресенье, 30-е июля 2023 г.']");
    // Открыть варианты периода аренды
    private By  openPriodRent = By.className("Dropdown-placeholder");
    // Выбрать срок аренды
    private By clickPriodRent = By.xpath(".//div[text()='семеро суток']");
    // Выбрать цвет самоката
    private By typeColor = By.id("black");
    // Ввести комментарий
    private By inputComments = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Нажать Заказать
    private By clickOrder = By.xpath(".//div[@class='Order_Content__bmtHS']/div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");


    public AboutRentScooter(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void inputAboutRentScooter(String comments) {
        webDriver.findElement(openKalendar).click();
        webDriver.findElement(clickDateKalendar).click();
        webDriver.findElement(openPriodRent).click();
        webDriver.findElement(clickPriodRent).click();
        webDriver.findElement(typeColor).click();
        webDriver.findElement(inputComments).sendKeys(comments);
    }

    public void clickOrderButton() {
        webDriver.findElement(clickOrder).click();
    }
}

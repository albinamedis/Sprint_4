package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderDone {

    private final WebDriver webDriver;
    // Открыт попап для подтвеждения заказа
    private By popupYesNo = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[text()='Хотите оформить заказ?']");
    // Подтверрдить оформление заказа "да"
    private By clickPopupYes = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");
    // Открыт попап успешного оформления заказа
    private By popupDone = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[text()='Заказ оформлен']");


    public OrderDone(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean openPopupYesNo() {
        return webDriver.findElements(popupYesNo).size() > 0;
    }

    public void clickPopupYes() {
        webDriver.findElement(clickPopupYes).click();
    }
    public boolean openPopupDone() {
        return webDriver.findElements(popupDone).size() > 0;
    }
}

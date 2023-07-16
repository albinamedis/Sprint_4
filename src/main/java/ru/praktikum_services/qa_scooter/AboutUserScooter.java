package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AboutUserScooter {

    private final WebDriver webDriver;
    private String url = "https://qa-scooter.praktikum-services.ru/";
    // Заказать через кнопку в заголовке
    private By orderHeaderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    // Заказать через кнопку внизу страницы
    private By orderHeaderDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g']");
    // скроллить вниз до кнопки Заказать
    private By scrollQuestions = By.xpath(".//div[@class='Home_SubHeader__zwi_E']");
    // Поле Имя
    private By inputName = By.xpath(".//input[@placeholder='* Имя']");
    // Поле Фамилия
    private By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле Адрес
    private By inputAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Раскрыть список станций метро
    private By openListMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    // Выбрать станцию метро
    private By clickMetro = By.xpath(".//li[@data-value='4']");
    // Поле Телефон
    private By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка Далее
    private By clickNextButton = By.xpath(".//button[text()='Далее']");

    public AboutUserScooter(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get(url);
    }
    public void clickOrderHeader() {
        webDriver.findElement(orderHeaderButton).click();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void scrollitQustions(){
        WebElement element = webDriver.findElement(scrollQuestions);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickOrderDown() {
        webDriver.findElement(orderHeaderButton).click();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void inputAboutUserScooter(String name, String surname, String address, String phone) {
        webDriver.findElement(inputName).sendKeys(name);
        webDriver.findElement(inputSurname).sendKeys(surname);
        webDriver.findElement(inputAdress).sendKeys(address);
        webDriver.findElement(openListMetro).click();
        webDriver.findElement(clickMetro).click();
        webDriver.findElement(inputPhone).sendKeys(phone);
    }

    public void clickNext() {
        webDriver.findElement(clickNextButton).click();
    }
}

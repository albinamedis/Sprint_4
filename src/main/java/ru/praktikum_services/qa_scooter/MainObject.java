package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class MainObject {
    private final WebDriver webDriver;
    // Открыть сайт
    private String url = "https://qa-scooter.praktikum-services.ru/";
    //Скроллить до списка вопросов
    private By scrollQuestions = org.openqa.selenium.By.xpath(".//div[(@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном')]");


    public MainObject(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get(url);
    }

    public void scrollitQustions(){
        WebElement element = webDriver.findElement(scrollQuestions);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickQuestion (String question) {
        webDriver.findElement(By.xpath(".//div[text()='"+question+"\']")).click();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void proverkaTextAnswer (String question, String answer, boolean isVisible) {
        List<WebElement> elements = webDriver.findElements(By.xpath(".//p[text()='"+answer+"\']"));
        assertEquals("Не найден вопрос \""+question+"\" с ответом \""+answer+"\"",isVisible, elements.size() != 0);
    }
}

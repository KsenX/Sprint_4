package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор для кнопки о согласии с куки
    private By cookieAgree = By.id("rcc-confirm-button");

    //НЕПараметризованный локатор для FAQ-вопроса
    private By questionFAQ2 = By.id("accordion__heading-2");

    //НЕПараметризованный локатор для FAQ-ответа
    private By answerFAQ2 = By.xpath(".//*[@id='accordion__panel-2']/p");

    //НЕПараметризованный локатор для FAQ-вопроса
    private By questionFAQ3 = By.id("accordion__heading-3");

    //НЕПараметризованный локатор для FAQ-ответа
    private By answerFAQ3 = By.id("accordion__panel-3");

    //Локатор для кнопки "Заказать" в правом верхнем углу экрана
    private By orderButtonUpperRight = By.xpath(".//*[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    //Локатор для кнопки "Заказать" внизу экрана
    private By orderButtonBottom = By.xpath(".//*[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    //Функция нажать FAQ
    public void clickQuestionFAQ2() {
        driver.findElement(questionFAQ2).click();
    }

    //Функция проверить содержимое FAQ
    public String getAnswerFAQ2() {
        return driver.findElement(answerFAQ2).getText();
    }

    //Функция нажать FAQ
    public void clickQuestionFAQ3() {
        driver.findElement(questionFAQ3).click();
    }

    //Функция проверить содержимое FAQ
    public String getAnswerFAQ3() {
        return driver.findElement(answerFAQ3).getText();
    }

    //Функция согласиться с куки
    public void setCookieAgree() {
        driver.findElement(cookieAgree).click();
    }

    //Функция заказать - правый верхний угол
    public void setOrderButtonUpperRight() {
        driver.findElement(orderButtonUpperRight).click();
    }

    //Функция заказать - внизу экрана
    public void setOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }

}

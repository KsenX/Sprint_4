package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор для кнопки о согласии с куки
    private By cookieAgree = By.id("rcc-confirm-button");

    //Параметризованный локатор для FAQ-вопроса
    private String questionFAQ = "accordion__heading-";

    //Параметризованный локатор для FAQ-ответа
    private String answerFAQ = "accordion__panel-";

//    //Локатор для кнопки "Заказать" в правом верхнем углу экрана
//    private By orderButtonUpperRight = By.xpath(".//*[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
//
//    //Локатор для кнопки "Заказать" внизу экрана
//    private By orderButtonBottom = By.xpath(".//*[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    //Функция нажать FAQ
    public void clickQuestionFAQ(int questionNo) {
        WebElement element = driver.findElement(By.id(questionFAQ + questionNo));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id(questionFAQ + questionNo)).click();
    }

    //Функция проверить содержимое FAQ
    public String getAnswerFAQ(int answerNo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answerFAQ + answerNo)));
        return driver.findElement(By.id(answerFAQ + answerNo)).getText();
    }

    //Функция согласиться с куки
    public void setCookieAgree() {
        driver.findElement(cookieAgree).click();
    }

    //Функция заказать - правый верхний угол
//    public void setOrderButton() {
//        driver.findElement(orderButtonUpperRight).click();
//    }

    //параметризованная функция заказать - нажмем на кнопку по xpath, который передадим из теста
    public void setOrderButton(String Button) {
        driver.findElement(By.xpath(Button)).click();
    }
    //Функция заказать - внизу экрана
//    public void setOrderButtonBottom() {
//        driver.findElement(orderButtonBottom).click();
//    }

}

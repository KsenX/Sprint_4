package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderStepTwo {
    private WebDriver driver;

    public OrderStepTwo(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор дата
    private By chooseDate = By.xpath(".//*[@placeholder='* Когда привезти самокат']");

    //Локатор срок аренды
    private By chooseRentalDuration = By.className("Dropdown-arrow");

    //Локатор выбор цвета
    private By chooseColor = By.className("Checkbox_Label__3wxSf");

    //Локатор комментарий
    private By addComment = By.xpath(".//*[@placeholder='Комментарий для курьера']");

    //Локатор кнопка заказать
    private By orderButton = By.xpath(".//*[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //Функция выбор даты
    public void setDate(String date) {
        driver.findElement(chooseDate).sendKeys(date + Keys.ENTER);
    }

    //Функция выбор срока аренды
    public void setRentalDuration(String duration) {
        driver.findElement(chooseRentalDuration).click();
        driver.findElement(By.xpath(".//*[text()='сутки']")).click();
    }

    //Функция выбор цвета
    public void setColor(String color) {
        driver.findElement(chooseColor).click();
    }

    //Функция ввод комментария
    public void setComment(String comment) {
        driver.findElement(addComment).sendKeys(comment);
    }

    //Функция нажать кнопку заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    //Шаг - завершить заказ
    public void createOrderStepTwo(String date, String duration, String color, String comment) {
        setDate(date);
        setRentalDuration(duration);
        setColor(color);
        setComment(comment);
        clickOrderButton();
    }

}

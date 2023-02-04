package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmation {
    private WebDriver driver;
    public OrderConfirmation(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор текста подтверждения заказа
    private By orderConfirmationText = By.xpath(".//*[@class='Order_Text__2broi']");


    //Функция проверить, что заказ создан и есть номер
    public String checkOrderCreatedAndHasNumber() {
     return driver.findElement(orderConfirmationText).getText();
    }

}

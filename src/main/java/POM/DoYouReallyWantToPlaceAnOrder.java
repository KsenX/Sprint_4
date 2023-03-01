package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DoYouReallyWantToPlaceAnOrder {
    private WebDriver driver;

    public DoYouReallyWantToPlaceAnOrder(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор кнопки да
    private By yesButton = By.xpath(".//*[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    //Функция нажать кнопку да
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

}

package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderStepOne {
    private WebDriver driver;

    //Локатор имя
    public OrderStepOne(WebDriver driver) {
        this.driver = driver;
    }

    private By nameInput = By.xpath(".//*[@placeholder='* Имя']");

    //Локатор фамилия
    private By surnameInput = By.xpath(".//*[@placeholder='* Фамилия']");

    //Локатор адрес
    private By addressInput = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");

    //Локатор выбор станции метро
    private By subwayInput = By.xpath(".//*[@placeholder='* Станция метро']");

    //Локатор ввод номера телефона
    private By phoneInput = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");

    //Локатор кнопка далее
    private By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    //Функция ввод имени
    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    //Функция ввод фамилии
    public void setSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
    }

    //Функция ввод адреса
    public void setAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void setSubway(String subway) {
        driver.findElement(subwayInput).clear();
        driver.findElement(subwayInput).sendKeys(subway + Keys.ARROW_DOWN + Keys.ENTER);

    }

    //Функция ввод номера телефона
    public void setPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    //Функция нажать кнопку далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    //Шаг - добавить данные заказа и нажать далее
    public void createOrderStepOne(String name, String surname, String address, String subway, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setSubway(subway);
        setPhone(phone);
        clickNextButton();
    }

}

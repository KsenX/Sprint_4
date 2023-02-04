import POM.*;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderSmokeTest {
    private WebDriver driver;

    @Test
    public void orderUpperRightButton() {
//        // драйвер для браузера Chrome
//
         driver = new ChromeDriver();

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

//стартовая страница
        MainPage mainPage = new MainPage(driver);
        mainPage.setCookieAgree();
//создаем заказ - правая верхняя кнопка
        mainPage.setOrderButtonUpperRight();


        // создай объект класса главной страницы приложения
        OrderStep1 orderStep1 = new OrderStep1(driver);
        // дождись загрузки данных профиля на главной странице
        orderStep1.createOrderStep1("имя", "фамилия", "адрес", "Локомотив","+79111234567");

        OrderStep2 orderStep2 = new OrderStep2(driver);

        orderStep2.createOrderStep2("05.02.2023","сутки", "чёрный жемчуг", "комментарий");

        DoYouReallyWantToPlaceAnOrder doYouReallyWantToPlaceAnOrder = new DoYouReallyWantToPlaceAnOrder(driver);
        doYouReallyWantToPlaceAnOrder.clickYesButton();

        OrderConfirmation orderConfirmation=new OrderConfirmation(driver);
        assert (orderConfirmation.checkOrderCreatedAndHasNumber().length()>0);


    }
    @Test
    public void orderBottomButton() {
//        // драйвер для браузера Chrome
//
         driver = new ChromeDriver();

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

//стартовая страница
        MainPage mainPage = new MainPage(driver);
        mainPage.setCookieAgree();
//создаем заказ - правая верхняя кнопка
        mainPage.setOrderButtonBottom();


        // создай объект класса главной страницы приложения
        OrderStep1 orderStep1 = new OrderStep1(driver);
        // дождись загрузки данных профиля на главной странице
        orderStep1.createOrderStep1("имя", "фамилия", "адрес", "Локомотив","+79111234567");

        OrderStep2 orderStep2 = new OrderStep2(driver);

        orderStep2.createOrderStep2("05.02.2023","сутки", "чёрный жемчуг", "комментарий");

        DoYouReallyWantToPlaceAnOrder doYouReallyWantToPlaceAnOrder = new DoYouReallyWantToPlaceAnOrder(driver);
        doYouReallyWantToPlaceAnOrder.clickYesButton();

        OrderConfirmation orderConfirmation=new OrderConfirmation(driver);
        assert (orderConfirmation.checkOrderCreatedAndHasNumber().length()>0);


    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

}

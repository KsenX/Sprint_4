import POM.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class OrderSmokeTest {
    private final String buttonLocator;


    public OrderSmokeTest(String buttonLocator) {
        this.buttonLocator = buttonLocator;
    }

    private WebDriver driver;

    @Before
    public void warmup() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
    }

    @Parameterized.Parameters
    public static Object[][] buttonLocator() {
        return new Object[][]{
                {".//*[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']"}, //правая верхняя кнопка
                {".//*[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']"},     //нижняя кнопка

        };

    }

    @Test
    public void orderSmokeTestPositive() {


        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

//стартовая страница
        MainPage mainPage = new MainPage(driver);
        mainPage.setCookieAgree();
//создаем заказ - правая верхняя кнопка
        mainPage.setOrderButton(buttonLocator);


        // создай объект класса главной страницы приложения
        OrderStepOne orderStepOne = new OrderStepOne(driver);
        // дождись загрузки данных профиля на главной странице
        orderStepOne.createOrderStepOne("имя", "фамилия", "адрес", "Локомотив", "+79111234567");

        OrderStepTwo orderStepTwo = new OrderStepTwo(driver);

        orderStepTwo.createOrderStepTwo("05.02.2023", "сутки", "чёрный жемчуг", "комментарий");

        DoYouReallyWantToPlaceAnOrder doYouReallyWantToPlaceAnOrder = new DoYouReallyWantToPlaceAnOrder(driver);
        doYouReallyWantToPlaceAnOrder.clickYesButton();

        OrderConfirmation orderConfirmation = new OrderConfirmation(driver);
        assert (orderConfirmation.checkOrderCreatedAndHasNumber().length() > 0);


    }

//    @Test
//    public void orderBottomButton() {
//        // переход на страницу тестового приложения
//        driver.get("https://qa-scooter.praktikum-services.ru/");
//
////стартовая страница
//        MainPage mainPage = new MainPage(driver);
//        mainPage.setCookieAgree();
////создаем заказ - нижняя кнопка
//        mainPage.setOrderButtonBottom();
//
//
//        // создай объект класса главной страницы приложения
//        OrderStepOne orderStepOne = new OrderStepOne(driver);
//        // дождись загрузки данных профиля на главной странице
//        orderStepOne.createOrderStepOne("имя", "фамилия", "адрес", "Локомотив", "+79111234567");
//
//        OrderStepTwo orderStepTwo = new OrderStepTwo(driver);
//
//        orderStepTwo.createOrderStepTwo("05.02.2023", "сутки", "чёрный жемчуг", "комментарий");
//
//        DoYouReallyWantToPlaceAnOrder doYouReallyWantToPlaceAnOrder = new DoYouReallyWantToPlaceAnOrder(driver);
//        doYouReallyWantToPlaceAnOrder.clickYesButton();
//
//        OrderConfirmation orderConfirmation = new OrderConfirmation(driver);
//        assert (orderConfirmation.checkOrderCreatedAndHasNumber().length() > 0);
//
//
//    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

}

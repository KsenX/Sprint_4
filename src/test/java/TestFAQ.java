import POM.MainPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TestFAQ {

    private WebDriver driver;

    @Test
    public void testFAQ2() {
        // драйвер для браузера Chrome

         driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

//стартовая страница
        MainPage mainPage = new MainPage(driver);
        mainPage.setCookieAgree();
        mainPage.clickQuestionFAQ2();
        assertTrue (mainPage.getAnswerFAQ2().startsWith("Допустим"));



    }
    @Test
    public void testFAQ3() {
        // драйвер для браузера Chrome

        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

//стартовая страница
        MainPage mainPage = new MainPage(driver);
        mainPage.setCookieAgree();
        mainPage.clickQuestionFAQ3();
        assertTrue (mainPage.getAnswerFAQ3().startsWith("Только"));



    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}

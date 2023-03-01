import POM.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestFAQ {
    private final int questionNo;
    private final int answerNo;
    private final String expected;

    public TestFAQ(int questionNo, int answerNo, String expected) {
        this.answerNo = answerNo;
        this.questionNo = questionNo;
        this.expected = expected;
    }

    private WebDriver driver;

    @Before
    public void warmup() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();

    }


    @Parameterized.Parameters
    public static Object[][] getAnswer() {
        return new Object[][]{
                {0, 0, "Сутки"},
                {1, 1, "Пока"},
                {2, 2, "Допустим"},
                {3, 3, "Только"},
                {4, 4, "Пока"},
                {5, 5, "Самокат"},
                {6, 6, "Да,"},
                {7, 7, "Да,"},
        };

    }

    @Test
    public void testFAQ2() {
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

//стартовая страница
        MainPage mainPage = new MainPage(driver);
        mainPage.setCookieAgree();

        mainPage.clickQuestionFAQ(questionNo);
        assertTrue(mainPage.getAnswerFAQ(answerNo).startsWith(expected));


    }


    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}

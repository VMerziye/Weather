import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VMerziyeHomeWork {

//    TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide
// и что title этой страницы OpenWeatherMap API guide - OpenWeatherMap


    @Test
    public void testATagText_WhenClickGuide() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer R13\\Downloads\\Chromdriver\\"
                + "chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String menuGuide = "Guide";
        String expectedUrl = "https://openweathermap.org/guide";
        String expectedResult2 = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchMenuGuide = driver.findElement(
                By.xpath("//nav/ul//div/ul/li/a[text() = 'Guide']")
        );
        searchMenuGuide.click();
        Thread.sleep(2000);


        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

        String actualResult2 = driver.getTitle();

        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();

    }

//    TC_11_02
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//3.  Подтвердить, что температура для города показана в Фарингейтах

    @Test

    public void test2() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer R13\\Downloads\\Chromdriver\\"
                + "chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "°F";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchMenuImperial = driver.findElement(
                By.xpath("//div[@class='switch-container']/div[@class='option'][2]")
        );

        searchMenuImperial.click();

        WebElement tempF = driver.findElement(
                By.xpath("//div[@class='current-temp']/span")
        );

        String tempInF = tempF.getText();

        String actualResult = tempInF.substring((tempInF.length()-2));

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();


    }
}

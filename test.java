import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.devtools.browser.Browser.close;
//FA17-BSE-030
//ABDULLAH IQBAL

public class test {

    WebDriver w;

    String Main_url = "https://pay.ebay.com/rgxo?action=view&sessionid=1121622122";
    String check_url;

    public void startWebDriver(){
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        this.w = new ChromeDriver();

    }

    @Test
    public void goToEbay(){
        startWebDriver();
        w.get("https://www.ebay.com/");
        w.findElement(By.xpath("//*[@id=\"gh-cat\"]")).click();
        w.findElement(By.xpath("//*[@id=\"gh-cat\"]/option[5]")).click();
        w.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
        w.findElement(By.xpath("//*[@id=\"s0-26-9-0-1[0]-0-1[0]-0-xCarousel-x-carousel-items\"]/ul/li[1]/a/p")).click();


        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        w.findElement(By.xpath("//*[@id=\"s0-26_2-9-0-1[0]-0-1\"]/ul/li[1]/div/div[2]/a/h3/span")).click();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        w.findElement(By.xpath("//*[@id=\"binBtn_btn\"]")).click();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        w.findElement(By.xpath("//*[@id=\"sbin-gxo-btn\"]")).click();

        try {    // for manual captcha
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        w.findElement(By.xpath("//*[@id=\"country\"]")).click();
        w.findElement(By.xpath("//*[@id=\"country\"]/option[151]")).click();
        w.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("abdullah");
        w.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("iqbal");
        w.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[3]/div[1]/div/div[1]/section[2]/div[2]/div/div/div/div[2]/div[1]/form/section/div/div[3]/div[1]/div/div[1]/input")).sendKeys("abc");
        w.findElement(By.xpath("//*[@id=\"addressLine2\"]")).sendKeys("aaa");
        w.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Abbottabad");
        w.findElement(By.xpath("//*[@id=\"stateOrProvince\"]")).sendKeys("kpk");
        w.findElement(By.xpath("//*[@id=\"postalCode\"]")).clear();
        w.findElement(By.xpath("//*[@id=\"postalCode\"]")).sendKeys("22010");
        w.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("iqbalabdullah640@gmail.com");
        w.findElement(By.xpath("//*[@id=\"emailConfirm\"]")).sendKeys("iqbalabdullah640@gmail.com");
        w.findElement(By.xpath("//*[@id=\"phoneNumber\"]")).sendKeys("3409314148");
        w.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[1]/section[2]/div[2]/div/div/div/div[2]/div[1]/form/div/span/div/button")).click();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.check_url = w.getCurrentUrl();

        if (check_url.equals(this.Main_url)){
            System.out.println("Passed");
        }




    }

}

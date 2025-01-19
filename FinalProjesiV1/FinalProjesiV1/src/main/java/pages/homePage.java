package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class homePage extends basePage {



    public static void goToLogin() {
        Actions action = new Actions(driver);
        WebElement login= driver.findElement(By.xpath("//span[contains(@class,'user-wrapper')]//span[1]"));
        action.moveToElement(login).perform();//giriş yap üzerine hover etme

        WebElement loginBtn = driver.findElement(By.xpath("//a[@class='cart-action__btn cart-action__btn--bg-blue']"));
        loginBtn.click();// Giriş yapm butonuna tıklama

    }

    //Cookieleri kapatma
    public static void closeCookie() {
        WebElement cerezKapaBtn= driver.findElement(By.xpath("//button[@id='cookieseal-banner-reject' and contains(@class, 'cookieseal-banner-button') and text()='Tüm Çerezleri Reddet']"));
        cerezKapaBtn.click();
    }


    //Cocuk bebek üzerine hover etme
    public homePage cocukBebek(){
        Actions action = new Actions(driver);
        WebElement cocukBebekBtn = driver.findElement(By.xpath("//a[@class='menu-header-item__title' and @href='/cocuk-bebek-h3']"));
        action.moveToElement(cocukBebekBtn).pause(Duration.ofSeconds(2)).perform();
        return this;
    }


    // kız çocuk sekmesine hover etme
    public homePage kizCocuk(){
        Actions action = new Actions(driver);
        WebElement kizCocukBtn = driver.findElement(By.xpath("//span[normalize-space()='KIZ ÇOCUK']"));
        action.moveToElement(kizCocukBtn).pause(Duration.ofSeconds(2)).perform();
        return this;
    }

    //Mont kaban tıklama
    public homePage montKaban(){
        WebElement montKaban =driver.findElement(By.xpath("//section[contains(@class,'content-tab')]//a[contains(@class,'')][normalize-space()='Mont ve Kaban']"));
        montKaban.click();
        return this;
    }


    //Favoriler kısmına tıklama
    public static void  goToFavoriler(){
        WebElement favoriler=driver.findElement(By.xpath("//span[normalize-space()='Favorilerim']"));
        favoriler.click();
        delay.bekletme(3000);
    }


}

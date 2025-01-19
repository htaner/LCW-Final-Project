package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static pages.basePage.driver;

public class Odeme {

    //Adrese teslim seçeneğini seçer
    public Odeme adreseTeslim(){
        WebElement adresTeslim = driver.findElement(By.xpath("//label[@for='DeliveryButtonRadio_DeliveryAddressView']"));
        adresTeslim.click();
       delay.bekletme(3000);
       return this;
    }

    //Kayıtlı adresimi seçer
    public Odeme adresSec(){
        WebElement adres = driver.findElement(By.xpath("//span[@class='addressContainerSubtitle']"));
        adres.click();
        delay.bekletme(3000);
        return this;
    }

    //Banka kartı kısmını seçer
    public Odeme bankaKartıSec(){
        WebElement bankaKarti = driver.findElement(By.xpath("//label[@for='PaymentButtonRadio_PaymentCardMasterpassView']//span[@class='label']"));
        bankaKarti.click();
        delay.bekletme(3000);
        return this;
    }

    //Telefon numaramın üstüne masterpass kayıtlı olduğundan sms ile masterpass onayı soruyor bu adımı atlamak için
    public Odeme masterPassGecme(){
        WebElement masterPassGecme =driver.findElement(By.xpath("//span[@class='closeButtonSpan' and @data-v-c5fca10e]"));
        masterPassGecme.click();
        delay.bekletme(3000);
        return this;
    }

    //Sayfanın üstündeki LCW logosuna tıklayarak ana sayfaya döner
    public Odeme goToHome(){
        WebElement logo= driver.findElement(By.xpath("//a[@class='header-logo']"));
        logo.click();
        delay.bekletme(3000);
        return this;
    }


}

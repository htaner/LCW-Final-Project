package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static pages.basePage.driver;

public class Sepetim {

    //Sepetteki ürünün satıcısını döndürür
    public String getUrunTitle(){
        WebElement urunTitle= driver.findElement(By.xpath("//span[@class='rd-cart-item-title']"));
        delay.bekletme(1500);
        return urunTitle.getText();
    }

    //Sepetteki ürünün türünü döndürür
    public String getUrunKod(){
        WebElement urunKod= driver.findElement(By.xpath("//span[@class='rd-cart-item-code']"));
        delay.bekletme(1000);
        return urunKod.getText();
    }

    //Sepetteki ürünün rengini döndürür
    public String getUrunRenk(){
        WebElement urunRenk= driver.findElement(By.xpath("//span[@class='rd-cart-item-color']/strong"));
        delay.bekletme(1000);
        return urunRenk.getText();
    }


    //Sepetteki ürünün miktarını döndürür
    public String getUrunAdet(){
        WebElement adet = driver.findElement(By.xpath("//input[@class='item-quantity-input ignored']"));
        String urunAdet= adet.getDomAttribute("value");
        delay.bekletme(1000);
        return urunAdet;
    }

    //Sepetteki ürünün soldaki fiyatını döndürür
    public String getUrunFiyatSol(){
        WebElement fiyatSol= driver.findElement(By.xpath("//span[@class='rd-cart-item-price mb-15']"));
        delay.bekletme(1000);
        return fiyatSol.getText();
    }

    //Sepetteki ürünün sağdaki yani ödemeye geç adımının üstündeki fiyatı döndürür
    public String getUrunFiyatSag(){
        WebElement fiyatSag = driver.findElement(By.xpath("//span[@class='total-grand-box-amount' and contains(@style, 'color: #1f49b6')]"));
        delay.bekletme(1000);
        return fiyatSag.getText();
    }

    //Ürünü favorilere ekler
    public Sepetim favoriEkle(){
        WebElement favoriEkleBtn = driver.findElement(By.xpath("//i[@class='fa fa-heart-o']"));
        favoriEkleBtn.click();
        delay.bekletme(1000);
        return this;
    }


    //Ödeme adımına geç butonuna tıklar
    public Sepetim goToOdeme(){
        WebElement odemeAlaninaGecBtn= driver.findElement(By.xpath("//div[@class='col-md-12 pl-20 pr-20']//a[@class='main-button mt-15'][normalize-space()='ÖDEME ADIMINA GEÇ']"));
        odemeAlaninaGecBtn.click();
        delay.bekletme(3000);
        return this;
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static pages.basePage.driver;

public class UrunSayfası {

    List<WebElement> inStockItems;

    public UrunSayfası bypassBlackScreen(){ //Siyah ekrandan kurtulmak için ekranın tam ortasına tıklar
        Actions action = new Actions(driver);
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        action.moveByOffset(width/2,height/2).click().perform();
        return this;
    }

    //Stoklarda olan yaş gruplarından bir liste oluşturur ve ilk elemanını döndürür
    public WebElement findInStockItem(){
        inStockItems = driver.findElements(By.xpath("//button[contains(@class, 'option-box') and not(contains(@class, 'option-size-box__out-of-stock'))]"));
        return inStockItems.get(0);
    }

    //Stoklarda olan ilk yaş grubuna tıklar
    public UrunSayfası getInStockItem(WebElement element){
        element.click();
        delay.bekletme(2500);
        return this;
    }

    //Ürün satıcı ismini sepette karşılaştırmak için kaydeder
    public String getUrunSatıcı(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement urunSaticisi= driver.findElement(By.xpath("//p/b[text()='Satıcı:']/parent::p"));
        js.executeScript("arguments[0].scrollIntoView(true);", urunSaticisi);
        String satici= urunSaticisi.getText();
        String saticiFix = satici.replace("Satıcı: ", "");
        return saticiFix;
    }

    //Ürün tipini sepette karşılaştırmak için kaydeder
    public String getUrunTipi(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement urunTipi= driver.findElement(By.xpath("//p/b[text()='Ürün Tipi:']/parent::p"));
        String tipi= urunTipi.getText();
        js.executeScript("arguments[0].scrollIntoView(true);", urunTipi);
        String tipiFix = tipi.replace("Ürün Tipi: ", "");
        return tipiFix;

    }

    //Sayfanın en üstüne çıkar
    public UrunSayfası goTop(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        delay.bekletme(2500);
        return this;
    }

    //Sepet sayfasına gider
    public UrunSayfası goToSepet(){
        WebElement sepetimBtn = driver.findElement(By.xpath("//span[normalize-space()='Sepetim']"));
        sepetimBtn.click();
        delay.bekletme(2500);
        return this;
    }

    //Ürünü Sepete ekler
    public UrunSayfası addToSepet(){
        WebElement sepeteEkleBtn = driver.findElement(By.xpath("//button[normalize-space()='SEPETE EKLE']"));
        sepeteEkleBtn.click();
        delay.bekletme(2500);
        return this;
    }
}

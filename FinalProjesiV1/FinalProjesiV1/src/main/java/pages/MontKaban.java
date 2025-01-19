package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static pages.basePage.driver;

public class MontKaban {

    String title;

    //Yaş filtresi tıklanabilir olana kadar scroll yapıyor
    public MontKaban findYasFiltre(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement yasFiltre = driver.findElement(By.xpath("//div[@class='collapsible-filter-container__content-area collapsible-filter-container__content-area--size-filter']//div[4]"));
        js.executeScript("arguments[0].scrollIntoView(true);", yasFiltre);
        return this;
    }

    //5-6 yaş filtresini ekliyor
    public MontKaban besAltiYasFiltre(){
        WebElement besAltiYas= driver.findElement(By.xpath("//span[contains(text(),'5-6 Yaş')]"));
        besAltiYas.click();
        delay.bekletme(3000);
        return this;
    }

    //6 yaş filtresini ekliyor
    public MontKaban altiYasFiltre(){
        WebElement altiYas= driver.findElement(By.xpath("/html/body//span[@class='filter-option__text' and text()='6 Yaş']"));
        altiYas.click();
        delay.bekletme(3000);
        return this;
    }


    //6-7 yaş filtresini ekliyor
    public MontKaban altiYediYasFiltre(){
        WebElement altiYediYas= driver.findElement(By.xpath("//span[contains(text(),'6-7 Yaş')]"));
        altiYediYas.click();
        delay.bekletme(3000);
        return this;
    }

    //Bej renk filtresini ekliyor
    public MontKaban bejRenkFiltre(){
        WebElement bejRenk = driver.findElement(By.xpath("//span[normalize-space()='BEJ']"));
        bejRenk.click();
        delay.bekletme(3000);
        return this;
    }

    // sayfanın en üstüne kaydır
    public MontKaban goTop(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        return this;
    }

    //Combobox a tıklama
    public MontKaban findComboBox(){
        WebElement comboBox=driver.findElement(By.xpath("//button[@class='dropdown-button__button']"));
        comboBox.click();
        delay.bekletme(3000);
        return this;
    }

    //Çok satanları seçme
    public MontKaban pickCokSatanlar(){
        WebElement cokSatanlar= driver.findElement(By.xpath("//a[normalize-space()='En çok satanlar']"));
        cokSatanlar.click();
        delay.bekletme(3000);
        return this;
    }

    //4. ürnü seçme ve ismini title olarak kaydetme sonrasında title ile favorilerdeki ismini karşılaştırıcam
    public MontKaban clickDorduncuUrun(){
        WebElement dorduncuUrun = driver.findElement(By.xpath("(//a[@data-product-order='4'])[1]"));
        title=dorduncuUrun.getDomAttribute("title");
        dorduncuUrun.click();
        delay.bekletme(3000);
        return this;
    }


    public String getTitle(){
        return title;
    }
}

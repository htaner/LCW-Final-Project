package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static pages.basePage.driver;

public class Favoriler {

    //Favorilerdeki ürünün başlığını döndürür
    public String getFavoriUrun(){
        WebElement favoriUrun=driver.findElement(By.xpath("//h5[contains(text(),'Kapüşonlu Kız Çocuk Kaban')]"));
        return favoriUrun.getText();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class dashbord {

    public WebDriver driver;

    public String mail="taneryuksel01@hotmail.com";
    public String pass="if.VuBZL3*3YWXx";

    public String baseUrl="https://www.lcw.com/";

    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @BeforeClass
    public void goToURL() {
        driver.get(baseUrl);
    }

    @Test
    public void dashbord() throws InterruptedException {

        Actions action = new Actions(driver);

        WebElement login= driver.findElement(By.xpath("//span[contains(@class,'user-wrapper')]//span[1]"));
        action.moveToElement(login).perform();


        WebElement loginBtn = driver.findElement(By.xpath("//a[@class='cart-action__btn cart-action__btn--bg-blue']"));
        loginBtn.click();

        WebElement emailText = driver.findElement(By.xpath("//input[@placeholder='E-posta Adresi veya Telefon Numarası']"));
        emailText.sendKeys(mail);

        WebElement continueBtn= driver.findElement(By.xpath("//button[normalize-space()='Devam Et']"));
        continueBtn.click();

        WebElement passwordText = driver.findElement(By.xpath("//input[@placeholder='Şifreniz']"));
        passwordText.sendKeys(pass);

        WebElement LoginBtn2 = driver.findElement(By.xpath("//button[contains(text(),'Giriş Yap')]"));
        LoginBtn2.click();

        Thread.sleep(60000);

        WebElement cerezKapaBtn= driver.findElement(By.xpath("//button[@id='cookieseal-banner-reject' and contains(@class, 'cookieseal-banner-button') and text()='Tüm Çerezleri Reddet']"));
        cerezKapaBtn.click();

        // "Çocuk & Bebek" menüsüne gel
        Actions action2 = new Actions(driver);
        WebElement cocukBebekBtn = driver.findElement(By.xpath("//a[@class='menu-header-item__title' and @href='/cocuk-bebek-h3']"));
        action2.moveToElement(cocukBebekBtn).pause(Duration.ofSeconds(2)).perform();
        System.out.println("Çocuk & Bebek menüsü açıldı.");

        WebElement kizCocukBtn = driver.findElement(By.xpath("//span[normalize-space()='KIZ ÇOCUK']"));
        action2.moveToElement(kizCocukBtn).pause(Duration.ofSeconds(2)).perform();
        System.out.println("kız çocuk menüsü açıldı");

        WebElement montKaban =driver.findElement(By.xpath("//section[contains(@class,'content-tab')]//a[contains(@class,'')][normalize-space()='Mont ve Kaban']"));
        montKaban.click();
        System.out.println("mont kaban sekmesine gidildi");



        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement yasFiltre = driver.findElement(By.xpath("//div[@class='collapsible-filter-container__content-area collapsible-filter-container__content-area--size-filter']//div[4]"));
        js.executeScript("arguments[0].scrollIntoView(true);", yasFiltre);

        WebElement besAltiYas= driver.findElement(By.xpath("//span[contains(text(),'5-6 Yaş')]"));
        besAltiYas.click();
        System.out.println("besAltiYas gidildi");
        Thread.sleep(3000);

        WebElement altiYas= driver.findElement(By.xpath("/html/body//span[@class='filter-option__text' and text()='6 Yaş']"));
        altiYas.click();
        System.out.println("AltiYas gidildi");
        Thread.sleep(3000);

        WebElement altiYediYas= driver.findElement(By.xpath("//span[contains(text(),'6-7 Yaş')]"));
        altiYediYas.click();
        System.out.println("AltiYediYas gidildi");
        Thread.sleep(3000);

        WebElement bejRenk = driver.findElement(By.xpath("//span[normalize-space()='BEJ']"));
        bejRenk.click();
        System.out.println("bejRenk gidildi");
        Thread.sleep(3000);


        js.executeScript("window.scrollTo(0, 0)");// sayfanın en üstüne kaydır

        WebElement comboBox=driver.findElement(By.xpath("//button[@class='dropdown-button__button']"));
        comboBox.click();
        System.out.println("comboBox gidildi");
        Thread.sleep(2500);

        WebElement cokSatanlar= driver.findElement(By.xpath("//a[normalize-space()='En çok satanlar']"));
        cokSatanlar.click();
        System.out.println("cokSatanlar gidildi");
        Thread.sleep(2500);

        WebElement dorduncuUrun = driver.findElement(By.xpath("(//a[@data-product-order='4'])[1]"));
        String Title=dorduncuUrun.getDomAttribute("title");
        dorduncuUrun.click();
        System.out.println("dorduncuUrun gidildi");
        Thread.sleep(2500);

        //Siyah ekrandan kurtulmak için ekranın tam ortasına tıklama
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        action.moveByOffset(width/2,height/2).click().perform();

        //Stokta olan yaş grubuna gitme
        List<WebElement> inStockItems = driver.findElements(By.xpath("//button[contains(@class, 'option-box') and not(contains(@class, 'option-size-box__out-of-stock'))]"));

        // İlk stokta olan öğeye tıkla
        if (!inStockItems.isEmpty()) {
            inStockItems.get(0).click();
            System.out.println("Tıklanan öğe: " + inStockItems.get(0).getText());
        } else {
            System.out.println("Stokta olan ürün bulunamadı.");
        }

        WebElement sepeteEkleBtn = driver.findElement(By.xpath("//button[normalize-space()='SEPETE EKLE']"));
        sepeteEkleBtn.click();
        System.out.println("sepeteEkleBtn gidildi");
        Thread.sleep(2500);


        WebElement urunSaticisi= driver.findElement(By.xpath("//p/b[text()='Satıcı:']/parent::p"));
        js.executeScript("arguments[0].scrollIntoView(true);", urunSaticisi);
        String satici= urunSaticisi.getText();
        WebElement urunTipi= driver.findElement(By.xpath("//p/b[text()='Ürün Tipi:']/parent::p"));
        String tipi= urunTipi.getText();

        String tipiFix = tipi.replace("Ürün Tipi: ", "");
        String saticiFix = satici.replace("Satıcı: ", "");


        System.out.println("satıcı: " + saticiFix);
        System.out.println("tipi: " + tipiFix);




        js.executeScript("window.scrollTo(0, 0)");// sayfanın en üstüne kaydır

        WebElement sepetimBtn = driver.findElement(By.xpath("//span[normalize-space()='Sepetim']"));
        sepetimBtn.click();
        System.out.println("sepetimBtn gidildi");
        Thread.sleep(2500);



        //Assrtionlar
        WebElement urunTitle= driver.findElement(By.xpath("//span[@class='rd-cart-item-title']"));
        WebElement urunKod= driver.findElement(By.xpath("//span[@class='rd-cart-item-code']"));
        WebElement urunRenk= driver.findElement(By.xpath("//span[@class='rd-cart-item-color']/strong"));
        WebElement adet = driver.findElement(By.xpath("//input[@class='item-quantity-input ignored']"));
        WebElement fiyatSol= driver.findElement(By.xpath("//span[@class='rd-cart-item-price mb-15']"));
        WebElement fiyatSag = driver.findElement(By.xpath("//span[@class='total-grand-box-amount' and contains(@style, 'color: #1f49b6')]"));


        String urunAdet= adet.getDomAttribute("value");


        Assert.assertEquals(urunTitle.getText(),saticiFix);
        Assert.assertEquals(urunKod.getText(),tipiFix);
        Assert.assertEquals(urunRenk.getText(),"Bej");
        //Assert.assertEquals(urunAdet,"3");
        Assert.assertEquals(fiyatSol.getText(),fiyatSag.getText());

        WebElement favoriEkleBtn = driver.findElement(By.xpath("//i[@class='fa fa-heart-o']"));
        favoriEkleBtn.click();
        System.out.println("favoriEkleBtn gidildi");

        WebElement odemeAlaninaGecBtn= driver.findElement(By.xpath("//div[@class='col-md-12 pl-20 pr-20']//a[@class='main-button mt-15'][normalize-space()='ÖDEME ADIMINA GEÇ']"));
        odemeAlaninaGecBtn.click();
        System.out.println("odemeAlaninaGecBtn gidildi");

        Thread.sleep(2000);


        WebElement adresTeslim = driver.findElement(By.xpath("//label[@for='DeliveryButtonRadio_DeliveryAddressView']"));
        adresTeslim.click();
        System.out.println("adresTeslim gidildi");
        Thread.sleep(3000);

        WebElement adres = driver.findElement(By.xpath("//span[@class='addressContainerSubtitle']"));
        adres.click();
        System.out.println("adresTeslim gidildi");
        Thread.sleep(3000);

        WebElement bankaKarti = driver.findElement(By.xpath("//label[@for='PaymentButtonRadio_PaymentCardMasterpassView']//span[@class='label']"));
        bankaKarti.click();
        System.out.println("bankaKarti gidildi");
        Thread.sleep(3000);

        //MasterPass bypass
        WebElement masterPassGecme =driver.findElement(By.xpath("//span[@class='closeButtonSpan' and @data-v-c5fca10e]"));
        masterPassGecme.click();
        System.out.println("masterPassGecme gidildi");
        Thread.sleep(3000);

        WebElement logo= driver.findElement(By.xpath("//a[@class='header-logo']"));
        logo.click();
        System.out.println("logo gidildi");
        Thread.sleep(3000);

        WebElement favoriler=driver.findElement(By.xpath("//span[normalize-space()='Favorilerim']"));
        favoriler.click();
        System.out.println("favoriler gidildi");
        Thread.sleep(3000);


        WebElement favoriUrun=driver.findElement(By.xpath("//h5[contains(text(),'Kapüşonlu Kız Çocuk Kaban')]"));

        System.out.println(favoriUrun.getText());
        System.out.println("favoriUrun gidildi");
        System.out.println(Title);

        Assert.assertEquals(favoriUrun.getText(),Title);








    }

}

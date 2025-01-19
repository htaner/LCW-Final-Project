import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class mainTest extends basePage {

    homePage home=new homePage();
    LoginPage login=new LoginPage();

    UrunSayfası urun= new UrunSayfası();

    MontKaban montKaban=new MontKaban();

    Sepetim sepetim=new Sepetim();

    Odeme odeme=new Odeme();

    Favoriler favoriler=new Favoriler();



    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void test() {

        //Login page yönlendirme
        homePage.goToLogin();


        login.fillEmail(mail)//Login sayfasında email doldurma
                .clickContinue()// email kısmını doldurduktan sonra devam et butonuna absma
                .fillPassword(pass)// Şifre alanını doldurma
                .clickLogin();//Giriş ayap butonuna basma

        delay.bekletme(30000);//3D secure şifresini girebilmek için bekleme kısmı

        //Cookie banner ı kapatma
        homePage.closeCookie();

        home.cocukBebek()//Çocuk bebek kısmına hover etme
                .kizCocuk()// Kız çocuk kısmına hover etme
                .montKaban();//Mont kaban tıklama

        montKaban.findYasFiltre()//Yaş filtresi tıklanabilir olana kadar scroll yapıyor
                .besAltiYasFiltre()//5-6 yaş filtresini ekliyor
                .altiYasFiltre()//6 yaş filtresini ekliyor
                .altiYediYasFiltre()//6-7 yaş filtresini ekliyor
                .bejRenkFiltre()//Bej renk filtresi ekliyor
                .goTop()//Sayfanın en üstüne çıkıyor
                .findComboBox()//Combo box seçiyor
                .pickCokSatanlar()//Çok satanları seçiyor
                .clickDorduncuUrun();// 4. ürüne tıklıyor


        String title=montKaban.getTitle();// Sonrasında favorilerde karşılaştırmak için tıkladığım ürünün ismini kaydediyorum

        urun.bypassBlackScreen()//Sayfaya ilk girdiğinde siyah ekranla karşılaşıyorsun bundan kurtulmak için ekranın tam ortasına tıklar
                .getInStockItem(urun.findInStockItem())//Stokta olan yaş gruplarından ilkini seçer
                .addToSepet();//Sepete ekler


        //Sonrasında sepette ürünün ismi Satıcı ve türü olarak gözüktüğünden ürünün sayfasındaki satıcı ve türünü kaydediyorum sepette assertion yapabilmek için
        String urunSatici= urun.getUrunSatıcı();
        String urunTipi= urun.getUrunTipi();

        urun.goTop()//Sayfanın en üstüne gider
                .goToSepet();//Sepete gider



        //Assertions
        Assert.assertEquals(urunSatici, sepetim.getUrunTitle());//Ürünün sepette isminin ilk kısmı satıcıya ait
        Assert.assertEquals(urunTipi, sepetim.getUrunKod());// Ürünün sepette isminin ikinci kısmı türüne ait
        Assert.assertEquals(sepetim.getUrunRenk(),"Bej");//Filtreleme yaptığım renge göre karşılaştırıyorum
        Assert.assertEquals(sepetim.getUrunAdet(),"1");//Adet karşılaştırması
        Assert.assertEquals(sepetim.getUrunFiyatSol(),sepetim.getUrunFiyatSag());//Ürünün sepette sol tarafta yazan fiyatı ile sağ tarafta ödemeye geç adımının üstünde yazan fiyatı karşılaştırıyorum

        sepetim.favoriEkle()//Ürün favorilerde değilse kalbe tıklayarak favorilere ekler
                .goToOdeme();//Ödemeler ekranına gider

        odeme.adreseTeslim()//Adrese teslim seçeneğini seçer
                .adresSec()//Kayıtlı olan adresimi seçer
                .bankaKartıSec()//Banka kartı kısmını seçer
                .masterPassGecme()//MasterPass ekranını atlatır
                .goToHome();//Ana sayfaya gider

        homePage.goToFavoriler();//Ana sayfa üzerinden favoriler kısmına gider

        Assert.assertEquals(title,favoriler.getFavoriUrun());//Favorilerdeki ürünün başlığı ile en başta mont kaban kısmındaki 4. ürünün(seçtiğimiz) başlığını karşılaştırır
        delay.bekletme(5000);

    }



}

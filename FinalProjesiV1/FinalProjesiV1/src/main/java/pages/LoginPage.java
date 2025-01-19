package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static pages.basePage.driver;

public class LoginPage  {


    //Email kısmını doldurma
    public LoginPage fillEmail(String email) {
        WebElement emailText = driver.findElement(By.xpath("//input[@placeholder='E-posta Adresi veya Telefon Numarası']"));
        emailText.sendKeys(email);
        return this;
    }

    //Email kısmını doldurduktan sonra devam et butonuna basma
    public LoginPage clickContinue() {
        WebElement continueBtn= driver.findElement(By.xpath("//button[normalize-space()='Devam Et']"));
        continueBtn.click();
        return this;
    }

    //Şifre alanını doldurma
    public LoginPage fillPassword(String password) {
        WebElement passwordText = driver.findElement(By.xpath("//input[@placeholder='Şifreniz']"));
        passwordText.sendKeys(password);
        return this;
    }

    //Şifre alanı da dolduktan sonra en son giriş yap a basma
    public LoginPage clickLogin() {
        WebElement LoginBtn2 = driver.findElement(By.xpath("//button[contains(text(),'Giriş Yap')]"));
        LoginBtn2.click();
        return this;
    }


}

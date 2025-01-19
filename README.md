# LCW Yazılım Test Uzmanı Bootcamp Final Projesi

Bu proje, LCW sitesi için oluşturulmuş bir otomasyon projesidir. **TestNG**, **Selenium WebDriver** ve **Allure Reports** gibi araçlar kullanılarak geliştirilmiştir.

---

## Özellikler
- Giriş yapma senaryosu
- Ürün arama ve filtreleme
- Sepete ürün ekleme ve doğrulama
- Favorilere ürün ekleme
- Ödeme ekranına geçiş senaryosu
- Allure raporlarıyla test sonucu analizi

---

## Gereksinimler
- **Java JDK**
- **Maven** (bağımlılık yönetimi için)
- **Allure Command Line** (raporlar için)

---
Kurulumu yaptıktan sonra src/main/java/pages/data.java girerek mail ve pass alanlarını kendi email ve şifrenizle doldurun. 
Ardından dilerseniz src/test/java/mainTest.java yı çalıştırarak yada src/test/resources/testng.xml run layarak çalıştırabilirsiniz.

**Kişisel Verilerinizi Ekleyin**:
   - `src/main/java/pages/data.java` dosyasına gidin.
   - `mail` ve `pass` alanlarını kendi email ve şifrenizle doldurun:
     ```java
     public class data {
         public String mail = "sizin-email@example.com";
         public String pass = "sifreniz";
     }

**Testi Çalıştırın**:
   - **TestNG XML Kullanarak**:
     `src/test/resources/testng.xml` dosyasını sağ tıklayın ve **Run 'testng.xml'** seçeneğini seçin.
   - **MainTest Sınıfını Kullanarak**:
     `src/test/java/mainTest.java` dosyasını çalıştırın.

---

## Raporlama
Testler tamamlandıktan sonra **Allure Reports** ile rapor oluşturabilirsiniz:

1. **Raporu Görüntüleme**:
   ```bash
   allure serve allure-results
   ```

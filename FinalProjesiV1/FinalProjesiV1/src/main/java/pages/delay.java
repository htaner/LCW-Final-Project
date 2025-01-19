package pages;

public class delay {



    //Yapılan işlemleri daha rahat görebilmek için verilen süre kadar bekler(miliseconds olarak input alır)
    public static void bekletme(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

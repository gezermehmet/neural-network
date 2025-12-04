package trash;
import java.util.ArrayList;
import java.util.List;

// --- 1. INTERFACE (YETENEK) ---
// Her araçta GPS olmayabilir, bu yüzden bunu bir yetenek (interface) olarak tanımlıyoruz.
interface GPS {
    void rotaOlustur(String hedef);
}

// --- 2. ABSTRACT CLASS (SOYUT ANA SINIF) ---
// "abstract" olduğu için bu sınıftan direkt "new Arac()" diye nesne üretilemez.
abstract class Arac {
    // Encapsulation (Kapsülleme): Değişkenler private, dışarıdan erişim kontrollü.
    private String marka;
    private String model;

    public Arac(String marka, String model) {
        this.marka = marka;
        this.model = model;
    }

    // Somut Metot: Tüm araçlar aynı şekilde çalışır (Varsayalım)
    public void calistir() {
        System.out.println(getMarka() + " " + getModel() + " motoru çalıştırıldı.");
    }

    // Soyut Metot: Gövdesi yok! Alt sınıflar bunu KENDİSİNE GÖRE doldurmak ZORUNDA.
    // Çünkü benzinli depoyu doldurur, elektrikli şarja takılır.
    public abstract void yakitDoldur();

    // Getter metotları (Private değişkenleri okumak için)
    public String getMarka() { return marka; }
    public String getModel() { return model; }
}

// --- 3. ALT SINIFLAR (CONCRETE CLASSES) ---

class BenzinliAraba extends Arac {
    public BenzinliAraba(String marka, String model) {
        super(marka, model);
    }

    @Override
    public void yakitDoldur() {
        // Abstract metodu doldurmak zorundayız
        System.out.println(">> " + getMarka() + " için benzin pompası takıldı. 95 oktan yükleniyor...");
    }
}

// Elektrikli araba hem Arac sınıfından türüyor hem de GPS yeteneğini kazanıyor.
class ElektrikliAraba extends Arac implements GPS {
    public ElektrikliAraba(String marka, String model) {
        super(marka, model);
    }

    @Override
    public void yakitDoldur() {
        System.out.println(">> " + getMarka() + " şarj istasyonuna bağlandı. %100 bekleniyor...");
    }

    // Interface'den gelen metodu dolduruyoruz
    @Override
    public void rotaOlustur(String hedef) {
        System.out.println("[NAVİGASYON]: " + getMarka() + " için " + hedef + " rotası oluşturuldu.");
    }
}

// --- 4. SENARYO (POLYMORPHISM) ---

public class Main {
    public static void main(String[] args) {
        
        // Polymorphism'in gücü: Listemiz "Arac" türünde ama içine her türlü alt sınıfı atabiliyoruz.
        List<Arac> garaj = new ArrayList<>();

        garaj.add(new BenzinliAraba("BMW", "320i"));
        garaj.add(new ElektrikliAraba("Tesla", "Model S"));
        garaj.add(new BenzinliAraba("Fiat", "Egea"));

        System.out.println("--- GARAJ KONTROLÜ BAŞLIYOR ---\n");

        // Tek bir döngü ile farklı tiplerdeki nesneleri yönetiyoruz.
        for (Arac arac : garaj) {
            
            arac.calistir();      // Hepsi çalışır (Miras)
            arac.yakitDoldur();   // Hepsi farklı şekilde yakıt alır (Override/Polymorphism)

            // instanceof kontrolü:
            // Elimizdeki araç "ElektrikliAraba" tipinde mi? Öyleyse GPS özelliğini kullan.
            if (arac instanceof ElektrikliAraba) {
                // Downcasting: Arac tipini ElektrikliAraba tipine dönüştürüyoruz.
                ((ElektrikliAraba) arac).rotaOlustur("İstanbul");
            }

            System.out.println("-----------------------------");
        }
    }
}
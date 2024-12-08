import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int secim = -1;
        OgrListe bilBolum = new OgrListe();

        Scanner scanner = new Scanner(System.in);

        while ( secim != 0 )
        {
            System.out.println();
            System.out.println("Bilgisayar bölümü öğrenci kayıt otomasyonu");
            System.out.println("1- Yeni Kayıt");
            System.out.println("2- Kayıt Sil");
            System.out.println("3- Kayıtları Listele");
            System.out.println("4- En Başarılı Öğrenci Bilgileri");
            System.out.println("0- Çıkış");
            System.out.print("Seçiminiz: ");

            secim = scanner.nextInt();

            if ( secim == 1)
                bilBolum.ekle();
            else if ( secim == 2)
                bilBolum.sil();
            else if (secim == 3)
                bilBolum.yazdir();
            else if (secim == 4)
                bilBolum.enBasariliOgrenci();
            else if ( secim == 0)
                System.out.println("Çıkış yapılıyor...");
            else
                System.out.println("Hatalı secim yaptınız");

        }




    }
}
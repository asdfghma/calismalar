import java.util.Scanner;

public class Uygulama {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BagliListe liste = new BagliListe();

        int secim = -1;
        while (secim != 0)
        {
            System.out.println("1-Ekle");
            System.out.println("2-Sil");
            System.out.println("3-Yazdır");
            System.out.println("4-Ara");
            System.out.println("0-Çıkış");
            System.out.println("Seçiminiz"); secim = scanner.nextInt();


            switch (secim)
            {
                case 1: liste.ekle();break;
                case 2: liste.sil();break;
                case 3: liste.yazdir();break;
                case 4: liste.aracAra();break;
                case 0: System.out.println("Çıkış yaptınız");break;
                default: System.out.println("Hatalı seçim (0-4)"); break;

            }
        }


    }
}
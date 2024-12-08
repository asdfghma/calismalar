import java.util.Scanner;

public class OgrListe {

    OgrNode head = null;
    OgrNode tail = null;
    OgrNode temp = null;
    OgrNode temp2 = null;

    int numara;
    String ad;
    String soyad;
    int vize;
    int fin;
    double ortalama;
    String durum;

    Scanner scanner = new Scanner(System.in);

    void  ekle()
    {
        System.out.println("Bilgisayar bölümüne kayıt olacak öğrenci bilgilerini giriniz: ");
        System.out.println("Numara: "); numara = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ad: "); ad = scanner.nextLine();
        System.out.println("Soyad: "); soyad = scanner.nextLine();
        System.out.println("Vize: "); vize = scanner.nextInt();
        System.out.println("Final: "); fin = scanner.nextInt();

        OgrNode eleman = new OgrNode(numara, ad, soyad, vize, fin);

        if (head == null) {
            head = eleman;
            tail = eleman;
            System.out.println("Bilgisayar Bölümüne Kayıt Olacak Öğrencilerin Liste Yapısı Oluşturuldu İlk Öğrenci Kayıt Edildi.");
        }
        else
        {
            eleman.next = head;
            head = eleman;
            System.out.println(numara + " numaralı öğrenci bölüme kayıt edildi");
        }
    }


    void sil() {
        if (head == null)
        {
            System.out.println("Liste boş, silinecek öğrenci yok");
        }
        else
        {
            System.out.println("Silmek istediğiniz öğrencinin numarasını giriniz: ");
            numara = scanner.nextInt();

            if (numara == head.numara && head.next == null) {
                head = null;
                tail = null;
                System.out.println(numara + " numaralı öğrenci silindi, listede kayıtlı öğrenci kalmadı");

            }
            else if (numara == head.numara && head.next != null)
            {
                head = head.next;
                System.out.println(numara + " numaralı öğrenci silindi");
            }
            else
            {
              temp = head;
              temp2 = head;
              while (temp.next != null)
              {
                  if ( numara == temp.numara) {
                      temp2.next = temp.next;
                      System.out.println(numara + " numaralı öğrenci silindi");
                  }

                  temp2 = temp;
                  temp = temp.next;
              }
                if ( numara == temp.numara) {
                    temp2.next = null;
                    tail = temp2;
                    System.out.println(numara + " numaralı öğrenci silindi");
                }

            }

        }
    }


    void yazdir()
    {
       if (head == null)
       {
           System.out.println("Liste boş");
       }
       else {
           temp = head;
           while (temp != null)
           {
               System.out.println("----------------------------");
               System.out.println(temp.numara + " numaralı öğrenci bilgileri");
               System.out.println("Ad       : " + temp.ad);
               System.out.println("Soyad    : " + temp.soyad);
               System.out.println("Vize     : " + temp.vize);
               System.out.println("Final    : " + temp.fin);
               System.out.println("Ortalama : " + temp.ortalama);
               System.out.println("Durum    : " + temp.durum);
               System.out.println("----------------------------");



               temp = temp.next;
           }
       }

    }


    void enBasariliOgrenci()
    {
        if (head == null)
        {
            System.out.println("Liste boş");
        }
        else {
            temp = head;
            double buyuk= temp.ortalama;

            while (temp != null)
            {
                if ( buyuk < temp.ortalama )
                {
                    buyuk = temp.ortalama;

                    numara = temp.numara;
                    ad = temp.ad;
                    soyad = temp.soyad;
                    vize = temp.vize;
                    fin = temp.fin;
                    ortalama = temp.ortalama;
                    durum = temp.durum;

                }

                temp = temp.next;
            }
            System.out.println("----------------------------");
            System.out.println("En başarılı öğrenci bilgileri");
            System.out.println("Ad       : " + ad);
            System.out.println("Soyad    : " + soyad);
            System.out.println("Vize     : " + vize);
            System.out.println("Final    : " + fin);
            System.out.println("Ortalama : " + ortalama);
            System.out.println("Durum    : " + durum);
            System.out.println("----------------------------");

        }

    }


}

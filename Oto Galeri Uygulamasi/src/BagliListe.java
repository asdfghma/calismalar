import java.util.Scanner;

public class BagliListe {

    Scanner scanner = new Scanner(System.in);

    OtoNode head = null;
    OtoNode tail = null;

    String plaka;
    String marka;
    String model;
    String renk;
    int alisFiyat;
    int satisFiyat;
    String aciklama;

    void ekle()
    {

        System.out.println("Galeriye eklenecek otomobilin bilgilerini giriniz: ");
        System.out.print("Plaka       : "); plaka = scanner.nextLine();
        System.out.print("Marka       : "); marka = scanner.nextLine();
        System.out.print("Model       : "); model = scanner.nextLine();
        System.out.print("Renk        : "); renk = scanner.nextLine();
        System.out.print("Alış Fiyatı : "); alisFiyat = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Açıklama: "); aciklama = scanner.nextLine();

        OtoNode arac = new OtoNode(plaka, marka, model, renk, alisFiyat, aciklama);

        if (head == null) {

            head = arac;
            tail = arac;
            tail.next = head;
            System.out.println(plaka + " Plakalı araç oto galeriye eklendi");

        }
        else {
            arac.next = head;
            head = arac;
            tail.next = head;
            System.out.println(plaka + " Plakalı araç oto galeriye eklendi");

        }
    }


    void sil() {
        if (head == null) {
            System.out.println("Oto Galeride araç yok");
        } else {
            System.out.println("Satışını yaptığımız otomobil plakası: ");
            plaka = scanner.nextLine();

            if (head == tail && head.plaka.equals(plaka)) {
                System.out.println(plaka + " Plakalı araç " + head.satisFiyat + " TL'ye satıldı");
                head = null;
                tail = null;
            } else if (head.plaka.equals(plaka)) {
                System.out.println(plaka + " Plakalı araç " + head.satisFiyat + " TL'ye satıldı");
                head = head.next;
                tail.next = head;  // tail'in next referansı başa bağlanmalı
            } else {
                OtoNode temp = head;
                OtoNode temp2 = null;

                while (temp != null) {
                    if (temp.plaka.equals(plaka)) {
                        System.out.println(plaka + " Plakalı araç " + temp.satisFiyat + " TL'ye satıldı");
                        if (temp == tail) {
                            tail = temp2;
                            tail.next = head;
                        } else {
                            temp2.next = temp.next;
                        }
                        return;
                    }
                    temp2 = temp;
                    temp = temp.next;
                }

                System.out.println(plaka + " Plakalı araç oto galeride yok");
            }
        }
    }



    void yazdir()
    {
        if (head == null)
        {
            System.out.println("Oto Galeride araç yok");
        }
        else
        {
            System.out.println("Plaka\tMarka\tModel\tRenk\taFiyat\tsFiyatı\tAçıklama");

            OtoNode temp = head;
            while (temp != tail)
            {

                System.out.println(temp.plaka + "\t" + temp.marka + "\t" + temp.model + "\t" + temp.renk + "\t" + temp.alisFiyat + "\t" + temp.satisFiyat + "\t" + temp.aciklama);
                temp = temp.next;
            }
            System.out.println(temp.plaka + "\t" + temp.marka + "\t" + temp.model + "\t" + temp.renk + "\t" + temp.alisFiyat + "\t" + temp.satisFiyat + "\t" + temp.aciklama);
        }
    }


    void aracAra()
    {
        if (head == null)
        {
            System.out.println("Oto Galeride araç yok");
        }
        else
        {
            boolean sonuc = false;
            System.out.println("Aradığınız aracın plakası: "); plaka = scanner.nextLine();
            OtoNode temp = head;
            OtoNode temp2 = head;

            while (temp != tail)
            {
                if (temp.plaka.equals(plaka))
                {
                    temp2 = temp;
                    sonuc = true;
                }
                temp = temp.next;
            }
            if (temp.plaka.equals(plaka))
            {
                temp2 = temp;
                sonuc = true;
            }

            if (sonuc == false)
                System.out.println(plaka + " Plakalı araç oto galeride yok");
            else
            {
                System.out.println(plaka + " Plakalı araç bilgileri: ");
                System.out.println("Marka        : " + temp2.marka);
                System.out.println("Model        : " + temp2.model);
                System.out.println("Renk         : " + temp2.renk);
                System.out.println("Alış Fiyatı  : " + temp2.alisFiyat);
                System.out.println("Satış Fiyatı : " + temp2.satisFiyat);
                System.out.println("Açıklma      : " + temp2.aciklama);

            }
        }
    }


}

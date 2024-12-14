public class Table {
    Node dizi[];
    int size;
    public Table(int size) {
        this.size = size;
        dizi = new Node[size];
        for (int i = 0; i < size; i++) {
            dizi[i] = new Node();
        }
    }

    int indexUret(int key) {
        return key % size;

    }


    void ekle(int key, String isim) {

        int index = indexUret(key);

        Node eleman = new Node(key, isim);

        Node temp = dizi[index];

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = eleman;

        System.out.println(eleman.isim + " eklendi");
    }

    void sil(int key) {

        boolean sonuc = false;
        int indis = indexUret(key);
        Node temp = dizi[indis];
        Node temp2 = dizi[indis];

        if (temp.next == null) {
            System.out.println(key + " numaralı kayıt yok");
            sonuc = true;
        }
        else if (temp.next.next == null && temp.next.key == key) {
            sonuc = true;
            System.out.println(temp.next.isim + " silindi");
            temp.next = null;
        }
        else
        {
            while (temp.next != null) {

                temp2 = temp;
                temp = temp.next;

                if (temp.key == key) {
                    sonuc = true;
                    System.out.println(temp.next.isim + " silindi");
                    temp2.next = temp.next;
                }
            }
        }
        if (sonuc == false)
            System.out.println(key + " numaralı kayıt yok");

    }


    void yazdir() {

      for (int i = 0; i < size; i++) {
          Node temp = dizi[i];

          System.out.print("Dizi["+i+"] -> ");
          if (temp.next != null) {
              while (temp.next != null) {
                  System.out.print(temp.next.key + " - " + temp.next.isim + " -> ");
                  temp = temp.next;
              }
              System.out.println();
          }
      }

    }
}


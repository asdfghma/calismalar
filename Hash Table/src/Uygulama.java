public class Uygulama {

    public static void main(String[] args) {

            Table htablo = new Table(5);
            htablo.ekle(0, "bilal");
            htablo.ekle(1, "Cahit");
            htablo.ekle(2,"Arf");
            htablo.ekle(3, "Tesla");
            htablo.ekle(4, "Nicola");
            htablo.ekle(5, "user");
            htablo.ekle(6, "name");


            htablo.sil(4);
            htablo.yazdir();


    }

}

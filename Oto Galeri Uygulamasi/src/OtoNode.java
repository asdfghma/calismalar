public class OtoNode {

    String plaka;
    String marka;
    String model;
    String renk;
    int alisFiyat;
    int satisFiyat;
    String aciklama;
    OtoNode next;
    public OtoNode(String plaka, String marka, String model, String renk, int alisFiyat, String aciklama) {

        this.plaka = plaka;
        this.marka = marka;
        this.model = model;
        this.renk = renk;
        this.alisFiyat = alisFiyat;
        this.satisFiyat = alisFiyat * 12/10;
        this.aciklama = aciklama;
        next = null;

    }
}

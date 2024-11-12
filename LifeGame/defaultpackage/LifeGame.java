package defaultpackage;

import java.io.IOException;

public class LifeGame {
	
	final int habitatSatir = 19;
	final int habitatSutun = 19;
	
	int hucreHabitat[][];
	int hucreHabitatTmp[][];
	int[] pulsarSatir;
	int[] pSatir;
	int pulsarSutun[];
	
	public LifeGame() {
		// pulsar deseni için gerekli ön tanımlar
		pSatir = new int[] {3, 8, 10, 15};
		pulsarSatir = new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 };
		pulsarSutun = new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 };
		
		// Gerçek ve değişikliklerin yapılcağı yaşam alanı
		
		hucreHabitat = new int[habitatSatir][habitatSutun];
		hucreHabitatTmp = new int[habitatSatir][habitatSutun];
		
		// Yaşam alanları sıfırlanıyor
		int c = 0;
		for(int i = 0; i < habitatSatir; i++) {
			for (int y = 0; y < habitatSutun; y++) {
				hucreHabitatTmp[i][y] = 0;
				hucreHabitat[i][y] = 0;
			}
		}
		
		// Pulsar deseni gerçek yaşam alanına aktarılıyor
		
		for(int satir = 0; satir < pSatir.length; satir++) {
			for(int sutun = 0; sutun < habitatSutun; sutun++) {
				hucreHabitat[pSatir[satir]][sutun] = pulsarSatir[sutun];
			}
		}
		
		for(int sutun = 0; sutun < pSatir.length; sutun++) {
			for (int satir = 0; satir < habitatSutun; satir++) {
				hucreHabitat[satir][pSatir[sutun]] = pulsarSatir[satir];
			}
		}
		
	}

    // Habitatı konsola çizme
	public void drawHabitat() {
		for (int i = 1; i < habitatSatir - 1; i++) {
			for(int y = 1; y < habitatSutun - 1; y++) {
				System.out.print(hucreHabitat[i][y] == 0 ? "-" : "#");; // Hücre ölü ise '-' canlı ise '#' yaz
			}
			System.out.println();
		}
		
	}
	

    // Canlı komşu hücreleri sayma
	public int komsuCanliSayisi(int satir, int sutun) {
		int canlıKomsuSayisi = 0;
		for(int i = -1; i <= 1; i++) { // Merkezi hücre etrafındaki satırları dolaş
			for(int j = -1; j <= 1; j++) { // Merkezi hücre etrafındaki sütunları dolaş
				if(i == 0 && j == 0) continue; // Merkezi hücreyi atla
				if(hucreHabitat[satir + i][sutun + j] == 1) canlıKomsuSayisi++;		
			}
		}
		
		return canlıKomsuSayisi;
	}

    // Yeni habitat kurallarını uygulama
	public void newHabitatRule() {
		for(int i = 1; i < habitatSatir - 1; i++) {
			for (int y = 1; y < habitatSutun - 1; y++) {
				int cks = komsuCanliSayisi(i, y);
				if (hucreHabitat[i][y] == 1 && (cks < 2 || cks >3)) {
					hucreHabitatTmp[i][y] = 0;
				}else if (hucreHabitat[i][y] == 0 && cks ==3) {
					hucreHabitatTmp[i][y] = 1;
				} else {
					hucreHabitatTmp[i][y] = hucreHabitat[i][y];
				}
			}
		}
		copyHabitat();
	}
	
    // Geçici habitatı gerçek habitatla değiştirme
	public void copyHabitat() {
		for (int i = 0; i < habitatSatir; i++) {
			for(int y = 0; y < habitatSutun; y++) {
				hucreHabitat[i][y] = hucreHabitatTmp[i][y];
			}
		}
		
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		LifeGame lg = new LifeGame();
		for(int i = 0; i < 20; i++) {
			lg.drawHabitat();
			lg.newHabitatRule();
			System.out.println();
			Thread.sleep(1500);
		}

	}

}






/*
package defaultpackage; // Paketin adı

import java.io.IOException; // Gerekli kütüphane ithalatı

public class LifeGame {
    final int habitatSatir = 19; // Habitatın satır sayısı
    final int habitatSutun = 19; // Habitatın sütun sayısı
    int hucreHabitat[][]; // Gerçek yaşam alanını temsil eden iki boyutlu dizi
    int hucreHabitatTmp[][]; // Geçici yaşam alanını temsil eden iki boyutlu dizi
    int[] pulsarSatir; // Pulsar desenine ait satır koordinatları
    int[] pSatir; // Pulsar deseninin sabit satır koordinatları
    int pulsarSutun[]; // Pulsar desenine ait sütun koordinatları

    // Yapılandırıcı (Constructor)
    public LifeGame() {
        // Pulsar deseni için gerekli ön tanımlar
        pSatir = new int[]{3, 8, 10, 15}; // Sabit satır konumları
        pulsarSatir = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0}; // Desendeki hücrelerin canlı/ölü durumu
        pulsarSutun = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0}; // Desendeki hücrelerin sütun koordinatları

        // Gerçek ve geçici yaşam alanlarını sıfırlıyor
        hucreHabitat = new int[habitatSatir][habitatSutun]; // Gerçek habitat dizisini oluşturma
        hucreHabitatTmp = new int[habitatSatir][habitatSutun]; // Geçici habitat dizisini oluşturma

        for (int i = 0; i < habitatSatir; i++) { // Tüm satırları dolaş
            for (int y = 0; y < habitatSutun; y++) { // Tüm sütunları dolaş
                hucreHabitatTmp[i][y] = 0; // Geçici habitatın hücresini sıfırla
                hucreHabitat[i][y] = 0; // Gerçek habitatın hücresini sıfırla
            }
        }

        // Pulsar deseni gerçek yaşam alanına aktarılıyor
        for (int satir : pSatir) { // Sabit satırları dolaş
            for (int sutun = 0; sutun < habitatSutun; sutun++) { // Tüm sütunları dolaş
                hucreHabitat[satir][sutun] = pulsarSatir[sutun]; // Pulsar desenini yerleştir
            }
        }

        for (int sutun = 0; sutun < pSatir.length; sutun++) { // Sabit sütunları dolaş
            for (int satir = 0; satir < habitatSatir; satir++) { // Tüm satırları dolaş
                hucreHabitat[satir][pSatir[sutun]] = pulsarSatir[satir]; // Pulsar desenini yerleştir
            }
        }
    }

    // Habitatı konsola çizme
    public void drawHabitat() {
        for (int i = 1; i < habitatSatir - 1; i++) { // Dış çerçeveyi ihmal ederek satırları dolaş
            for (int y = 1; y < habitatSutun - 1; y++) { // Dış çerçeveyi ihmal ederek sütunları dolaş
                System.out.print(hucreHabitat[i][y] == 0 ? "-" : "#"); // Hücre ölü ise '-' canlı ise '#' yaz
            }
            System.out.println(); // Satır bittiğinde yeni satıra geç
        }
    }

    // Canlı komşu hücreleri sayma
    public int komsuCanliSayisi(int satir, int sutun) {
        int canlıKomsuSayisi = 0; // Canlı komşu sayısı başlangıçta 0
        for (int i = -1; i <= 1; i++) { // Merkezi hücre etrafındaki satırları dolaş
            for (int j = -1; j <= 1; j++) { // Merkezi hücre etrafındaki sütunları dolaş
                if (i == 0 && j == 0) continue; // Merkezi hücreyi atla
                if (hucreHabitat[satir + i][sutun + j] == 1) canlıKomsuSayisi++; // Canlı hücre varsa sayıcıyı artır
            }
        }
        return canlıKomsuSayisi; // Canlı komşu sayısını döndür
    }

    // Yeni habitat kurallarını uygulama
    public void newHabitatRule() {
        for (int i = 1; i < habitatSatir - 1; i++) { // Dış çerçeveyi ihmal ederek satırları dolaş
            for (int y = 1; y < habitatSutun - 1; y++) { // Dış çerçeveyi ihmal ederek sütunları dolaş
                int cks = komsuCanliSayisi(i, y); // Hücrenin canlı komşu sayısını hesapla
                if (hucreHabitat[i][y] == 1 && (cks < 2 || cks > 3)) {
                    hucreHabitatTmp[i][y] = 0; // Az ya da fazla nüfustan dolayı hücre ölür
                } else if (hucreHabitat[i][y] == 0 && cks == 3) {
                    hucreHabitatTmp[i][y] = 1; // Üreme: Ölü hücre canlanır
                } else {
                    hucreHabitatTmp[i][y] = hucreHabitat[i][y]; // Diğer durumlarda hücre aynı kalır
                }
            }
        }
        copyHabitat(); // Güncellenen habitatı kopyala
    }

    // Geçici habitatı gerçek habitatla değiştirme
    public void copyHabitat() {
        for (int i = 0; i < habitatSatir; i++) { // Tüm satırları dolaş
            for (int y = 0; y < habitatSutun; y++) { // Tüm sütunları dolaş
                hucreHabitat[i][y] = hucreHabitatTmp[i][y]; // Geçici habitatı gerçek habitatla değiştir
            }
        }
    }

    // Ana metod
    public static void main(String[] args) {
        LifeGame lg = new LifeGame(); // LifeGame nesnesi oluşturma
        for (int i = 0; i < 20; i++) { // 20 iterasyon boyunca
            lg.drawHabitat(); // Habitatı çiz
            lg.newHabitatRule(); // Yeni kuralları uygula
            System.out.println("Iteration: " + (i + 1)); // İterasyon numarasını yazdır
            try {
                Thread.sleep(1500); // 1.5 saniye bekle
            } catch (InterruptedException e) {
                e.printStackTrace(); // Hata olursa yığını yazdır
            }
        }
    }
}


*/
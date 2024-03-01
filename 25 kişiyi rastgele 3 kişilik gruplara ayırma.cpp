#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define OGRENCI_SAYISI 25


const char* ogrenci_isimleri[] = {
    "Ahmet", "Ayse", "Mehmet", "Fatma", "Ali",
    "Zeynep", "Mustafa", "Elif", "Emre", "Selin",
    "Eren", "Ceren", "Kemal", "Nur", "Can",
    "Deniz", "Gizem", "Burak", "Derya", "Tolga",
    "Esra", "Hakan", "Ipek", "Levent", "Melis"
    
};


const char* rastgele_ogrenci_ismi(int* secilenler, int secilen_sayisi) {
    int rastgele_index;
    while (1) {
        rastgele_index = rand() % (sizeof(ogrenci_isimleri) / sizeof(ogrenci_isimleri[0]));
        if (secilenler[rastgele_index] == 0) {
            secilenler[rastgele_index] = 1;
            secilen_sayisi++;
            return ogrenci_isimleri[rastgele_index];
        }
    }
}

int main() {
    srand(time(NULL)); 

    int secilenler[OGRENCI_SAYISI] = {0}; 

    
    for (int grup = 0; grup <= OGRENCI_SAYISI / 3; grup++) {
        printf("Grup %d:\n", grup);
        for (int ogrenci = 0; ogrenci < 3; ogrenci++) {
            printf("  %s\n", rastgele_ogrenci_ismi(secilenler, ogrenci));
        }
        printf("\n");
    }

    return 0;
}


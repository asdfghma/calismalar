#include <stdio.h>

int main() {
    FILE *dosya;
    char musteriAdi[100];
    char ilacAdi[100];
    char dozaj[50];
    
    dosya = fopen("receteler.txt", "a");
    if(dosya == NULL) {
        printf("Dosya bulunamadi");
        return 1;
}

printf("Musterinin adini giriniz : ");
fgets(musteriAdi, sizeof(musteriAdi), stdin);

printf("Recete edilen ilacin adini giriniz : ");
fgets(ilacAdi, sizeof(ilacAdi), stdin);

printf("Ilacin dozaj bilgisini giriniz : ");
fgets(dozaj, sizeof(dozaj), stdin);

fprintf(dosya, "Musteri adi : %sRecete edilen ilac : %sDozaj : %s\n", musteriAdi, ilacAdi, dozaj);

fclose(dosya);
printf("Recete basariyla kaydedildi \n");

return 0;
}

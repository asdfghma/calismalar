#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Ogrenci {
	int numara;
	char ad[20];
	char soyad[20];
	int vize;
};

int main() {
	struct Ogrenci *ogrPtr = (struct Ogrenci *)malloc(5 * sizeof(struct Ogrenci));
	struct Ogrenci *ptr = ogrPtr;
	printf("5 adet ogrenci icin bellekte yer ayrildi\n");
	printf("\n");

	int i = 0;
	int numara;
	char ad[20];
	char soyad[20];
	int vize;

	while (i < 5) {
		printf("%d. ogrenci bilgilerini giriniz : \n", i + 1);
		printf("Numara :"); scanf("%d", &numara);
		printf("Ad :"); scanf("%s", ad);
		printf("Soyad :"); scanf("%s", soyad);
		printf("Vize :"); scanf("%d", &vize);

		ptr->numara = numara;
		strcpy(ptr->ad, ad);
		strcpy(ptr->soyad, soyad);
		ptr->vize = vize;

		i++;
		ptr++;
	}
	ptr = ogrPtr;

	i = 0;
	system("cls");
	printf("Ogrenci kayit islemi tamamlandi kayitli ogrencilerin bilgileri : \n");

	while (i < 5) {
		printf("\n");
		printf("%d numarali ogrenci bilgileri : \n", ptr->numara);
		printf("Ad 		: %s \n", ptr->ad);
		printf("Soyad 		: %s \n", ptr->soyad);
		printf("Vize 		: %d \n", ptr->vize);
		printf("\n");

		i++;
		ptr++;
	}

	free(ogrPtr); 
	return 0;
}


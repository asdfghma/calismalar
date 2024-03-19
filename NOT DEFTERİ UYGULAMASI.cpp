#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void yeni() {
    char dosyaAdi[32];
    char metin[1024];
    int secim;
    char ch;
    printf("Yeni belge olusturma sayfasi \n");
    printf("Dosya adi : "); scanf("%s", dosyaAdi);

    FILE *ptr = fopen(dosyaAdi, "w");

    if (ptr != NULL) {
        printf("%s isimli dosyaniz olusturuldu \n", dosyaAdi);

        do {
            printf("\n1- Metin ekle \n");
            printf("2- Dosya icerigini goster \n");
            printf("3- Dosya icerigini temizle \n");
            printf("4- Ana menuye don \n");
            printf("Seciminiz : "); scanf("%d", &secim);

            switch (secim) {
                case 1:
                    printf("Metin girin : "); scanf(" %[^\n]%*c", metin);
                    ptr = fopen(dosyaAdi, "a");
                    fprintf(ptr, "%s\n", metin);
                    fclose(ptr);
                    printf("Metin eklendi \n");
                    break;
                case 2:
                    ptr = fopen(dosyaAdi, "r");
                    printf("Dosya icerigi \n\n");
                    while ((ch = fgetc(ptr)) != EOF) {
                        printf("%c", ch);
                    }
                    fclose(ptr);
                    break;
                case 3:
                    ptr = fopen(dosyaAdi, "w");
                    fclose(ptr);
                    printf("Dosya icerigi temizlendi \n");
                    break;
                case 4:
                    fclose(ptr);
                    return;
                default:
                    fclose(ptr);
                    printf("Hatali secim ! \n");
                    break;
            }
        } while (secim != 4);
    } else {
        printf("Dosya olusturulamadi ! \n");
    }
}



void ac()
{
	char dosyaAdi[32];
 	char metin[1024];
 	int secim;
 	char ch;
 	system("cls");
 	
	printf("Belge acma sayfasi \n");
	printf("Acmak istediginiz dosya adi : "); scanf("%s",dosyaAdi);
	
	FILE *ptr = fopen(dosyaAdi,"r");
	
	if(ptr != NULL)
	{
		system("cls");
		printf("\%s isimli dosyaniz acildi \n",dosyaAdi);
		
		bas :
		
		printf("\n1- Metin ekle \n");
		printf("2- Dosya icerigini göster \n");
		printf("3- Dosya icerigini temizle \n");
		printf("4- Ana menuye don \n");
		printf("Seciminiz : "); scanf("%d",&secim);
		
		if(secim == 1)
		{
			printf("Metin girin : "); scanf(" [^\n]%s", metin);
			ptr = fopen(dosyaAdi,"a");
			fprintf(ptr, "%s\n", metin);
			fclose(ptr);
			system("cls");
			printf("Metin eklendi \n");
		}
		else if(secim == 2)
		{
			ptr = fopen(dosyaAdi,"r");
			system("cls");
			printf("Dosya icerigi \n\n");
			while( !feof(ptr))
			{
				ch = fgetc(ptr);
				printf("%c",ch);
			}
				fclose(ptr);

		}
		else if(secim == 3)
		{
				
		ptr = fopen(dosyaAdi,"w");
		fclose(ptr);
		system("cls");
		printf("Dosya icerigi temizlendi \n");
		}
		else if(secim == 4)
		{
			fclose(ptr);
			return ;
		}
		else
		{
			system("cls");
			fclose(ptr);
			printf("Hatali secim ! \n");
		}
		
		goto bas;
	}
	
	
	else
	{
		system("cls");
		printf("%s isimli dosya bulunamadý! \n",dosyaAdi);
	}
	
	
}

int menu()
{
	int secim;
	printf("\nNOT DEFTERI \n\n");
	printf("1-Yeni \n");
	printf("2-Ac \n");
	printf("0-Cikis \n");
	printf("\nSeciminiz : "); scanf("%d",&secim);
	
	return secim;		
	
}

int main()
{
	int secim = menu();
	
	while(secim != 0)
	{
		switch(secim)
		{
			case 1 : yeni(); break;
			case 2 : ac(); break;
			case 0 : printf("Cikis yaptýnýz \n"); break;
			default : printf("Hatali secim! \n"); break;
		}
		secim = menu();
	}
	
	return 0;
}

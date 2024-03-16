#include <stdio.h>
#include <string.h>
#include <ctype.h>

int harf_bul(const char *string,char harf,int *ilk_index){
	int adet = 0;
	*ilk_index = -1;
	
	for(int i = 0; string[i] != '\0'; i++){
		if(string[i] == harf && !isspace(string[i])){
			adet++;
			if(*ilk_index == -1){
				*ilk_index = i;
			}
		}
	}
	return adet;
}

int main()
{
	char girilen_string[100];
	char aranan_harf;
	int index,sayi;
	
	printf("Bir string giriniz : ");
	fgets(girilen_string,100,stdin);	
	girilen_string[strcspn(girilen_string,"\n")] = 0;
	printf("Aranan harf degerini giriniz : ");
	scanf(" %c",&aranan_harf);
	
	sayi = harf_bul(girilen_string, aranan_harf,&index);
	
	if(index == -1){
		printf("'%c' harfi string icinde bulunamadý.\n",aranan_harf);
	}
	else {
		printf("'%c' harfi string icinde ilk olarak %d. karakterde ve toplamda %d adet bulunmaktadir.\n",aranan_harf,index + 1, sayi);
		
	}
	return 0;
}

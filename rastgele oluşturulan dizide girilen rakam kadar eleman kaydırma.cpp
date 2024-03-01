#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void dizi_doldur(int *dizi,int boyut){
	srand(time(NULL));
	
	for(int i = 0; i < boyut ;i++){
		dizi[i] = rand() % 100;
	}
}

void dizi_yazdir(int *dizi,int boyut){
	for(int i = 0; i < boyut; i++){
		printf("%d ",dizi[i]);
	}
	printf("\n");
}

void dizi_kaydir(int *dizi, int boyut){
	
	int kaydir;
	printf("Dizi kac eleman kaydirilsin :");
	scanf("%d", &kaydir);
	
	kaydir = kaydir % boyut;

if(kaydir > 0){
	

int temp[kaydir];
for(int i = 0; i < kaydir ; i++){
	temp[i] = dizi[boyut - kaydir +i];
}
for(int i = boyut - 1; i >= kaydir; i--){
	dizi[i] = dizi[i - kaydir];
}
for(int i = 0; i < kaydir; i++){
	dizi[i] = temp[i];
}
}
}

int main(){
	int dizi[20];
	dizi_doldur(dizi, 20);
	
	printf("Dizi:\n");
	dizi_yazdir(dizi, 20);
	
	dizi_kaydir(dizi, 20);
	printf("Kaydirilmis dizi:\n");
	dizi_yazdir(dizi, 20);
	
	return 0;
	
}

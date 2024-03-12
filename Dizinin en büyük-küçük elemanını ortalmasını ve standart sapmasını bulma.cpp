#include <stdio.h>
#include <math.h>
#define BOYUT 10

struct dizi_analizi 
{
	int en_buyuk;
	int en_kucuk;
	float ortalama;
	float standart_sapma;
};

struct dizi_analizi dizi_analiz(int dizi[])
{
	struct dizi_analizi sonuc;
	
	sonuc.en_buyuk = dizi[0];
	sonuc.en_kucuk = dizi[0];
	
	int toplam = 0;
	int karasel_toplam = 0;
	
	for(int i = 0; i < BOYUT ; i++)
	{
		if(dizi[i]  > sonuc.en_buyuk)
		{
			sonuc.en_buyuk = dizi[i];
		}
		
		if(dizi[i] < sonuc.en_kucuk )
		{
			sonuc.en_kucuk = dizi[i];
		}
		
		toplam += dizi[i];
		karasel_toplam += dizi[i] * dizi[i];
	}
	
	sonuc.ortalama = (float) toplam/ BOYUT;
	sonuc.standart_sapma = sqrt((float) karasel_toplam / BOYUT - sonuc.ortalama * sonuc.ortalama);
	
	return sonuc;
}

int main()
{
	int dizi[BOYUT] = {10, 20 ,30 ,40 ,50 ,60 ,70 ,80 ,90 ,100};
	
	struct dizi_analizi sonuc = dizi_analiz(dizi);
	
	printf("dizinin en buyuk elemani : %d\n",sonuc.en_buyuk);
	printf("dizinin en kucuk elemani : %d\n",sonuc.en_kucuk);
	printf("dizinin ortalamasi : %.2f\n",sonuc.ortalama);
	printf("dizinin standart sapmasi : %.2f\n",sonuc.standart_sapma);
	
	return 0;
}






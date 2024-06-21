#include <stdio.h>
#include <math.h>


float daireAlan(float);
float daireCevre(float);
float ucgenAlan(float, float);
float ucgenCevre(float, float, float);
float kareAlan(float);
float kareCevre(float);
float dikdortgenAlan(float, float);
float dikdortgenCevre(float, float);

#define PI 3.14

int main()
{
	int secim;
	float kenar1, kenar2, kenar3, yaricap, alan, cevre;
	
	printf("Geometri Hesap Makinesi\n");
	printf("1. Daire Alani Ve Cevresi Hesaplama\n");
	printf("2. Ucgen Alani Ve Cevresi Hesaplama\n");
	printf("3. Kare Alani Ve Cevresi Hesaplama\n");
	printf("4. Dikdortgen Alani Ve Cevresi Hesaplama\n");
	printf("PI = 3.14\n");
	printf("Seciminiz : ");
	scanf("%d", &secim);
	
	switch(secim) {
		case 1:
			printf("Dairenin yaricapini giriniz : ");
			scanf("%f", &yaricap);
			alan = daireAlan(yaricap);
			cevre = daireCevre(yaricap);
			printf("Dairenin alani : %.2f\n", alan);
			printf("Dairenin cevresi : %.2f\n", cevre);
			break;
			case 2:
				printf("Ucgenin kenar uzunluklarini giriniz (a b c) : ");
				scanf("%f %f %f", &kenar1, &kenar2, &kenar3);
				alan = ucgenAlan(kenar1, kenar2);
				cevre = ucgenCevre(kenar1, kenar2, kenar3);
				printf("Ucgenin alani : %.2f\n", alan);
				printf("Ucgenin cevresi : %.2f\n", cevre);
				break;
				case 3:
					printf("Karenin bir kenar uzunlugunu giriniz : ");
					scanf("%f", &kenar1);
					alan = kareAlan(kenar1);
					cevre = kareCevre(kenar1);
					printf("Karenin alani : %.2f\n", alan);
					printf("Karenin cevresi : %.2f\n", cevre);
					break;
					case 4:
						printf("Dikdortgenin uzun ve kisa kenarlarini giriniz : ");
						scanf("%f %f", &kenar1, &kenar2);
						alan = dikdortgenAlan(kenar1, kenar2);
						cevre = dikdortgenCevre(kenar1, kenar2);
						printf("Dikdortgenin alani : %.2f\n", alan);
						printf("Dikdortgenin cevresi : %.2f\n", cevre);
						break;
						default:
							printf("Gecersiz secim \n");
							break;
	}
	
	return 0;
}

float daireAlan(float yaricap) {
	return PI * yaricap * yaricap;
}

float daireCevre(float yaricap) {
	return 2 * PI * yaricap;
}

float ucgenAlan(float a, float b) {
	return (a * b) / 2;
}

float ucgenCevre(float a, float b, float c) {
	return a + b + c;
}

float kareAlan(float kenar) {
	return kenar * kenar;
}

float kareCevre(float kenar) {
	return kenar * 4;
}

float dikdortgenAlan(float kisaKenar, float uzunKenar) {
	return kisaKenar * uzunKenar;
}

float dikdortgenCevre(float uzunKenar, float kisaKenar) {
	return 2 * (uzunKenar + kisaKenar);
}

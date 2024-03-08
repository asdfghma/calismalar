#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void harfAdetleriniBul(char * ptr)
{
	int enFazlaHarf = 0;
	char harfN;
	
	
	int boyut = strlen(ptr);
	ptr = strlwr(ptr);
	
	int i = 0 , adet = 0;
	printf("Metinin boyu : %d \n",boyut);
	
	char harf = 'a';
	
	while(harf <= 'z')
	{
		i = 0;
		adet = 0;
		while( i < boyut )
		{
			if( harf == ptr[i] )
			adet++; 
			
			i++;
		}
		if(adet != 0)
		printf("\n%c : %d adet ",harf, adet);
		
		if( enFazlaHarf < adet)
		{
			enFazlaHarf = adet;
			harfN = harf;
		}
		harf++;
	}
	printf("\n");
	printf("\nEn fazla adede sahip harf : %c\nAdeti : %d",harfN,enFazlaHarf);
}



int main() {
	char *metin = (char*)malloc(100 * sizeof(char));
	printf("Metin giriniz : "); gets(metin);
	harfAdetleriniBul(metin );
	
	return 0;
}

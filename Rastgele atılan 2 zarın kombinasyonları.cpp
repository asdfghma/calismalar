#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define ATIS_SAYISI 100
#define ZAR_MAX 6

int main()
{
	int zar1, zar2, i;
	int frekans[ZAR_MAX + 1][ZAR_MAX + 1] = {0};
	int maxFrekans = 0;
	int maxZar1 = 0, maxZar2 = 0;
	
	srand(time(NULL));
	
	for (i = 0;i < ATIS_SAYISI; i++)
	{
		zar1 = rand() % ZAR_MAX + 1;
		zar2 = rand() % ZAR_MAX + 1;
		frekans[zar1][zar2]++;
		
		if (frekans[zar1][zar2]>maxFrekans)
		{
			maxFrekans = frekans[zar1][zar2];
			maxZar1 = zar1;
			maxZar2 = zar2;
		}
	 } 
	 
	 for(zar1 = 1; zar1 <= ZAR_MAX; zar1++)
	 {
	 	for(zar2 = 1; zar2 <= ZAR_MAX; zar2++)
	 	{
	 		printf("%d-%d : %d defa\n",zar1,zar2,frekans[zar1][zar2]);
		 }
	 }
	 
	 printf("En fazla denk gelen kombinasyon : %d-%d (%d defa)\n",maxZar1,maxZar2,maxFrekans);
	 return 0;
}

#include <stdio.h>
// REKÜSÝF (ÖZYÝNELÝ) fonskiyonlar


int yazdir (int n)
{
	if( n == 0)
{
	printf("\n");
	return 0;
}
	printf("%d ", n);

	yazdir ( n-1); 
	printf("%d ", n);

}

int topla(int n)
{
	if( n == 0)
	return n;
	
	return n + topla(n - 1);
	
	
}



int faktor(int n)
{
	if ( n == 1)
	return n;
	
	return n * faktor( n - 1) ;
}


int fibonacci(int n)
{
	if ( n == 0 || n == 1)
	return n;
	
	return fibonacci ( n - 1) + fibonacci (n - 2);
}





int main()
{	
	int i;
	for(i = 0; i<10; i++)
	printf("%d  \t  %d \n",i,fibonacci(i));
	return 0;
}











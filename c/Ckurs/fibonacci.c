#include <stdio.h>


int main(){
int hilf,anfang,summe,f,endsumme;

printf("eingabe der fibonacci zahl\n");
scanf("%d", &f);

anfang=0;
summe=1;
endsumme=1;
if(f<=1)printf("fibonacci zahl=%d",f);
else for(int i=3;i<=f;i++){
	
	hilf=summe;
	summe=summe+anfang;
	anfang=hilf;
	endsumme+=summe;

}
printf("fibonacci zahl lautet %d\nsummme der fibonaccizahlen %d\n",summe,endsumme);
	return 0;

}

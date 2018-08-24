#include <stdio.h>
/*Übungsaufgabe C-buch Seite 42 exponentialfunktion*/
int main(){
int e,x;
float last,sum;
printf("Eingabe x, fuer e^x\n");
scanf("%d",&x);
printf("Eingabe e, fuer Genauigkeit\n");
scanf("%u",&e);
if (e>x){
sum=1.0;
last=x*1.0;
for(int k=2;k<=e;k++){
	printf("zwischensumme sum : %3f\n",sum);
	printf("zwischensumme last: %3f\n",last);
	sum=sum+last;
	last=last*x/(k);
}
}else printf("du quatschkopp\n");
}

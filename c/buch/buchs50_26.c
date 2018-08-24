#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define laenge 20
int main (){
int x[laenge];
int y[laenge];
int sum,z;

srand(time(NULL));
z=rand()%laenge;
sum=0;

for (int i=0;i<z;i++){

	x[i]=rand()%100;
	y[i]=rand()%100;
	sum=sum+x[i]*y[i];
	printf("x[%d]=%d  y[%d]=%d\n",i,x[i],i,y[i]);
	printf("aktuelle summe %d\n",sum);
}
}


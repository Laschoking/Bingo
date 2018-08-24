#include <stdio.h>
#include <math.h>
int dual[20];

/*umwandlung einer ganzen Dezimalzahl in eine Dualzahl*/
void swapvorK(int vorK){
int hilf,i;
 
for (hilf=0;hilf<=19;hilf++){
	dual[hilf]=0;
	}
i=9;
do{
	dual[i]=vorK % 2;	
	vorK=vorK/2;
	i--;	
	/*printf("vorkomma %d\n",vorK);*/
	}
while (vorK>0);
}

/*nachkomma zahlen umwandeln*/
void swapnachK(float nachK){
int i;
i=10;
/*printf("Nachkommazahl dezimal: %f\n",nachK);*/
do{
	dual[i]=truncf(2*nachK);
	nachK=fmod((2*nachK),1.0);
	i++;
	/*printf("nachkomma %f\n",nachK);	
	printf("dualzahl%d\n",dual[i]);*/
	}
while(nachK!=1&&i<=19);
}

int main (){
float dezi,nachK;
int vorK,hilf,tmp;
printf("Eingabe einer rationalen Dezimalzahl\n");
scanf("%f",&dezi);

nachK=fmod(dezi,1.0);
vorK=trunc(dezi);

swapvorK(vorK);
swapnachK(nachK);
printf("Dualzahl: ");
tmp=0;
for (hilf=0;hilf<=19;hilf++){
		if (hilf==10)printf(".");
		tmp+=dual[hilf];
		if (tmp!=0)printf("%d",dual[hilf]);
}
printf("\n");
}



#include <stdio.h>
#include <math.h> 

void elements(x){
	puts("alle enthaltenen Elemente");
		for (int i=0;i<x;i++) {
		printf("%d ",i);
		}
	printf("\n");
return 0;
}
int  ggT(m,n){
	int hilf,aus,r;
	r=n;

	while (r>0){
	/*berechnung q,r*/
	aus=r;
	r=m%n;
	m=n; /*uebergabe fuer naechste Berechnug*/
	n=r;
	}
return aus;
}


void einheiten(x,i){
	int g;
	g=ggT(x,i);
	if (g==1)printf("%2d ,ggT: %2d -> Einheit \n",i,g);
	else printf("%2d ,ggT: %2d -> Nullteiler \n",i,g);
return 0;
}

int myPow(int x,int n)
{
    int i; /* Variable used in loop counter */
    int number = 1;

    for (i = 0; i < n; ++i)
        number *= x;

    return(number);
}

void tabelle(x){
	for (int i=1;i<x;i++){
		printf("\n%2d  ",i);
		for(int j=0;j<x;j++){
		printf("%3d ,%3d ,%3d ",myPow(i,j),x,(myPow(i,j)%x));

		}
	}	
puts("");
return 0;
}


int main(){
int x;
printf("Eingabe der Gruppe G(G,*,-1,e)\n");
scanf("%d",&x);

elements(x);
for (int i=1;i<x;i++)
	einheiten(x,i);
/* Anzeigen aller Elemente in G(x)*/
/* Anzeigen aller Einheiten in G(x)*/


/*Tabelle für Multiplikation jeder Zahl mod x bis x-1*/
tabelle(x);

}

#include <stdio.h>

int main()

{

int x[50];
int i,n,tausch,rueckwert;

printf("Angabe zu mischender Zahlen?\n");
scanf("%d", &n);

for (i=1; i== n; i++){

	printf("%2d :" ,i);
	scanf("%d", &x[i]);
}


do {
	rueckwert=0;
	for (i=1 ; i<=n-1 ; i++)

		if (x[i+1]<x[i]) {
			tausch=x[i];
			x[i]=x[i+1];
			x[i+1]=tausch;
			rueckwert=1;
}

} while (rueckwert==1);	


for(i=1;i<=n;i++)
	printf("%3d :%6d\n",i,x[i]);

}

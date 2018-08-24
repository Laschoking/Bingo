#include <stdio.h>

int main(){
int a,b,r,h,n,hilf;

printf("eingabe a: ");
scanf("%d",&a);
printf("eingabe b: ");
scanf("%d", &b);
printf("Eingabe fakultät");
scanf("%d",&n);

r=a;
h=b;
hilf=1;

/*a**b*/
for(int i=2; i<=b; i++){
	r =r*a;
}

/*b**a*/

for(int i=2; i<=a; i++){
        h =h*b;
}

printf("a**b: %d\n", r);
printf("b**a: %d\n",h);

/*fkultät berechnen*/

for(int i=1;i<=n;i++){
	hilf=hilf*i;
}
printf("n!: %d\n", hilf);

	return 0;
}

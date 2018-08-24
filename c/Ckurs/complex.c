#include <stdio.h>
#include <math.h>
#include <complex.h>
struct abscomplex{/*fkt nicht*/
	double a,b;
};

double abs_value(struct abscomplex z){
	double r;
	r=sqrt(z.a*z.a+z.b*z.b);
return r;
	
}


int main(){
double a,b;
printf("Eingabe a Realteil\n");
scanf("%lf",&a);
printf("Eingabe b*i Imaginärteil\n");
scanf("%lf",&b);
printf("absoluter WErt %d\n",abs_value(a,b);
}


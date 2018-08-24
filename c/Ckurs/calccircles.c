#include <stdio.h>
#define pi 3.14

/*Berechnung Radius und Flaeche mittel Pointer*/

void berechnung(float r,float* area,float* circum){
	*area=r*r*pi;
	*circum=2*r*pi;
}

int main(){
float r,area,circum;

r=5.3;
berechnung(r,&area,&circum);
printf("Radius %3f Flaeche %3f Umfang %3f\n", r, area,circum);

return 0;
}

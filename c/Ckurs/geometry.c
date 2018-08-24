#include <stdio.h>

int main()
{

float  pi;
float flaeche, radius, number;
pi=3.14;

	printf("wie groß ist der radius des kreises\n");
	scanf("%f", &radius);

	printf("number:\n");
	scanf("%f", &number);

	flaeche=pi*(radius*radius);
	printf("flaeche:%f\n", flaeche);

if (number<flaeche){
printf("number kleiner als flaeche: 1\n");
}else printf("number >= flaeche:  0\n");
	
return 0;

}


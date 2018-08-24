#include <stdio.h>
/*neuer calculator*/
float  plus(float a,float b){
	return a+b;
}
float multiply(float a,float b){
	return a*b;
}
float minus(float a,float b){
	return plus(a,b*(-1));
}
float divide(float a,float b){
	return multiply(a,1.0/b);
}

int  main(){
float a,b;
int c;

printf("angabe Zahl 1,2, zeichen\n");
scanf("%f\n",&a);
scanf("%f\n",&b);
scanf("%d",&c);
switch (c){
	case 1:printf("%f\n",plus(a,b)); break;
	case 2:printf("%f\n",multiply(a,b)); break;
	case 3:printf("%f\n",minus(a,b));break;
	case 4:printf("%f\n", divide(a,b));break;
	default: printf("bitte was vernüntiges eingeben");break;
}
}

#include <stdio.h>
/*rekursiv schreiben 
Abbruchbedingung
Rekursionsschritt (Selbstaufruf)
wenn n < 3  dann gib 1 zurück
sonst gib fib(n-1) + fin(n-2) zurück
*/
unsigned int fib(unsigned int n){
	if (n<3) return 1;
	return fib(n-1) + fib (n-2);
}
/* b)*/
unsigned int G(unsigned int n){
	if (n<=0) return 0;
	return n-G(G(n-1));
}
unsigned int M(unsigned int); /* deklaration von M*/

/* c)*/
unsigned int F(unsigned int n){
	if (n<=0) return 1;
	return n-M(F(n-1));
}
unsigned int M(unsigned int n){
	if (n<=0) return 0;
	return n-F(M(n-1));
}
int main(){
printf("G(i)");
	for (int i=1;i<=30;i++){
		printf("%d\n ",G(i));
}	
printf("\nF(i)");
	for (int i=1;i<=30;i++){
		printf("%d\n ",F(i));
}
printf("\nM(i)");
	for (int i=1;i<=30;i++){
		printf("%d\n ",M(i));
}
	return 0;
}	

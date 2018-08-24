#include <stdio.h>

int main(){

int wieoft;

printf("Wie oft soll Sheldon klopfen?\n");
scanf("%d", &wieoft);
for (int i=1; i<=wieoft;i++){
	printf("Knock,knock,knock - Penny\n");
}

	return 0;
}

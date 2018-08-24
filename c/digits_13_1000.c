#include <stdio.h>

int main(){
	int array[1000];
	FILE *ifp;
	int c;
	int iData, oldProduct, newProduct, resultDigitCounter, i, k;
	oldProduct = 0;
	iData = 0;
	//Einlesen aus der Datei
	ifp = fopen("thousand_digits.txt", "r");
	while ((c = fgetc (ifp)) != EOF){
		if (c != 10){
			array[iData] = c % 48;
			printf("%d %d \n",array[iData], c);
			iData++;
		}

	}
	printf("\n idata : %d \n", iData);
	fclose(ifp);
/*	for (i = 0; i < 999; i++){
		printf("%d", array[i]);
	
	}
	*/
	puts("jetzt das Ergebnis!!!");

	for (k = 0; k < (999 - 12); k++){
		newProduct = 1;
	
		for(i = 0; i < 12; i++){
			newProduct *= array[i + k];
			}
		if(newProduct > oldProduct){
			oldProduct = newProduct;
			resultDigitCounter = k;
		}
	}
	
	printf("Ergebnis Stelle: %d , finall product %d\n ", resultDigitCounter + 1, oldProduct);
	for(i = 0; i < 13; i++){
		printf("%d", array[i + resultDigitCounter]);
	}
	return 0;
}





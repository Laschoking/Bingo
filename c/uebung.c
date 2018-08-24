#include <stdio.h>

int main(){
	int i,j;
	printf("  0  1\n");

	for (i = 0; i < 2; i++){
		printf("%d",i);
		for (j = 0; j < 2; j++){
			printf(" %d ", i && j);
			}
		puts("");
		}	
	return 0;
	}

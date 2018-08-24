#include <stdio.h>

int main(){

int wieoftknocks,durch;

printf("Wieviele Knocks von Sheldon?\n");
scanf("%d", &wieoftknocks);

printf("anzahl durchläufe\n");
scanf("%d", &durch);

for(int k=1;k<=durch;k++){
	printf("Knock, ");

	for (int i=2; i<=wieoftknocks;i++){
	        printf("knock, ");
	}
printf(" - Penny\n");
}
        return 0;
}
                                                                             
              

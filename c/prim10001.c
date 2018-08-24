#include <stdio.h>
const int True = 1;
const int False = 0;

int main(){
	int n,j,prim,k;
	n = 1;
		for (j = 2; n < 10001; j++){
			k = 2;
			prim = True;
			while(prim == True && k <= j){
				if (j == k){
				       	n++;
					printf("%d: %d \n",n,j);
					k++;
				}
				else{
					if(j % k == 0) prim = False;
					else{
					       	prim = True;	
						k++;
					}
				}
			}
		}			
		return 0;
}



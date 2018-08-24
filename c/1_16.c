#include <stdio.h>

/*And function*/

int main () {

int a,b;
 
printf("AND\n  0 1");

for (a=0;a<=1; a++){
  printf("\n%d ",a);
 

  for (b=0;b<=1;b++){
    printf("%d " , a&&b); /*hier funktion eingeben(||)*/
    }
}
  
printf("\n");
return 0;

}


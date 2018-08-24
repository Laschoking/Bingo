#include <stdio.h>

/*beliebige  function-boolschen wert(=y) bestimmen*/

int main () {
int a,b,c;

printf("a b c y\n--------\n");

for (a=0;a<=1; a++){

  for (b=0;b<=1;b++){

    for(c=0;c<=1;c++){
      printf("%d %d %d %d\n",a,b,c,a&&(b||!c));

}
}
}

printf("\n");
return 0;

}


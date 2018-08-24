#include <stdio.h>

int main()

{
int i,n;
int beginn,niedrig, rueckgabewert, hilf ;

 
printf("anzahl der zu mischenden Zahlen\n");
scanf("%d", &n);
int x[n];

/*einlesen*/

for(i=1; i <= n; i++){

  printf("%2d :", i);
  scanf("%d", &x[i]);
}

 /*sortieren*/
beginn=1;

do {
  rueckgabewert=0;
  niedrig=beginn;
    
  for(i=beginn+1;i<=n;i++) /*beginn bei i=2 */

      if (x[i]<x[niedrig]){
        niedrig=i;
        rueckgabewert=1;
}
  hilf=x[beginn];
  x[beginn]=x[niedrig];
  x[niedrig]=hilf;
  beginn=beginn+1;

} while (rueckgabewert==1);

/*ausgabe*/
for(i=1;i<=n;i++)
        printf("%3d :%6d\n",i,x[i]);

}


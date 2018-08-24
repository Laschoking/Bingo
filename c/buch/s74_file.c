#include <stdio.h>
/*Zahl aus Datei eingelesen*/ 
int main(){
int summe,zahl,status;
FILE *ifp;

zahl=0;
summe=0;
ifp=fopen("zahlen.dat","r");
status=fscanf(ifp,"%d",&zahl);

while(status!=EOF&&zahl>0){
summe+=zahl;
status=fscanf(ifp,"%d",&zahl);
}
fprintf(stdout,"summe der Zahlen %d\n",summe);
fclose(ifp);

}

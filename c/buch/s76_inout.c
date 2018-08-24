/*Programm fuer daten ein/auslesen fgetc,fputc(,)*/

#include <stdio.h>
#include <assert.h>

void main(){
FILE *ifp, *ofp;
char cin, cout;

ifp=fopen("zahlenhin.txt","r");
ofp=fopen("zahlenreuck.txt","w");

assert(getc(ofp)==EOF);/*richtig so?*/

while((cin=fgetc(ifp))!=EOF){
  if (cin==97)cout=122; /*c aendern falls ==a*/
    else cout=cin+5;
fputc(cout,ofp);
}

fclose(ifp);
fclose(ofp);
}

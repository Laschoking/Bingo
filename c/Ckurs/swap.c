/*experts tauschen der Variablen*/
#include <stdio.h>

void linksrechts(char lr,int *d,int *e,int *f){
int tmp;
if (lr=='l'){	
	tmp=*f;
	*f=*e;
	*e=*d;
	*d=tmp;
	}
else{
	tmp=*d;
	*d=*e;
	*e=*f;
	*f=tmp;
	}
}

int main(){
int a,b,c;
char lr;
a=12; b=13; c=14;
printf("links=uhrzeigersinn oder rechts=antiuhrzs. eingaebe l/r\n");
scanf("%c",&lr);
linksrechts(lr,&a,&b,&c);

printf("a neu %d, b neu %d, c neu %d\n",a,b,c);
}

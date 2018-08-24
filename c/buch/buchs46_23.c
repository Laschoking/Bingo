#include <stdio.h>

int main (){
int i,f,c;
int *zi,*zf,*zc;

zi=&i;
zf=&f;
zc=&c;
*zi=25;
*zf=i+15;
*zc=*zi+*zf;
printf("%p %u\n",zi);
printf("%p %u\n",zf);
printf("%p %u\n",zc);

printf("%d\n", i);
printf("%d\n", f);
printf("%d\n", c);

}

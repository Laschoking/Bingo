#include <stdio.h>

int main(){
float x;

for (x=0;x<=10;x++){
	printf("%-3f | ",x);

}
puts("\n--------------------------------------------");
for (x=0;x<=10;x++){
	printf("%+-3f | ",1/x);

}}

#include <stdio.h>

void swap_w(int  *x, int *y){
	int tmp;
	if (*x%2 ==1) (*y)++;
	tmp=*y;
	*y= *x;
	*x= tmp;
}
int main(){
	int x,y;
	x=3;
	y=5;
	
	swap_w(&x,&y);

	printf("%d, %d\n",x,y);
	return 0;
}

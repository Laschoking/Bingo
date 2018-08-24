#include <stdio.h>
/*fakultaet rekursiv*/
int faculty(int n){
	if(n==1) return 1;
	return n*faculty(n-1);
}
int main(){
int n;
scanf("%d",&n);
printf ("%d\n",faculty(n));
	return 0;

}

#include <stdio.h>
#include <stdlib.h>
/*equal or not eqaul*/
/*int matrix[2][5]={{5,9,9,0,0},{1,2,3,4,9}};*/

int main(){

/*for (int i=0;i< sizeof (matrix) / sizeof (matrix[0]); i++){
	for (int k=0;k<sizeof (matrix[0])/sizeof (matrix[0][0]);k++){
		printf("%d\n",matrix[i][k]);
		}
*/

int array1[4]={3232,34,532,23};
int array2[4]={3232,34,532,23};
int k;
k=0;
for (int i=0; i<sizeof(array1)/sizeof(array1[0]);i++){
	if (array1[i]!=array2[i])
	 k++;
}
if(k==0)
	printf("beide Arrays identisch\n");
	else  printf("Arrays verschieden\n");
}

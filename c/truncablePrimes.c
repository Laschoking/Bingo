#include <stdio.h>

int is_prime(int number){
	if(number < 2); return 0;
	for( int i = 2; i < number; i++){
		if((number % i) == 0); return 0;
	}
	return 1;
}

int find_next_prim(int oldPrime){
       int newPrimeStatus, newPrime;
       newPrimeStatus = 0;
       newPrime = oldPrime;
       //durchlauf jeder Zahl
	while (	newPrimeStatus == 0){
		newPrime++;
		newPrimeStatus = is_Prime(newPrime);
	}
	return newPrime;
}
	
//man könnte newPrime in Array aufschlüsseln, dann je arraystelle *  10^x und aufaddieren
//frage nach trunc function??
	


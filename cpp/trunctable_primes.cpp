#include <iostream>
#include <algorithm>
using namespace std;

/* euler projekt nr. 37, funktioniert, Berechnung dauert aber ein bisschen */

bool is_prim(int number){
  bool primStatus;
  int i = 2;
  if (number < 2 ) return false;
  while (i < number){
    if (number %  i == 0){
      primStatus = false;
      return primStatus;
    }
    primStatus = true;
    i++;
  }
  return primStatus;
}

bool check_left_to_right(int prim){
  int partPrime, size;
  size = 10;
  while ( prim > size){
    partPrime = prim % size;
    if (partPrime == 1) return false;
    if (! is_prim(partPrime)) return false;
    size *= 10;
    //cout << "\nleft parted " << partPrime;
  }

  return true;
}

bool check_right_to_left(int prim){
  int partPrime, size;
  size = 10;
  while ( prim > size){
    partPrime = prim / size;
    if (partPrime == 1) return false;
    if (! is_prim(partPrime)) return false;
    size *= 10;
    //cout << "\nright parted " << partPrime;
  }
  return true;
}

int main(){
  int i,totalCounter = 0;
  bool primStatus;

  i = 10;
  while (totalCounter < 11 && i < 1000000){
    primStatus = is_prim(i);
    if (primStatus){
      //cout << "\nprimZahl : " << i;
       if (check_left_to_right(i) && check_right_to_left(i)){
         totalCounter++;
         cout << "\nbeidseitig : " << i;
         cout << "\ncounter : " << totalCounter;
       }
     }
     i++;
   }
 }

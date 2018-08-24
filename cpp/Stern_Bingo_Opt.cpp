//Sternburg Bingo Optimierung
#include <iostream>
#include <stdlib.h>
#include <vector>
#include <algorithm>


using namespace std;
// Einlesen + dauerhaft Speichern von  Kronkorken
// Einlesen +  speichern von Bingo Arrays

vector<int> Kronkorken;
int BingoCards[100][5][5];
int cards = 0;

void getKronkorken(){
        FILE *ifp;
        char c;
        char helper[2];
        int k = 0;
        //Einlesen aus der Datei Kronkorken
        ifp = fopen("Kronkorken.txt", "rw");
        while ((c = fgetc (ifp)) != EOF){
		cout<<  " " << c;
                if (c != ' '){
                        helper[k] = c;
                        k = 1;
                }else{
                        if (k == 1)Kronkorken.push_back(helper[0] * 10 + helper[1]);
                        else {
				Kronkorken.push_back(helper[0]);
				cout << "speichere " << helper[0];
			}
                        k = 0;
                }
        }
	fclose(ifp);
}
//WICHTIG für eingabe von zahlenfolge: zahlen mit blank getrennt, nach satzzeichen kein blank
// 124 =  |   47 =  /  32  = blank 48 = 0
void getBingoCards(){
	FILE *ifp;
	char c;
	char helper[2];
	int row,col,k;
	row = 0;
	col = 0;
        ifp = fopen("BingoCards.txt", "rw");
	while ((c = fgetc (ifp)) != EOF) {
		// / ist umbruch
		if (c == '/'){
			row++;
		       	col = 0;
		}else{ 
			if (c == '|'){
			       	cards++;
				row = 0;
				col = 0;
			}else{
				if (c != ' ' && c != 10){
					helper[k] = c % '0';
					k = 1;
			 		
				}else{
					col++;;
					if (k == 1)BingoCards[cards][row][col] = \
					       	(helper[0] * 10 + helper[1]); 
					else {
						BingoCards[cards][row][col] = helper[0];
						k = 0;
					}
					cout << "speichere " << BingoCards[cards][row][col];
				
				}
			}
		}
	}
	fclose(ifp);
}








		
				
				

int main(){
	getKronkorken();

	getBingoCards();
    
}



import java.io.*;
import java.util.*;
public class Kronkorken {






    public static void main(String[] args) throws FileNotFoundException {
        BingoCardSet card_Set = new BingoCardSet();
        card_Set.readFromFile("src/Kronkorken.dat");
        card_Set.printAllCards();
    }


}



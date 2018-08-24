import java.io.*;
import java.util.*;
public class Kronkorken {






    public static void main(String[] args) throws FileNotFoundException {
        BingoCards card_Set = new BingoCards();
        card_Set.readFromFile("src/Kronkorken.dat");
        card_Set.printAllCards();
    }


}



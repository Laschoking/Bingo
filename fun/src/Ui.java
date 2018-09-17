import java.io.*;
public class Ui {



    public static void main(String[] args) throws FileNotFoundException {
        BingoCardSet card_Set = new BingoCardSet();
        Kronkorken kk = new Kronkorken();
        card_Set.readFromFile("src/BingoKarten.dat");
        //card_Set.printAllCards();
        card_Set.findAllGoals();
        //card_Set.printRemainingGoals();




        kk.readFromFile("src/Kronkorken.dat");
        //kk.printKronkorken();

        Ausbeute ausbeute = new Ausbeute(card_Set.getGoals(),kk.getKronkorken());
        ausbeute.filterGoals();
        ausbeute.printRemainingGoals();
    }
}



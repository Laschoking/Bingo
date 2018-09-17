import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BingoCardSet {

    //private static ArrayList<ArrayList<Integer>> card;

    private static Collection<BingoCard> bingo_cards;

    private static Collection<ArrayList<Integer>> goals_per_card;


    public BingoCardSet(){
        bingo_cards = new LinkedList<>();
        goals_per_card = new LinkedList<>();

    }

    // read in the  https://stackoverflow.com/questions/4769976/reading-2-d-array-from-a-file#4770008




    //Einlesen aller schon eingetragenen Karten aus extra Datei
    public void readFromFile(String file) throws FileNotFoundException {

        BingoCard card = new BingoCard();


        Scanner input = new Scanner(new File(file));

        while (input.hasNextLine()) {
            String tmp = input.nextLine();
            if (tmp.equals(".")) {
                bingo_cards.add(card);
                card.convertCard();
                card = new BingoCard();
            } else {

                Scanner colReader = new Scanner(tmp);
                ArrayList col = new ArrayList();
                while (colReader.hasNextInt()) {
                    col.add(colReader.nextInt());
                }
                card.addColumn(col);
            }
        }
    }

    public void printAllCards(){


        for (BingoCard c : bingo_cards) {
            System.out.print("neues Array");
            c.toCard();
            }
        System.out.println("size liste" + bingo_cards.size());
    }

    public Collection<ArrayList<Integer>> findAllGoals(){


        return null;

    }





}

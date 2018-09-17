import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BingoCardSet {


    private ArrayList<BingoCard> bingo_cards;

    private ArrayList<ArrayList<ArrayList<Integer>>> total_goals;


    public BingoCardSet(){
        bingo_cards = new ArrayList<>();

    }

    // read in the  https://stackoverflow.com/questions/4769976/reading-2-d-array-from-a-file#4770008
    //Einlesen aller schon eingetragenen Karten aus extra Datei
    public void readFromFile(String file) throws FileNotFoundException {

        BingoCard card = new BingoCard();
        int i;

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
                    i = colReader.nextInt();
                    if(i < 1 || i > 99)throw new IllegalStateException("Zahl ungültig");
                    col.add(i);
                }
                card.addColumn(col);
            }
        }
    }

    public void printAllCards(){

        for (BingoCard c : bingo_cards) {
            System.out.print("neues Array");
            c.printCard();
            }
        System.out.println("size liste" + bingo_cards.size());


    }

    public void findAllGoals(){
        total_goals = new ArrayList<>();

        for(BingoCard c : bingo_cards){
                total_goals.add(c.createGoals());
            }
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> getGoals(){
        return total_goals;
    }

    public void printAllGoals(){
        for(ArrayList<ArrayList<Integer>> card : total_goals) {
            System.out.println("new card");

            for (ArrayList<Integer> goal : card){
                System.out.println("new goal");

                for (Integer i : goal) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BingoCard {


    private Array[][] bla;
    private ArrayList<ArrayList<Integer>> number_field;
    private ArrayList<ArrayList<Integer>> goals_per_card;

    public BingoCard(){
        number_field = new ArrayList<>();
        goals_per_card = new ArrayList<>();
        bla = new Array[5][5];
        }

    public void addColumn(ArrayList<Integer> col){
        if(col == null) throw new NullPointerException();
        number_field.add(col);

    }

    public void convertCard(){
        if(number_field.size() != 5 )throw new IndexOutOfBoundsException();
        for(int i = 0;i < 5; i++){
            bla[i] = (Array[]) number_field.get(i).toArray();


        }
        System.out.println("Array" + bla.toString());

    }

    public void toCard(){
        for(ArrayList<Integer> x : number_field){

            for(Integer y : x){
                System.out.print(y + " ");

            }
            System.out.println();
        }
    }

    //gewinnkombinationen pro Karte
    public void createGoals(){
        for(ArrayList<Integer> a : number_field){
            goals_per_card.add(a);
        }


    }





}

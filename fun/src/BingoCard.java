import java.util.ArrayList;

public class BingoCard {


    private Integer[][] number_array;
    private ArrayList<ArrayList<Integer>> number_list;
    private ArrayList<ArrayList<Integer>> goals_per_card;

    public BingoCard() {
        number_list = new ArrayList<>();
        goals_per_card = new ArrayList<>();
        number_array = new Integer[5][5];
    }

    public void addColumn(ArrayList<Integer> col) {
        if (col == null) throw new NullPointerException();
        number_list.add(col);

    }

    public void convertCard() {
        if (number_list.size() != 5) throw new IndexOutOfBoundsException();
        int k = 0, l = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                number_array[i][j] = number_list.get(i).get(j);
            }
        }
    }

    public void printCard() {
        for (ArrayList<Integer> x : number_list) {

            for (Integer y : x) {
                System.out.print(y + " ");

            }
            System.out.println();
        }
    }

    //gewinnkombinationen pro Karte
    public ArrayList<ArrayList<Integer>> createGoals() {
        ArrayList<Integer> goal_w = new ArrayList<>();
        ArrayList<Integer> gaol_s = new ArrayList<>();
        ArrayList<Integer> goal_d1 = new ArrayList<>();
        ArrayList<Integer> goal_d2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> goals = new ArrayList<>();

        int k = 4;


        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                goal_w.add(number_array[x][y]);
                gaol_s.add(number_array[y][x]);

            }
            goal_d1.add(number_array[x][x]);
            goal_d2.add(number_array[x][k]);
            k--;
            goals.add(goal_w);
            goals.add(gaol_s);
            goal_w = new ArrayList<>();
            gaol_s = new ArrayList<>();

        }
        goals.add(goal_d1);
        goals.add(goal_d2);
        return goals;
    }


}

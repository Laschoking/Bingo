import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Ausbeute {

    private ArrayList<ArrayList<ArrayList<Integer>>> total_goals;
    private ArrayList<ArrayList<ArrayList<Integer>>> filtered_by_element_goals;

    LinkedList<Integer> kronkorken;


    public Ausbeute(ArrayList<ArrayList<ArrayList<Integer>>> total_goals,LinkedList<Integer> kronkorken){
        this.kronkorken = kronkorken;
        this.total_goals = total_goals;
        filtered_by_element_goals = total_goals;
    }

    //filtern ob grundsätzlich alle Zahlen des Goals vorhanden
    //falls ein Element i nicht in Kronkorken enthalten wird single_goal aus goals_per_card entfernt
    public ArrayList<ArrayList<ArrayList<Integer>>> filterGoals() throws IllegalStateException{
        Iterator<ArrayList<ArrayList<Integer>>> goals_per_card = filtered_by_element_goals.iterator();
        Iterator<ArrayList<Integer>> single_goal;
        Iterator<Integer> i;

        while (goals_per_card.hasNext()) {
            single_goal = goals_per_card.next().iterator();

            while (single_goal.hasNext()) {

                i = single_goal.next().iterator();

                while (i.hasNext()) {
                    if (!kronkorken.contains(i.next())) {
                        single_goal.remove();
                        break;

                    }
                }
            }
        }
        return filtered_by_element_goals;
    }

    public void printRemainingGoals(){
        for(ArrayList<ArrayList<Integer>> card : filterGoals() ) {
            System.out.print("\n------------new card------------\n");

            for (ArrayList<Integer> goal : card){
                System.out.print("new goal: ");

                for (Integer i : goal) {
                    System.out.print(i + " ");
                }
                System.out.print("\n");
            }
        }
    }

}

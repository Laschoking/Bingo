import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Kronkorken {
    LinkedList<Integer> kronkorken;

    public Kronkorken(){

        kronkorken = new LinkedList<>();
    }

    public void readFromFile(String file) throws FileNotFoundException {
        int i;
        Scanner input = new Scanner(new File(file));

        while(input.hasNextInt()){
            i = input.nextInt();
            if(i < 1 || i > 99)throw new IllegalStateException("Zahl ungültig");
            kronkorken.add(i);
        }
    }

    public LinkedList<Integer> getKronkorken() {
        return kronkorken;
    }

    public void printKronkorken(){
        System.out.println("alle Kronkorken");
        for(Integer i :kronkorken){
            System.out.print(i + " ");
        }
    }
}

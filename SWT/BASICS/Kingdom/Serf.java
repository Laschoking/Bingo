public class Serf extends Peasant{

    public int taxableIncome(){
        if (income < 12) return 0;
        else return income - 12;
    }
}
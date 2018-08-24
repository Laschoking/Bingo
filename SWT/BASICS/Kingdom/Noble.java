public class Noble extends Inhabitant{
    public int tax(){
        if (taxableIncome() * 0.1 < 20) return 20;
        else return (int) (taxableIncome() * 0.1);
    }
}
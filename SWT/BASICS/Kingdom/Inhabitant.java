public class Inhabitant {
  protected int income;

  public int taxableIncome(){

    return income;

  }

  public int tax(){
      int help = (int) (taxableIncome() * 0.1);
    if (help < 1)return 1;
    else return help;

  }

  public void setIncome(int income){
    this.income = income;
  }


}


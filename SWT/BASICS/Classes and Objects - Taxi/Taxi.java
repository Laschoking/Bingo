//Taxi
  public class Taxi extends Human{
    private Human driver;
    private Human[] passenger = new Human[4];
    private int counter = 0;

    // Konstruktor
    public Taxi(Human driver){
      this.driver = driver;
    }
    public Taxi(){}

    public  String getDriverName(){
        return driver.toString();
    }

    public  void add(Human x){
      if (counter >= 4) System.out.println("We are sorry, " + x.toString() + ". The taxi is full.");
      else {
        passenger[counter] = x;
        counter = counter < 4 ? (counter + 1) : 4;
        System.out.println(passenger[counter - 1].toString() + " gets in.");

      }
    }

    public String toString(){
      int i = 0;
      String taxidr = "This is the taxi of " + driver.toString();
      String pass = ". He takes ";
      if (counter == 0) pass += "nobody";
      else{while (i < counter){
          pass += passenger[i].toString();
          i++;
          if (i < counter - 1) pass += ", ";
          if (i == counter - 1) pass += " and ";



        }
      }
      pass += " along.";
      return taxidr + pass;
    }

    public Human[] allGetOut(){
      if(counter == 0){
        Human[] leereListe = new Human[0];
        return leereListe;
      }

      counter = 0;
      return passenger;
    }
  }

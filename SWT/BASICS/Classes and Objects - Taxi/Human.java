public class Human{
  String forename;
  String name;

  public Human(String forename, String name){
    this.forename = forename;
    this.name = name;
  }
  public Human(){}

  String getForename(){
    return forename;
  }

  String getName(){
    return name;
  }


  public String toString(){
    return forename + " " + name ;
    }
}

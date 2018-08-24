public class test{

  public static void main(String[] args){
    Book book = new Book("Java for Dummies");
    System.out.println(book);

    Library library1 = new Library();
    library1.add(book);

    library1.search("Java for Dummies!!");
  }
}

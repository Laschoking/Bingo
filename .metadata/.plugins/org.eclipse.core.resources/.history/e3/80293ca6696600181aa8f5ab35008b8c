import java.util.Collections;

public class Library{
private Book[] bookList = new Book[10];
int i = 0;

  public Library(){
    System.out.println("Hello, I am a library, which can store up to 10 books!");
  }

  public void add(Book book){
    if (i > 9) System.out.println("The library is full!");
    else{
      bookList[i] = book;
      i++;
      System.out.println("I added the book " + book.toString() + "!");
    }
  }

  public Book search(String title){
    Boolean b = false;
    int f = 0;
    while(!b && f < i ){
      if (title == bookList[f].toString()){
        System.out.println("The book with the title " + title + " exists in the library!");
        b = true;
        return bookList[f];
      }f++;

    }
    System.out.println("The book with the title " + title + " does not exist in the library!");
    return null;
  }
  
  public void sortedInsertion(Book newBook) {}
  public Book searchForIsbn(String isbn) {}
  public Book[] searchForAuthor(String author) {}
}

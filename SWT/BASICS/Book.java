public class Book{
  private String title;
  public String isbn;
  private String author;
  
  public Book(String isbn, String author, String title) { }
  
  public Book(String isbn) {}
  
  public String getIsbn() {
	  return isbn;
  }
  
  public String getAuthor() {
	  return author;
  }
  
  public String getTitle() {
	  return title;
  }
  
  public int compareTo(Book b) {}  


  public String toString(){
    return title;
  }

}

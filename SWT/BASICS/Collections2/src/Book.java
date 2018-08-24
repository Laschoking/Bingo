
public class Book implements Comparable<Book>{
    private String isbn;
    private String title;
    private String author;


  public Book(String isbn, String author, String title) {
	  this.isbn = isbn;
	  this.author = author;
	  this.title = title;
  }
  
  public Book(String isbn) {
	  this.isbn = isbn;
	  title = "";
	  author = "";
  }
  
  
  public String getIsbn() { return isbn; }
  
  public String getAuthor() {
	  return author;
  }
  
  public String getTitle() {
	  return title;
  }
    public String toString(){
        return title;
    }

    public int compareTo(Book b) {
	  return isbn.compareTo(b.getIsbn());
  }
}

import java.util.*;
import java.util.Collection;
import java.util.Collections;

public class  Library {
	private List<Book> stock;
	private List<Book> authorBooks;

  public Library(){
		stock = new  ArrayList<Book>();
	 }

  public void sortedInsertion(Book newBook) {
	  stock.add(newBook);
	  Collections.sort(stock);
	  
  }
  public Book searchForIsbn(String isbn) {
	  int index = Collections.binarySearch(stock,new Book(isbn));
	  if (index >= 0)return stock.get(index);
	  else return null;
	  
  }
  public Collection<Book> searchForAuthor(String author) {
	 authorBooks = new ArrayList<Book>();
	 int index = 0; 
	 for(Book b : stock){
		  if (b.getAuthor().equals(author)) {
			 authorBooks.add(stock.get(index));
		 }
		 index++;			 
		 
	 }
	 return authorBooks;
  }
}

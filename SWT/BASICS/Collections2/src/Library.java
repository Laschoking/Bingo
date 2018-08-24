import java.util.*;

public class  Library {
	private Set<Book> stock;
	private List<Book> authorBooks;
	private TreeMap<String,Set<Book>> authorMap;
	private Set<String> authorList;


  public Library(){
		stock = new TreeSet<>();
		authorList = new TreeSet<>();
}

  public boolean insertBook(Book newBook) {
  	authorList.add(newBook.getAuthor());
  	boolean retro = stock.add(newBook);
  	return retro;
  }

  public Book searchForIsbn(String isbn) {

	  for(Book b : stock){
	  	if((b.getIsbn()).equals(isbn)) return b;

	  }return null;
  }
  public Collection<Book> searchForAuthor(String author){
  	authorBooks = new LinkedList<>();
  	for(Book b : stock){
  		if (author.equals(b.getAuthor()))authorBooks.add(b);
	}
	return authorBooks;
  }
  public Map<String,Set<Book>> listStockByAuthor(){
	  authorMap = new TreeMap<>();
	  Set<Book> tmp;
	  for (String a: authorList){
	  	tmp = new HashSet<>(searchForAuthor(a)) ;
	  	authorMap.put(a, tmp);
	  }
	  return authorMap;
	 
  }


}



import java.util.*;

public class PredicateIterator <T extends String>  {

    private ListIterator<T> iter;
    private Predicate<T> pred;
    private T argument;
    //private List<T> helpList = new ArrayList<>();
    ;

    public PredicateIterator(Iterator<T> iter, Predicate<T> pred, T argument) {
        this.iter = (ListIterator) iter;
        this.pred = pred;
        this.argument = argument;
    }

    public boolean hasNext() {

        while(iter.hasNext()){
            if(pred.predicate(iter.next(),argument)){
                iter.previous();
                return true;
            }
        }
        return false;

    }

    public T next(){
        T tmp;

        while(iter.hasNext()){
            tmp = iter.next();
            if(pred.predicate(tmp,argument))return tmp;
        }throw new NoSuchElementException();

    }

    public void remove() {
        if (iter == null) throw new NullPointerException();
        iter.remove();
    }

}

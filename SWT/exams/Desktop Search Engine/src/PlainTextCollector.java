import java.util.Set;
import java.util.TreeSet;

public class PlainTextCollector implements KeywordCollector{
    Set<String> set= new TreeSet<>();
    @Override
    public Set<String> getKeywords(Resource type) {
        if(type == null)throw new NullPointerException();


        TextFileIterator iter = new TextFileIterator(type);
        while(iter.hasNext()){
            set.add(iter.next());

        }

        return set;
    }
}

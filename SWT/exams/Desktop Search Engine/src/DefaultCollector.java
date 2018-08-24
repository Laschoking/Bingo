import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DefaultCollector implements KeywordCollector {
    @Override
    public Set<String> getKeywords(Resource type) {
        Set<String> tmp = new TreeSet<>();
        tmp.add(type.getName());
        return tmp;
    }
}

import java.util.*;
public class PredicateStartsWith<T extends String> implements Predicate<T> {

    @Override
    public boolean predicate(T element, T argument) {
        if (element == null || argument == null)return false;
        else{
            if (element.startsWith(argument))return true;
            else return false;
        }

    }
}

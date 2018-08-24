import java.util.Iterator;

public class PredicateEndsWith<T extends String>  implements Predicate <T> {

    @Override
    public boolean predicate(T element, T argument) {
        if (element == null || argument == null)return false;
        // return letzte Stelle im String
        else {
            if (element.endsWith(argument))return true;
            //if (element.charAt(element.length() - 1) == argument.charAt(argument.length() - 1)) {
            //    return true;
            else return false;
        }
    }
}



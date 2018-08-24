import java.util.*;
public class ResourceType {
    private String description;
    private KeywordCollector collector;

    public ResourceType(String desc, KeywordCollector collector){
        if(desc == null || collector == null) throw new NullPointerException();
        if(desc == "")throw new IllegalArgumentException();

        this.collector = collector;
        this.description = desc;
    }

    public String getDescription(){
        return description;
    }

    public KeywordCollector getCollector(){
        return collector;
    }

}

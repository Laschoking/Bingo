import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Index {
    private Map<String,ArrayList<Resource>> index;

    public Index(){
        index = new HashMap<>();
    }

    public void add(Resource res){
        if (res == null)throw new NullPointerException();
        for( String key : res.getType().getCollector().getKeywords(res)){
            if (!index.containsKey(key)) index.put(key,new ArrayList<Resource>());
            index.get(key).add(res);
        }


    }
    public List<Resource> getResources(String keyword){
        if (keyword == null)throw new NullPointerException();

        if( index.get(keyword) == null) return new ArrayList<>() ;
        else return index.get(keyword);
    }
}

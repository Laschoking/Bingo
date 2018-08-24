import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesktopSearch {
    private Map<String, ResourceType> types;
    Index index;

    public DesktopSearch(){
        types = new HashMap<>();
        index = new Index();

    };

    public void registerType (String extension, ResourceType type){
        if (extension == null || type == null)throw new NullPointerException();

        types.put(extension,type);
    }

    public ResourceType getType(String extension){

        return types.get(extension);
    }

    public void unregisterType(String extension){
        if (extension == null )throw new NullPointerException();
        types.remove(extension);
    }

    public void registerResource(Resource type){
        index.add(type);
    }

    public List<Resource> processRequest(String request) {
        return index.getResources(request);
    }
}

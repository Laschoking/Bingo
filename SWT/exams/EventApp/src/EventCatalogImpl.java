import java.util.*;

public class EventCatalogImpl implements EventCatalog {
    Map<Event,Set<Time>>  map;
    Iterator<Event> iter;


    public EventCatalogImpl(){
        map = new TreeMap<>();
    }

    @Override
    public boolean addCatalogEntry(Event e, Set<Time> tSet) {
        if (tSet == null )throw new NullPointerException();
        if (tSet.contains(null))throw new NullPointerException();
        if (map.containsKey(e)) return false;
        else{//ggf. im set nach invalid times suchen
            map.put(e,tSet);
            return true;
        }
    }

    @Override
    public boolean addTimeToEvent(Event e, Time t) {
        if (t == null )throw new NullPointerException();
        if(!map.containsKey(e))return false;
        Set<Time> set = map.get(e);
        if (set.contains(t))return false;
        set.add(t);
        map.put(e,set);
        return true;
    }

    @Override
    public Set<Event> getAllEvents() {

        return map.keySet();
    }

    @Override
    public Set<Time> getTimesOfEvent(Event e) {
        return map.get(e);
    }

    @Override
    public Map<Event, Set<Time>> filterByEventCategory(EventCategory category) {
        if(category == null) throw new NullPointerException();
        Map<Event,Set<Time>> filteredMap = new TreeMap<>();

        //erzeuge set, da in TreeMap kein Iterator vorhanden
        //TODO 0. element checken ob enhalten, da iter.next() sofort aufgerufen
        for(Map.Entry<Event, Set<Time>> entry : map.entrySet()){
            Event e = entry.getKey();
            Set<Time> tSet = entry.getValue();
            if (e.getCategory() == category) {
                filteredMap.put(e,tSet);
        }


        }

        return filteredMap;
    }

    @Override
    public Set<Time> deleteEvent(Event e) {

        return map.remove(e);
    }

    @Override
    public boolean deleteTime(Event e,Time t) {
        if (e == null || t == null)throw new NullPointerException("fickt euch!");
        if(map.containsKey(e)){
            Set<Time> tmp = map.get(e);
            if (tmp.contains(t)){
                tmp.remove(t);
                map.put(e,tmp);
                return true;
            }
        }
        return false;
    }

}

public class Event implements Comparable<Event>{
    private String title;
    private EventCategory category;

    public Event(String title, EventCategory category){
        if(title == null || category == null)throw new NullPointerException("title null");
        if (title == "") throw new IllegalArgumentException("title leer");
        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public EventCategory getCategory() {
        return category;
    }

    @Override
    public int compareTo(Event o) {
        int compTitle = this.title.compareTo(o.getTitle());;

        if (compTitle != 0) return compTitle;
        else return this.category.compareTo(o.getCategory());
    }
}

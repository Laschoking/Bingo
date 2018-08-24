
public class Bottle <T>{
	private T content;
	private boolean fillStatus = false;
	
	public Bottle() {}
	
	public boolean isEmpty() {
		return !fillStatus;
		
	}
	
	public void fill(T content) {
		this.content = content;
		if (fillStatus == true) throw new IllegalStateException();
		else fillStatus = true;
		
		
	}
	
	public T empty(){
		if (fillStatus == false) throw new IllegalStateException("Fehler in empty");
		else fillStatus = false;
		return content;
		
	}
}

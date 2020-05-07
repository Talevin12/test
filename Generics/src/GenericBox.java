// Generic version of Box

public class GenericBox <T> {
	private T item;
	
	public GenericBox(T t){
		setItem(t);
	}
	
	public void setItem(T t){
		item = t;
	}
	
	public T getItem(){
		return item;
	}
	
	public int itemRepresentationLength(){
		return item.toString().length();
	}
}

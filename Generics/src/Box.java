// non-generic cass
public class Box {
	private Object something;


	public Box(Object o){
		setSomething(o);
	}
	
	public void setSomething(Object o)
	{
		something = o;
	}
	
	public Object getSomething(){
		return something;
	}
	
	public String toString(){
		return something.toString();
	}
	
	public int itemRepresentationLength(){
		return something.toString().length();
	}
}
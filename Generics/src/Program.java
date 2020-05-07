import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		System.out.println("1. The representation length of 56 is:"+representationLength(56));
		System.out.println("The representation length of 12.56 is:"+representationLength(12.56));
		System.out.println("The representation length of \"Good Morning\" is:"+
				representationLength("Good Morning"));
		
		System.out.println("2. The max of {4, 6, 12} is: "+ maxOf3(4, 6, 12));
		System.out.println("The max of {1.64, 26.789, 0.23} is: "+ maxOf3(1.64, 26.789, 0.23));
		//     Compilation error !!!!
		//		System.out.println("The max of {1.64, 2, 0.23} is: "+ maxOf3(1.64, 2, 0.23));
		System.out.println("The max of {one,two,three} is: "+ maxOf3("one","two","three"));
		
		System.out.println("3. The joint representation length of 45 and 3.14 is: "+
				jointRepresentationLength(45, 3.14));
		System.out.println("The joint representation length of \"Good Morning\" and 3.14 is: "+
				jointRepresentationLength("Good Morning", 3.14));
		
		Integer [] arr = {1,2,3,4};
		Double [] darr = {0.123,4.567,8.901};
		String [] sarr = {"one","two","three"};
		System.out.println("4. the multiple representation length of [1,2,3,4] is: "+
						multipleRepresentationLength(arr));
		System.out.println("The multiple representation length of [0.123,4.567,8.901] is: "+
				multipleRepresentationLength(darr));
		System.out.println("The multiple representation length of [0.123,4.567,8.901] is: "+
				multipleRepresentationLength(sarr));
		
		
		// let's play with Box:
		// Box is a polymorphic container
		Box b1 = new Box(45);
		Box b2 = new Box(3.14);
		Box b3 = new Box("Good Morning");
		
		List<Box> list = new ArrayList<>();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		System.out.println("the list is: "+list);
		
		// try to get the contents of a box:
		// must add casting
		Integer num  = (Integer)b1.getSomething();
		
		// let's play with GenericBox
		GenericBox <Integer> g1 = new GenericBox<>(45); 
		GenericBox <Double> g2 = new GenericBox<>(3.14); 
		GenericBox <String> g3 = new GenericBox<>("Good Morning");
		
		Integer num1 = g1.getItem();
		Double d1 = g2.getItem();
		String s1 = g3.getItem();
		
		List <GenericBox> list1 = new ArrayList<>();
		list1.add(g1);
		list1.add(g2);
		list1.add(g3);
		// returns Object, so we need to add casting
		Integer num2 = (Integer)list1.get(0).getItem();
		
		
	}
	
	// non-generic version
/*	public static int representationLength(Double x) {
		return x.toString().length();
	}

	public static int representationLength(Integer x){
		return x.toString().length();
	}
	
	public static int representationLength(String s){
		return s.toString().length();
	}
	*/
	// Generic version:
	public static <T> int representationLength(T x){
		return x.toString().length();
	}
	
	// Parametrized Type as return type of a method
	// Upper Bound of parametrized type
	public static <T extends Comparable<T>> T maxOf3(T x, T y, T z){
		T max = x;
		
		if(max.compareTo(y)<0)
			max = y;
		
		if(max.compareTo(z)<0)
			max = z;

		return max;
	}
	
	public static <T,U> int jointRepresentationLength(T x, U y){
		return representationLength(x) + representationLength(y);
	}
	
	public static <T> int multipleRepresentationLength(T [] a){
		int len = 0,i;
		
		for(i=0;i<a.length;i++)
			len+= (1+ representationLength(a[i])); // add 1 for SPACE between elements
		
		return len-1; // after the last element there is no SPACE
	}

}

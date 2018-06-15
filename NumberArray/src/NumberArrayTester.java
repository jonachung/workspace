
public class NumberArrayTester {

	public static void main(String[] args) {
		int[] array = {3,4,7,11,13};
		NumberArray theArray = new NumberArray(array);
		//System.out.println(theArray.min());
		//System.out.println(theArray.max());
		//System.out.println(theArray.sum());
		//System.out.println(theArray.average());
		//System.out.println(theArray.contains(9));
		//System.out.println(theArray.count(9));
		System.out.println(theArray.swap(0,3));
		theArray.print();
		//System.out.println(theArray.lastIndexOf(13));
		//theArray.print();
		}
}
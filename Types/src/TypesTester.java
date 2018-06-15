
public class TypesTester
{

	public static void main(String[] args)
	{
		Types what = new Types();
		   
		System.out.println("Integer = " + what.identify(0));
		System.out.println("Long = " + what.identify(0l));
		System.out.println("Double = " + what.identify(0.0));
		System.out.println("Float = " + what.identify(0.0f));
		System.out.println("String = " + what.identify("0"));
		System.out.println("Character = " + what.identify('0'));
		System.out.println("Boolean = " + what.identify(true));
		System.out.println("Byte = " + what.identify((byte) 0));
		System.out.println("Short = " + what.identify((short) 0));
	}
}

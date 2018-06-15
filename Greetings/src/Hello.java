
public class Hello {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		String state = "mississippi";
		String part = "issipp";
		System.out.println(state);
		System.out.println(state.length());
		System.out.println(state.toUpperCase());
		System.out.println(state.replace("issipp", "our"));
		System.out.println(state.replace("issipp", "our").toUpperCase().length());
		System.out.println(state.toUpperCase().replace(part.toUpperCase(), "our").toUpperCase());
		
		System.out.println(Integer.MAX_VALUE);
		int checkNumber = 101;
		int lucyCheck = ++checkNumber;
		int linusCheck = checkNumber++;
		System.out.println(lucyCheck);
		System.out.println(linusCheck);
		}

}



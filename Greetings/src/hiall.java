
public class hiall {

	public static void main(String[] args) {
		String country = "United States of America";
		System.out.println(country.indexOf("America"));
		System.out.println(country.substring(17, 24));
		System.out.println(country.substring(country.indexOf("America"), country.length()).toUpperCase());
		System.out.println(country.substring(country.indexOf("United"), country.indexOf(" of")).toUpperCase());
	}

}

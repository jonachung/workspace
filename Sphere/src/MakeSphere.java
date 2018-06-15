
public class MakeSphere {

	public static void main(String[] args) {
		Sphere sphere1 = new Sphere(4);
		Sphere sphere2 = new Sphere(1);
		Sphere sphere3 = new Sphere(0);
		System.out.println(sphere1.getRadius());
		System.out.println(sphere2.getRadius());
		System.out.println(sphere3.getRadius());
		System.out.println(sphere1.getVolume());
		System.out.println(sphere2.getVolume());
		System.out.println(sphere3.getVolume());
		System.out.println(sphere1.getSurfaceArea());
		System.out.println(sphere2.getSurfaceArea());
		System.out.println(sphere3.getSurfaceArea());
	}

}

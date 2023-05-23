
public class Principal {

	public static void main(String[] args) {
		
		
		String a = new String ("hola");
		String b = new String ("hola");
		
		System.out.println(a.hashCode());
		
		System.out.println(b.hashCode());
		
		System.out.println(a == b);
		
		System.out.println(a.equals(b));

	}

}

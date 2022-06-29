
public class corchetesBalancedos {

	public static void main(String[] args) {
		String cadena = "z[a)v}";
		System.out.print(isBalanced(cadena));
	}
	public static String isBalanced(String cadena) {
		String apertura[] = {"{","[","("};
		String clausura[] = {"}","]",")"};
		String secciones[] = new String [cadena.length()];
		for(int i=0; i<cadena.length(); i++) {
			secciones[i]=cadena.substring(i,i+1);
		}
		return "";
		
			
	}

}
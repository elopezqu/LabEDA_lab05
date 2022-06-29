
public class corchetesBalancedos {

	public static void main(String[] args) {
		String cadena = "z[)v}";
		System.out.print(isBalanced(cadena));
	}
	public static String isBalanced(String cadena) {
		String respuesta = "NO";
		String apertura[] = {"{","[","("};
		String clausura[] = {"}","]",")"};
		String secciones[] = new String [cadena.length()];
		if(cadena.length()%2==1)
			return respuesta;
		for(int i=0; i<cadena.length(); i++) {
			secciones[i]=cadena.substring(i,i+1);
		}
		int count=secciones.length/2;
		int comprobacion=0;
		for(int i=0; i<count; i++) {
			int index=-1;
			for(int j=0; j<apertura.length; j++) {
				if(secciones[i].equals(apertura[j])) {
					index=j;
				}
				if(index!=-1 && apertura[index].equals(secciones[index]) && clausura[index].equals(secciones[secciones.length-index-1])) {	
					comprobacion++;
					index=-1;
				}
			}
			if(comprobacion==count)
				respuesta="SI";
		}
		return respuesta;
		
			
	}

}
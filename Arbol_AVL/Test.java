public class Test {
    public static void main(String[] args){
        AVL<Integer> arbol = new AVL<Integer>();
        arbol.insert(6);
        System.out.println(arbol);
        arbol.insert(7);
        System.out.println(arbol);
        arbol.insert(1);
        System.out.println(arbol);
        arbol.insert(3);
        System.out.println(arbol);
        arbol.insert(2);
        System.out.println(arbol);
        System.out.println("Buscar el valor 9: \n"+arbol.search(9));
    }
}
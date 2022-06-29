public class Test {
    public static void main(String[] args){
        AVL<Integer> arbol = new AVL<Integer>();
        arbol.insert(6);
        System.out.println(arbol);
        arbol.insert(5);
        System.out.println(arbol);
        arbol.insert(10);
        System.out.println(arbol);
        arbol.insert(1);
        System.out.println(arbol);
        arbol.remove(6);
        System.out.println(arbol);
        System.out.println("Buscar elemento 5 "+arbol.search(5));

    }
}
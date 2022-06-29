public class Test {
    public static void main(String[] args){
        AVL<Integer> arbol = new AVL<Integer>();
        arbol.insert(1);
        arbol.insert(2);
        arbol.insert(3);
        arbol.insert(4);
        arbol.insert(5);
        arbol.insert(6);

        arbol.remove(4);
        arbol.remove(6);
        System.out.println(arbol);

    }
}

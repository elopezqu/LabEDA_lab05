public class Test {
    public static void main(String[] args){
        AVL<Integer> arbol = new AVL<Integer>();
        arbol.insert(5);
        System.out.println(arbol);
        arbol.insert(6);
        System.out.println(arbol);
        arbol.insert(7);
        System.out.println(arbol);
    }
}
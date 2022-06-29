public class Node<E>{
	// "E" es el tipo de dato genérico
	protected E data;
	protected Node<E> right;
    protected Node<E> left;
	// constructor de "Node"

    public Node(E valor) {
        data = valor;
        right = null;
        left = null;
    }

    public Node(E valor, Node<E> left, Node<E> right) {
        data = valor;
        this.left = left;
        this.right = right;
    }
    
}
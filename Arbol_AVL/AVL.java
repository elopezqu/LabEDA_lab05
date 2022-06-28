public class AVL<T extends Comparable<T>> {

    protected NodeAVL<T> root;

    public AVL() { this.root = null; }

    public void insert(T x){
        NodeAVL<T> nuevo = new NodeAVL<T>(x);
        NodeAVL<T> actual = this.root;
        while(actual != null ){
            if(nuevo.data.compareTo(actual.data)==1){
                actual = (NodeAVL<T>)actual.getRightNode();
            }
            if(nuevo.data.compareTo(actual.data)==-1){
                actual = (NodeAVL<T>)actual.getLeftNode();
            }
        }
        if(actual==null){
            actual = nuevo;
        }
        
    }
    
    public void remove(T x){};
    
    
    protected NodeAVL<T> rotateSR(NodeAVL<T>node) {
        NodeAVL<T>h = (NodeAVL<T>)node.left;
        node.left = h.right;
        h.right = node;
        node = h;
        
        updateHeight(node);
        updateHeight(h);
        return node;
    }
    protected NodeAVL<T> rotateSL(NodeAVL<T>node) {
        NodeAVL<T>h = (NodeAVL<T>)node.right;
        node.right = h.left;
        h.left = node;
        node = h;
        
        updateHeight(node);
        updateHeight(h);
        
        return node;
    }
    protected NodeAVL<T> rotateDSR(NodeAVL<T>node){
        node.left = rotateSL((NodeAVL<T>)node.getLeftNode());
        return rotateSR(node);
   
    }
    protected NodeAVL<T> rotateDSL(NodeAVL<T>node){
        node.right = rotateSR((NodeAVL<T>)node.getLeftNode());
        return rotateSL(node);
    }
    private void updateHeight(NodeAVL<T> node){
        int leftHeight = height((NodeAVL<T>)node.left);
        int rightHeight = height((NodeAVL<T>)node.right);
        
        node.setFE( Math.max(leftHeight, leftHeight)+1 );
    }
    private int height(NodeAVL<T> node){
        if(node == null)
            return -1;
        return node.fe;
    }
    private int factorEquilibrio(NodeAVL<T> node){
        return height((NodeAVL<T>)node.right) - height((NodeAVL<T>)node.left);
    }
    
}
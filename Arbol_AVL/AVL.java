public class AVL<T extends Comparable<T>> {

    protected NodeAVL<T> root;

    public AVL() { this.root = null; }

    public String search(T x){
        NodeAVL<T> res = searchNode(x, (NodeAVL<T>)this.root);
        if(res != null && res.data==x){
            return "El dato se encuentra en el arbol";
        }
        return "El dato no se encuentra en el arbol";
    }

    private NodeAVL<T> searchNode(T x, NodeAVL<T> n){
        if (n == null) {
            return null;
        } else {
            int resC = n.data.compareTo(x);
            if (resC < 0) {
                return searchNode(x, (NodeAVL<T>)n.right);
            } else if (resC > 0) {
                return searchNode(x, (NodeAVL<T>)n.left);
            } else {
                return n;
            }
        }
    }

    public void insert(T x) {
        this.root = insertRec(x, this.root);
    }
    protected NodeAVL<T> insertRec(T x, NodeAVL<T> current){
        NodeAVL<T> res = current;
        if(current == null){
            res = new NodeAVL<T>(x);
        }else{
            int resC = current.data.compareTo(x);
            if(resC == 0){
                return null;
            }
            if (resC < 0) 
                res.right = insertRec(x, (NodeAVL<T>)current.right);
            else
                res.left = insertRec(x, (NodeAVL<T>)current.left);
        }
        updateHeight(res);
        return rectructuration(res);
    }
    protected NodeAVL<T> rotateSR(NodeAVL<T> node) {
        NodeAVL<T> h = (NodeAVL<T>) node.left;
        node.left = h.right;
        h.right = node;
        
        updateHeight(node);
        updateHeight(h);
        return h;
    }
    protected NodeAVL<T> rotateSL(NodeAVL<T> node) {
        NodeAVL<T> h = (NodeAVL<T>) node.right;
        node.right = h.left;
        h.left = node;

        updateHeight(node);
        updateHeight(h);
        return h;
    }
    protected NodeAVL<T> rotateDSR(NodeAVL<T>node){
        node.left = rotateSL((NodeAVL<T>)node.left);
        return rotateSR(node);
    }
    protected NodeAVL<T> rotateDSL(NodeAVL<T>node){
        node.right = rotateSR((NodeAVL<T>)node.right);
        return rotateSL(node);
    }
    
    public void remove(T x){
        this.root = removeRec(x,this.root);
    }
    private NodeAVL<T> removeRec(T x, NodeAVL<T> actual) {
        NodeAVL<T> res = actual;
        if(actual == null){
            System.out.println("No such data present in BST");
            return null;
        }
        int resC = actual.data.compareTo(x);
        if (resC < 0) {
            res.right = removeRec(x, (NodeAVL<T>)actual.right);
        }else if(resC > 0){
            res.left = removeRec(x, (NodeAVL<T>)actual.left);
        }else if(actual.left != null && actual.right != null){ // dos hijos
            res.data = minRecover((NodeAVL<T>)actual.right).data;
            res.right = minRemove((NodeAVL<T>)actual.right);
        }else {// 1 hijo o ninguno
            res = (actual.left != null) ? (NodeAVL<T>)actual.left : (NodeAVL<T>)actual.right;
        }
        if(res == null)
            return null;
        updateHeight(res);
        return rectructuration(res);
    }

    private NodeAVL<T> rectructuration( NodeAVL<T> node){
        int fe = factorEquilibrio(node);
        if(fe < -1){
            if(factorEquilibrio((NodeAVL<T>)node.left) <= 0)
                node = rotateSR(node);
            else
                node = rotateDSR(node);
        }
        if(fe > 1){
            if(factorEquilibrio((NodeAVL<T>)node.right) >= 0)
                node = rotateSL(node);
            else
                node = rotateDSL(node);
        }
        return node;
    }

    protected NodeAVL<T> minRemove(NodeAVL<T> actual){
        if (actual.left != null){
            actual.left = minRemove((NodeAVL<T>)actual.left);
        }
        else{
            actual =(NodeAVL<T>)actual.right;
        }
        return actual;
    }

    protected NodeAVL<T> minRecover(NodeAVL<T> actual){
        if(actual.left != null){
            return minRecover((NodeAVL<T>)actual.left);
        }
        else{
            return actual;
        }
    }

    public String toString() {
        if (this.root == null) {
            return "Arbol vacio...";
        }
        return postOrden(this.root);
    }

    private String postOrden(NodeAVL<T> current) {
        String str = "";
        if (current.left != null)
            str += postOrden((NodeAVL<T>) current.left);
        if (current.right != null)
            str += postOrden((NodeAVL<T>) current.right);
        str += current.data + "[" + current.fe + "], ";
        return str;
    }
    private int height(NodeAVL<T> node){
        if(node == null)
            return -1;
        return node.fe;
    }
    private void updateHeight(NodeAVL<T> node){
        int leftHeight = height((NodeAVL<T>)node.left);
        int rightHeight = height((NodeAVL<T>)node.right);
        node.setFE( Math.max(leftHeight, rightHeight)+1 );
    }
    private int factorEquilibrio(NodeAVL<T> node){
        return height((NodeAVL<T>)node.right) - height((NodeAVL<T>)node.left);
    }
}
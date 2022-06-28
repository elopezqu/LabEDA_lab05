public class AVL<T extends Comparable<T>> {

    protected NodeAVL<T> root;

    public AVL() { this.root = null; }

    public void insert(T x) {
        this.root = insertRec(x, this.root);
    }
    private NodeAVL<T> insertRec(T x, NodeAVL<T> current){
        NodeAVL<T> res = current;
        if(current == null){
            res = new NodeAVL<T>(x);
        }else{
            int resC = current.data.compareTo(x);
            if(resC < 0){
                res.right = insertRec(x,(NodeAVL<T>)current.right);
            }
            else{
                res.left = insertRec(x,(NodeAVL<T>)current.left);
            }
        }
        return res;
    }

    public void remove(T x) {
    };

    protected NodeAVL<T> rotateSR(NodeAVL<T> node) {
        NodeAVL<T> h = (NodeAVL<T>) node.left;
        node.left = h.right;
        h.right = node;
        node = h;

        updateHeight(node);
        updateHeight(h);
        return node;
    }

    protected NodeAVL<T> rotateSL(NodeAVL<T> node) {
        NodeAVL<T> h = (NodeAVL<T>) node.right;
        node.right = h.left;
        h.left = node;
        node = h;

        updateHeight(node);
        updateHeight(h);

        return node;
    }

    protected NodeAVL<T> rotateDSR(NodeAVL<T> node) {
        node.left = rotateSL((NodeAVL<T>) node.right);
        return rotateSR(node);

    }

    protected NodeAVL<T> rotateDSL(NodeAVL<T> node) {
        node.right = rotateSR((NodeAVL<T>) node.left);
        return rotateSL(node);
    }

    private void updateHeight(NodeAVL<T> node) {
        int leftHeight = height((NodeAVL<T>) node.left);
        int rightHeight = height((NodeAVL<T>) node.right);

        node.setFE(Math.max(leftHeight, leftHeight) + 1);
    }

    private int height(NodeAVL<T> node) {
        if (node == null)
            return -1;
        return node.fe;
    }

    private int factorEquilibrio(NodeAVL<T> node) {
        return height((NodeAVL<T>) node.right) - height((NodeAVL<T>) node.left);
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
            str += postOrden((NodeAVL<T>)current.left);
        if (current.right != null)
            str += postOrden((NodeAVL<T>)current.right);
        str += current.data.toString() + ", ";
        return str;
    }

}
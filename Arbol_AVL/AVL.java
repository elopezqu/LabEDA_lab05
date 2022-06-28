public class AVL<T extends Comparable<T>> {

    protected NodeAVL<T> root;
    protected boolean altura;

    public AVL() { this.root = null; }

    public void insert(T x) {
        this.altura = false;
        this.root = insertRec(x, this.root);
    }
    private NodeAVL<T> insertRec(T x, NodeAVL<T> current){
        NodeAVL<T> res = current;
        if(current == null){
            altura = true;
            res = new NodeAVL<T>(x);
        }else{
            int resC = current.data.compareTo(x);
            if(resC < 0){
                res.right = insertRec(x,(NodeAVL<T>)current.right);
                if(this.altura){
                    switch(res.fe){
                        case -1 : res.fe = 0; this.altura = false; break;
                        case 0  : res.fe = 1; this.altura = true; break;
                        case 1  : //res.fb = 2
                                  res = balanceToLeft(res);
                                  this.altura = false;
                    }
                }
            }
            else{
                res.left = insertRec(x,(NodeAVL<T>)current.left);
                if(this.altura){
                    switch(res.fe){
                        case 1 : res.fe = 0; this.altura = false; break;
                        case 0  : res.fe = -1; this.altura = true; break;
                        case -1  : //res.fb = 2
                                  res = balanceToRight(res);
                                  this.altura = false;
                    }
                }
            }
        }
        return res;
    }
    protected NodeAVL<T> rotateSR(NodeAVL<T> node) {
        NodeAVL<T> h = (NodeAVL<T>) node.left;
        node.left = h.right;
        h.right = node;
        node = h;
        return node;
    }
    protected NodeAVL<T> rotateSL(NodeAVL<T> node) {
        NodeAVL<T> h = (NodeAVL<T>) node.right;
        node.right = h.left;
        h.left = node;
        node = h;
        return node;
    }
    private NodeAVL<T> balanceToLeft(NodeAVL<T> node){
        NodeAVL<T> ind = (NodeAVL<T>)node.right;
        switch(ind.fe){
            case 1  : node.fe = 0;
                      ind.fe = 0;
                      node = rotateSL(node); 
                      break;
            case -1 : NodeAVL<T> grandInd= (NodeAVL<T>)ind.left;
                      switch(grandInd.fe){
                        case -1 : node.fe = 0; ind.fe = -1; break;
                        case 0  : node.fe = 0; ind.fe = 0; break;
                        case 1  : node.fe = 1; ind.fe = 0; break;
                      }
                      grandInd.fe = 0;
                      node.right = rotateSR(ind);
                      node = rotateSL(node);
        }
        return node;
    }
    private NodeAVL<T> balanceToRight(NodeAVL<T> node){
        NodeAVL<T> ind = (NodeAVL<T>)node.left;
        switch(ind.fe){
            case 1  : node.fe = 0;
                      ind.fe = 0;
                      node = rotateSR(node); 
                      break;
            case -1 : NodeAVL<T> grandInd= (NodeAVL<T>)ind.right;
                      switch(grandInd.fe){
                        case -1 : node.fe = 0; ind.fe = 1; break;
                        case 0  : node.fe = 0; ind.fe = 0; break;
                        case 1  : node.fe = -1; ind.fe = 0; break;
                      }
                      grandInd.fe = 0;
                      node.right = rotateSL(ind);
                      node = rotateSR(node);
        }
        return node;
    }
    
    public void remove(T x) {
    };


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
            str += current.data + "[" + current.fe +"], ";
        return str;
    }

}
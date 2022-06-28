public class NodeAVL<T> extends Node<T>{
    protected int fe;
    public NodeAVL(T data, NodeAVL<T>left, NodeAVL<T> right ){
        super(data, left, right);
        this.fe=0;
    }
    public NodeAVL(T data){
        this (data,null,null);
    }
    public void setFE(int fe){
        this.fe = fe;
    }
    public int getFE(){
        return fe;
    }
}
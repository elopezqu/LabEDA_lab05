
package corchetees;

public class Corchetes {

  public static void main(String[] args) {
    System.out.println("Hello World!");
    String cadena = "{([()]}}";
    Node node = new Node();
    for (int i=0; i<(cadena.length())/2; i++){
      System.out.println(cadena.charAt(i));
    }
    node = generarArbol(node, cadena);
    System.out.println(PreOrden(node));
    
    System.out.println(isBalanced(cadena, node));
  }
  public static Node generarArbol(Node node, String cadena){
    int mitad = (cadena.length()/2);

    Node actual = new Node();
    actual = node;
    for (int i=0; i<(cadena.length())/2; i++){
        String caracter = String.valueOf(cadena.charAt(i));
        actual.setLeft(new Node(caracter));
        if(caracter.equals("{")){
          actual.setRight(new Node("}"));
        }
        else if(caracter.equals("[")){
          actual.setRight(new Node("]"));
        }
        else if(caracter.equals("(")){
          actual.setRight(new Node(")"));
        }
        actual = actual.getLeft();
    }
    return node;
  }

  public static String PreOrden(Node node){
    String preOrden = "";
    if(node.getRight() == null && node.getLeft() == null){
      preOrden = node.getData();
    }
    else if(node.getLeft() == null && !(node.getRight() == null)){
      preOrden = node.getData()+PreOrden(node.getRight());
    }
    else if(node.getRight() == null && !(node.getLeft() == null)){
      preOrden = node.getData()+PreOrden(node.getLeft());
    }
    else{
    preOrden = node.getData()+PreOrden(node.getLeft())+PreOrden(node.getRight());
    }
    return preOrden;
  }
  public static String isBalanced(String cadena, Node node) {

    String respuesta = "";
    String correct = PreOrden(node);
    if(cadena.equals(correct)){
      respuesta = "SÍ";
    }
    else{
      respuesta = "NO";
    }
    return respuesta;
  }
}

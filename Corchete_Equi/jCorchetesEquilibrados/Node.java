/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corchetees;

/**
 *
 * @author jordy
 */
public class Node {
    private String data;
  private Node left;
  private Node right;


  public Node(String data, Node left, Node right){
    this.data = data;
    this.left = left;
    this.right = right;
  }
  public Node(String data){
    this(data,null, null);
  }
  public Node(){
    this("",null, null);
  }

  //getters, setters
  public String getData(){
    return data;
  }
  public void setData(String data){
    this.data = data;
  }

  public Node getLeft(){
    return left;
  }
  public void setLeft(Node left){
    this.left = left;
  }
  
  public Node getRight(){
    return right;
  }
  public void setRight(Node right){
    this.right = right;
  }
}

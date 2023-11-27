package co.edu.unbosque.util.algorithm;

import co.edu.unbosque.util.Edge;
import co.edu.unbosque.util.MyLinkedList;
import co.edu.unbosque.util.Vertex;

//Código java que implementa Tree Sort 

public class TreeSort {
  
  //Clase conteniendo hijo izquierdo
  //y derecho del nodo actual, y 
  // el valor del nodo (Key)
  // Raiz del arbol de busqueda
  //binaria
  static Vertex root;
  
  static void init() {
      root = null;
  }
  static void insert(Vertex newVertex) {
      root = insertRec(root, newVertex.getKey());
  }

  /*Una función recursiva que inserta 
  nuevos valores al arbol de busqueda binaria*/
  static Vertex insertRec(Vertex root, int key) {
      /*Si el arbol esta vacio
      Retorne un nuevo nodo*/
      if (root == null) {
          root = new Vertex(key);
          return root;
      }
      /*De otra forma, baja por el arbol*/
      if (key < root.getKey()) {
    	  Vertex left = root.getLeft();
          left = insertRec(root.getLeft(), key);
          root.setLeft(left);
//          root.addEdge(new Edge(root, left, 0.0));
      } else if (key > root.getKey()) {
    	  Vertex right = root.getRight();
          right = insertRec(root.getRight(), key);
          root.setRight(right);
//          root.addEdge(new Edge(root, right, 0.0));
      }
      /*Retorna la raiz*/
      return root;
  }

  /*Una función que realiza recorrido
  inorden atraves del arbol*/
  static void inorderRec(Vertex root) {
      if (root != null) {
          inorderRec(root.getLeft());
          System.out.print(root.getKey() + " ");
          inorderRec(root.getRight());
      }
      System.out.println(" ");
  }
  
  static void preorderRec(Vertex root) {
	  if(root != null) {
		  System.out.print(root.getKey() + " ");
		  preorderRec(root.getLeft());
		  preorderRec(root.getRight());
	  }
	  System.out.println(" ");
  }
  
  static void postorderRec(Vertex root) {
	  if(root != null) {
		  postorderRec(root.getLeft());
		  postorderRec(root.getRight());
		  System.out.print(root.getKey() + " ");
	  }
	  System.out.println(" ");
  }

  static void treeins(MyLinkedList<Vertex> arr) {
      for (int i = 0; i < arr.size(); i++) {
          insert(arr.get(i).getInfo());
      }
  }

  public static void main(String[] args) {
      MyLinkedList<Vertex> arr = new MyLinkedList<Vertex>();
      arr.add(new Vertex(5));
      arr.add(new Vertex(4));
      arr.add(new Vertex(7)); 
      arr.add(new Vertex(2));
      arr.add(new Vertex(11));
      treeins(arr);
      inorderRec(root);
      postorderRec(root);
      preorderRec(root);
  }
}

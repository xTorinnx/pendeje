package co.edu.unbosque.util;
import java.util.ArrayList;

public class Vertex {
	
	private String name;
	private MyLinkedList<Edge> edges;
	private int key;
	private Vertex left, right;
	
	public Vertex(String name) {
		this.name=name;
		this.edges=new MyLinkedList<Edge>();		
	}
	
	public Vertex(int item) {
        this.key = item;
        this.left = this.right = null;
    }

	public Vertex() {
		// TODO Auto-generated constructor stub
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Vertex getLeft() {
		return left;
	}

	public void setLeft(Vertex left) {
		this.left = left;
	}

	public Vertex getRight() {
		return right;
	}

	public void setRight(Vertex right) {
		this.right = right;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyLinkedList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(MyLinkedList<Edge> edges) {
		this.edges = edges;
	}

	public void addEdge(Edge newEdge) {
		edges.add(newEdge);
	}

	@Override
	public String toString() {
		return "\nVertex [name=" + name + ", edges=" + edges + "]";
	}

	
	
	

}

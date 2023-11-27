package co.edu.unbosque.util;

public class GTNode<T> {
	
	private T key;
	private MyLinkedList<GTNode<T>> children;

	public GTNode() {
		children = new MyLinkedList<GTNode<T>>(); // TODO Auto-generated constructor stub
	}

	public GTNode(T key, MyLinkedList<GTNode<T>> children) {
		super();
		this.key = key;
		this.children = children;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public MyLinkedList<GTNode<T>> getChildren() {
		return children;
	}

	public void setChildren(MyLinkedList<GTNode<T>> children) {
		this.children = children;
	}

}

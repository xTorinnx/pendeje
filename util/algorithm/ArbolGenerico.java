package co.edu.unbosque.util.algorithm;

import java.io.File;

import co.edu.unbosque.util.GTNode;
import co.edu.unbosque.util.QueueImp;

public class ArbolGenerico {

	public static GTNode<Object> addNewNode(int key) {
		GTNode<Object> temporal = new GTNode<Object>();
		temporal.setKey(key);
		return temporal;
	}

	public static void atravesarArbolNiveles(GTNode<Object> raiz) {
		if (raiz == null) {
			return;
		}
		QueueImp<GTNode<Object>> cole = new QueueImp<GTNode<Object>>();
		cole.enqueue(raiz);
		while (!cole.isEmpty()) {
			int n = cole.size();
			while (n > 0) {
				GTNode<Object> current = cole.dequeue();
				System.out.println(current.getKey() + " ");
				for (int i = 0; i < current.getChildren().size(); i++) {
					cole.enqueue(current.getChildren().get(i).getInfo());
				}
				n--;
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		GTNode<Object> raiz = new GTNode<Object>();
		raiz.setKey(0);
		raiz.getChildren().add(addNewNode(1));
		raiz.getChildren().add(addNewNode(2));
		raiz.getChildren().add(addNewNode(3));
		raiz.getChildren().add(addNewNode(4));
		raiz.getChildren().get(0).getInfo().getChildren().add(addNewNode(5));
		raiz.getChildren().get(0).getInfo().getChildren().add(addNewNode(6));
		raiz.getChildren().get(1).getInfo().getChildren().add(addNewNode(7));
		raiz.getChildren().get(2).getInfo().getChildren().add(addNewNode(8));
		raiz.getChildren().get(2).getInfo().getChildren().add(addNewNode(9));
		raiz.getChildren().get(2).getInfo().getChildren().add(addNewNode(10));
		raiz.getChildren().get(3).getInfo().getChildren().add(addNewNode(11));

		atravesarArbolNiveles(raiz);
		atravesarArbolNiveles(raiz.getChildren().get(1).getInfo());
	}
}

package pucrs.alpro2.listas;

public class ListSimpleLinked<E> implements ListTAD<E> {

	private Node<E> head;
	private Node<E> tail;
	private int count;

	private class Node<E> {
		public E element;
		public Node<E> next;

		public Node(E e) {
			element = e;
			next = null;
		}
	}

	// Construtor
	public ListSimpleLinked() {
		clear();
	}

	@Override
	public void add(E e) {
		Node<E> novo = new Node<>(e);
		if (isEmpty()) {
			head = novo; // c) Agora, o primeiro nodo passa a ser o novo
		} else {
			tail.next = novo; // b) Apontar do último para o novo
		}
		tail = novo;
		count++;
	}

	@Override
	public void add(int index, E element) {

		if (index < 0 || index > count)
			throw new IllegalArgumentException("Indice invalido: " + index);

		Node<E> novo = new Node<>(element);

		if (isEmpty()) {
			head = novo;
			tail = novo;
		} else if (index == 0) {
			novo.next = head;
			head = novo;
		} else {
			Node<E> ant = head;
			Node<E> target;
			for (int i = 0; i < index - 1; i++) {
				ant = ant.next;
			}
			target = ant.next;
			ant.next = novo;
			novo.next = target;
			if (target == null) {
				tail = novo;
			}
		}
		count++;

	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= count)
			throw new IllegalArgumentException("Indice invalido: " + index);

		Node<E> n = head;
		for (int i = 0; i < index; i++) {
			n = n.next;
		}

		return n.element;
	}

	@Override
	public int indexOf(E e) {
		Node<E> n = head;
		int c = 0;
		while (n != null) {
			if (e.equals(n.element))
				return c;
			c = c + 1;
			n = n.next;
		}
		return -1;
	}

	@Override
	public void set(int index, E element) {
		if (index < 0 || index >= count)
			throw new IllegalArgumentException("Indice invalido: " + index);

		Node<E> n = head;
		for (int i = 0; i < index; i++) {
			n = n.next;
		}

		n.element = element;

	}

	@Override
	public boolean removeObject(E e) {
		return removeAt(indexOf(e)) != null;
	}

	public boolean removeLast(E element) {
		// int pos = -1;
		// for (int i = 0; i < this.size(); i++) {
		// if (element.equals(this.get(i))) {
		// pos = i;
		// }
		// }
		// if (pos == -1)
		// return false;
		// removeAt(pos);
		// return true;

		Node<E> n = head;
		Node<E> target = null;
		Node<E> ant = null;
		Node<E> antTarget = null;

		while (n != null) {
			if (element.equals(n.element)) {
				target = n;
				antTarget = ant;
			}
			ant = n;
			n = n.next;
		}
		if (target == null)
			return false;
		count--;
		if (target == head)
			head = target.next;
		else
			antTarget.next = target.next;
		if (target == tail)
			tail = antTarget;
		return true;
	}

	@Override
	public E removeAt(int index) {
		if (index < 0 || index >= count)
			throw new IllegalArgumentException("Indice invalido: " + index);

		E value;

		if (head == tail) {
			value = head.element;
			head = tail = null;
		} else if (index == 0) {
			value = head.element;
			head = head.next;
		} else {
			Node<E> ant = head;
			Node<E> target;
			for (int i = 0; i < index - 1; i++) {
				ant = ant.next;
			}
			target = ant.next;
			value = target.element;
			if (target != null)
				target = target.next;
			ant.next = target;

			if (target == null)
				tail = ant;
		}
		count--;
		return value;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean contains(E e) {
		return indexOf(e) != -1;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		count = 0;
	}

	@Override
	public String toString() {
		Node<E> n = head;
		String s = "[";

		while (n != null) {
			if (n == head)
				s += n.element;
			else
				s += ",  " + n.element;
			n = n.next;
		}
		s += "]";
		return s;
	}

	public void dump() {
		Node<E> n = head;
		System.out.printf("Head: %d\n", head == null ? null : head.hashCode());
		System.out.printf("Tail: %d\n", tail == null ? null : tail.hashCode());

		System.out.println("[");
		while (n != null) {
			if (n == head)
				System.out.printf("%d (%d)\n", n.element, n.hashCode());
			else
				System.out.printf(",  %d (%d)\n", n.element, n.hashCode());
			n = n.next;
		}
		System.out.println("]");
	}

	/**
	 * O(n)
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public ListSimpleLinked<E> subList(int i, int j) {
		ListSimpleLinked<E> resposta = new ListSimpleLinked<E>();

		if (i < 0)
			throw new IndexOutOfBoundsException("Índice inicial inválido: " + i);
		if (j > size())
			throw new IndexOutOfBoundsException("Índice final inválido: " + j);
		if (i > j)
			throw new IndexOutOfBoundsException(
					"Índice inicial maior do que o final");

		if (i == j)
			return resposta;

		Node<E> n = head;
		for (int k = 0; k < i; k++) {
			n = n.next;
		}
		for (int k = i; k < j; k++) {
			resposta.add(n.element);
			n = n.next;
		}
		return resposta;
	}

}

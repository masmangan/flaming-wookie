package pucrs.alpro2.listas;

import java.util.Arrays;

public class ListArray<E> implements ListTAD<E> {
	private Object[] data;
	private int count;

	public ListArray() {
		this(10); // chama o construtor com tamanho 10 (default)
	}

	public ListArray(int c) {
		data = new Object[c];
		count = 0;
	}

	// /
	@Override
	public void add(E element) {
		if (element == null)
			throw new IllegalArgumentException(
					"A lista não permite armazenar null.");
		grow();
		data[count] = element;
		count++;
	}

	private void setCapacity(int newCapacity) {
		if (newCapacity != data.length) {
			int min = 0;
			Object[] newData = new Object[newCapacity]; // B

			// min armazena a menor capacidade: atual ou nova
			min = data.length < newCapacity ? data.length : newCapacity;

			// Copia os elementos de data para newData
			for (int i = 0; i < min; i++)
				newData[i] = data[i];

			// Finalmente, newData passa a ser o array em uso
			data = newData; // A = B
		}
	}

	@Override
	public void add(int index, E element) {
		if (element == null)
			throw new IllegalArgumentException(
					"A lista não permite armazenar null.");

		if (index < 0 || index > count)
			throw new IllegalArgumentException("Indice invalido: " + index);

		grow();

		count++;
		for (int i = count; i > index; i--) {
			data[i] = data[i - 1];
		}

		data[index] = element;

	}

	private void grow() {
		if (count == data.length)
			setCapacity(data.length * 2);
	}

	@Override
	public E get(int index) {
		return (E) data[index];
	}

	@Override
	public int indexOf(E e) {
		// Procura elemento no array, se achar retorna
		for (int p = 0; p < count; p++) {
			if (data[p].equals(e)) {
				return p;
			}
		}
		// Neste ponto, não achou: retorna -1
		return -1;
	}

	@Override
	public void set(int index, E element) {
		if (element == null)
			throw new IllegalArgumentException(
					"A lista não permite armazenar null.");

		if (index < 0 || index >= count)
			throw new IllegalArgumentException("Indice invalido: " + index);

		data[index] = element;
	}

	@Override
	public boolean removeObject(E e) {
		return removeAt(indexOf(e)) != null;
	}

	@Override
	public E removeAt(int index) {
		if (index < 0 || index >= count)
			throw new IllegalArgumentException("Indice invalido: " + index);

		if (count < data.length / 2)
			setCapacity(data.length / 2);

		Object elem = data[index];

		count--;
		for (int i = index; i < count; i++) {
			data[i] = data[i + 1];
		}
		data[count]= null;
		return (E) elem;
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
		count = 0;
	}

	@Override
	public String toString() {
		return "count: " + count + " " + Arrays.toString(data);
	}
}
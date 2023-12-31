package com.coderscampus.arraylist;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	private Object[] items = new Object[10];
	private int size = 0;

	@Override
	public boolean add(T item) {

		increaseArraySizeIfNeeded();
		items[size] = item;
		size++;
		return true;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");

		}
		@SuppressWarnings("unchecked")
		T element = (T) items[index];
		return element;
	}

	private void increaseArraySizeIfNeeded() {
		if (size == items.length) {
			Object[] newItems = Arrays.copyOf(items, items.length * 2);
			items = newItems;
		}
	}

}

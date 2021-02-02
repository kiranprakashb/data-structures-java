package com.kiran.ds.ds;

public interface Queue<T> {
    public void enQueue(T item);
    public T deQueue();
    public boolean contains(T item);
    public T access(int position);
    public int size();
}

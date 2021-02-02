package com.kiran.ds.ds;

import java.util.ArrayList;
import java.util.List;

public class ListStack<T> implements Stack<T> {

    private List<T> data;

    public ListStack() {
        data = new ArrayList<T>();
    }

    @Override
    public void push(T newItem) {
        data.add(newItem);
    }

    @Override
    public T pop() {
        if(data.size() == 0) {
            throw new IllegalStateException("No more items on the stack");
        }
        return data.remove(data.size() - 1);
    }

    @Override
    public boolean contains(T item) {
        return data.contains(item);
    }

    @Override
    public T access(T item) {
        while(data.size() > 0) {
            T stackItem = pop();
            if (item.equals(stackItem)) {
                return stackItem;
            }
        }
        throw new IllegalArgumentException("Could not find item on the stack: " + item);
    }

    @Override
    public int size() {
        return data.size();
    }
}

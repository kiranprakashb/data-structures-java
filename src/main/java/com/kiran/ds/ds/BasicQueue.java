package com.kiran.ds.ds;

public class BasicQueue<T> implements Queue<T> {

    private T[] data;
    private int front;
    private int end;

    public BasicQueue() {
        this(1000);
    }

    public BasicQueue(int size) {
        front = -1;
        end = -1;
        data = (T[]) new Object[size];
    }

    public int size() {
        int size;
        if(front == -1 || end == -1) {
            size = 0;
        } else {
            size = end - front + 1;
        }
        return size;
    }

    public void enQueue(T item) {
        // first see if the queue is full
        if((end+1) % data.length == front) {
            throw new IllegalStateException("The Queue is full");
        }
        // otherwise check to see if any items have been added to the queue yet
        else if(size() == 0) {
            front++;
            end++;
            data[end] = item;
        }
        // otherwise add the item to the end of the queue
        else {
            end++;
            data[end] = item;
        }
    }

    public T deQueue() {
        T item;
        // if the queue is empty we cant dequeue anything
        if(size() == 0) {
            throw new IllegalStateException("The Queue is empty");
        }
        // otherwise if this is the last item on the queue, the queue needs to get reset to empty
        else if(front == end) {
            item = data[front];
            data[front] = null; // free up memory
            front = -1;
            end = -1;
        }
        // otherwise grab the front of the queue, return it and adjust the front pointer
        else {
            item = data[front];
            data[front] = null; // free up memory
            front++;
        }
        return item;
    }
    
    public boolean contains(T item) {
        boolean found = false;
        if(size() == 0) {
            return found;
        }
        for(int i = front; i < end; i++) {
            if(data[i].equals(item)) {
                found = true;
                break;
            }
        }
        return found;
    }
    
    public T access(int position) {
        if(size() == 0 || position > size()) {
            throw new IllegalArgumentException("No items in the queue of the position is greater than the queue size");
        }
        int trueIndex = 0;
        for(int i = front; i < end; i++) {
            if(trueIndex == position) {
                return data[i];
            }
            trueIndex++;
        }
        throw new IllegalArgumentException("Could not get queue item at position: " + position);
    }
}

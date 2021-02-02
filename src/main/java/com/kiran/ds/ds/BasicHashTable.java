package com.kiran.ds.ds;

public class BasicHashTable<X,Y> {

    private HashEntry[] data;
    private int capacity;
    private int size;

    public BasicHashTable(int tableSize) {
        this.capacity = tableSize;
        this.data = new HashEntry[tableSize];
        this.size = 0;
    }

    public Y get(X key) {
        int hash = calculateHash(key);
        // if we don't have anything for the given key, just return null
        if(data[hash] == null) {
            return null;
        }// otherwise get the hashentry for the key and return it's value
        else {
            return (Y)data[hash].getValue();
        }
    }

    public void put(X key, Y value) {
        int hash = calculateHash(key);
        data[hash] = new HashEntry<X,Y>(key, value);
        size++;
    }

    public Y delete(X key) {
        // first get the value for this key so it can be returned
        Y value = get(key);
        // clear out the hashtable slot for the key and return the removed value
        if(value != null) {
            int hash = calculateHash(key);
            data[hash] = null;
            size--;
            hash = (hash + 1) % capacity;
            // if the next slot isn't empty we should re add it so we keep the hash algorithms clean
            while(data[hash] != null) {
                HashEntry entry = data[hash];
                data[hash] = null;
                size--;
                put((X)entry.getKey(), (Y)entry.getValue());
                hash = (hash + 1) % capacity;
            }
        }
        return value;
    }

    public boolean hasKey(X key) {
        int hash = calculateHash(key);
        // if we don't find anything for the given key, we can return false
        if(data[hash] == null) {
            return false;
        } // otherwise get the hashentry for the key and see if it matches the given key
        else {
            return data[hash].getKey().equals(key);
        }
    }

    public boolean hasValue(Y value) {
        for(int i = 0; i < capacity; i++) {
            if(data[i] != null && data[i].getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    private int calculateHash(X key) {
        int hash = key.hashCode() % capacity;
        while(data[hash] != null && !data[hash].getKey().equals(key)) {
            hash = (hash + 1) % capacity;
        }
        return hash;
    }

    public int size() {
        return size;
    }

    private class HashEntry<X,Y> {
        private X key;
        private Y value;

        public HashEntry(X key, Y value) {
            this.key = key;
            this.value = value;
        }

        public X getKey() {
            return key;
        }

        public void setKey(X key) {
            this.key = key;
        }

        public Y getValue() {
            return value;
        }

        public void setValue(Y value) {
            this.value = value;
        }
    }
}

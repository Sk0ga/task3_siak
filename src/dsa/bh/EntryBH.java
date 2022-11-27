package dsa.bh;

public class EntryBH<T> {

    private int key;
    private T value;

    public EntryBH(int key, T value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    public void setKey(int key) {
        this.key = key;
    }
}

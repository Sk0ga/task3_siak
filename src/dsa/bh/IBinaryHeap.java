package dsa.bh;

public interface IBinaryHeap<T> {

    void insert(T x, int p);
    T returnMax();
    T extractMax();
    void increase(EntryBH<T> entry, int p);
    void printHB();
    int size();
    EntryBH<T> getEntry(int key);
}

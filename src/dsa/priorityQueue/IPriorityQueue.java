package dsa.priorityQueue;

import dsa.bh.EntryBH;

public interface IPriorityQueue<T> {

    void insert(T x, int p);

    T extractMax();

    void increase(EntryBH<T> entry, int p);

    EntryBH<T> getEntry(int key);

}

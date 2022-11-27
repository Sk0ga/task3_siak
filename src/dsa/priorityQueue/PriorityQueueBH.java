package dsa.priorityQueue;

import dsa.bh.BinaryHeap;
import dsa.bh.EntryBH;

public class PriorityQueueBH<T> implements IPriorityQueue<T> {
    private BinaryHeap<T> binaryHeap;

    public PriorityQueueBH(int size) {
        this.binaryHeap = new BinaryHeap<>(size);
    }

    // insert - O(log2N) ; худщий случай - O(logN)
    @Override
    public void insert(T x, int p) {
        binaryHeap.insert(x, p);
    }

    // extractMax - O(logN)
    @Override
    public T extractMax() {
        return binaryHeap.extractMax();
    }

    // increase - O(logN)
    @Override
    public void increase(EntryBH<T> entry, int p) {
        binaryHeap.increase(entry, p);
    }

    @Override
    public EntryBH<T> getEntry(int key) {
        return binaryHeap.getEntry(key);
    }

    public void printPriorityQueue() {
        binaryHeap.printHB();
    }

    public int size() {
        return binaryHeap.size();
    }

    public int capacity() {
        return binaryHeap.capacity();
    }
}

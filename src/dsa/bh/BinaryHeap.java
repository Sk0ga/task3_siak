package dsa.bh;

// Comparable isn't used, so better gat rid of it
public class BinaryHeap<T> implements IBinaryHeap<T> {

    private EntryBH<T>[] items;
    private int capacity;
    private int currSize;

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        this.items = new EntryBH[capacity];
        this.currSize = 0;
    }

    @Override
    public void insert(T x, int p) {
        if (currSize == capacity) {
            EntryBH<T>[] newItems = new EntryBH[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                newItems[i] = items[i];
            }
            capacity *= 2;
            items = newItems;
        }
        EntryBH<T> entry = new EntryBH<>(p, x);
        items[currSize] = entry;
        heapifyUp(currSize);
        currSize += 1;

    }

    @Override
    public T returnMax() {
        if (currSize == 0) {
            System.out.println("Empty");
            return null;
        }
        return items[0].getValue();
    }

    @Override
    public T extractMax() {
        if (currSize == 0) {
            System.out.println("Empty");
            return null;
        }
        T maxItem = items[0].getValue();
        items[0] = items[currSize - 1];
        currSize -= 1;
        heapifyDown(0);

        // halve size of array when it is one-quarter full
        if (currSize > 0 && currSize == capacity / 4) {
            EntryBH<T>[] newItems = new EntryBH[capacity / 2];
            for (int i = 0; i < currSize; i++) {
                newItems[i] = items[i];
            }
            capacity /= 2;
            items = newItems;
        }
        return maxItem;
    }

    @Override
    public void increase(EntryBH<T> entry, int p) {
        if (currSize < 1) {
            System.out.println("Empty");
        } else {
            int indOfItem = 0;
            if (currSize == 1) {
                items[0].setKey(p);
                heapifyUp(indOfItem);
            } else {
                for (int i = 0; i < currSize; i++) {
                    if (items[i].getKey() == entry.getKey()) {
                        indOfItem = i;
                    }
                }
                if (entry.getKey() >= p) {
                    System.out.println(entry.getKey() + " " + p);
                    System.out.println("New key is less or equal then current key");
                } else {
                    items[indOfItem].setKey(p);
                    heapifyUp(indOfItem);
                }
            }
        }
    }

    private void heapifyUp(int ind) {
        while (ind > 0 && items[findParent(ind)].getKey() < items[ind].getKey()) {
            swap(ind, findParent(ind));
            ind = findParent(ind);
        }
    }

    private void heapifyDown(int ind) {
        while (ind < currSize) {
            int left = findLeft(ind);
            int right = findRight(ind);
            int largest = ind;
            if (left < currSize && items[left].getKey() > items[ind].getKey()) {
                largest = left;
            } else if (right < currSize && items[right].getKey() > items[ind].getKey()) {
                largest = right;
            }
            if (largest != ind) {
                swap(ind, largest);
                ind = largest;
            } else {
                break;
            }
        }
    }

    private void swap(int indX1, int indX2) {
        EntryBH<T> temp = items[indX1];
        items[indX1] = items[indX2];
        items[indX2] = temp;
    }

    private int findParent(int ind) {
        if (ind % 2 != 0) {
            return ((ind + 1) / 2) - 1;
        } else {
            return ind / 2 - 1;
        }
    }

    private int findLeft(int ind) {
        return (ind + 1) * 2 - 1;
    }

    private int findRight(int ind) {
        return (ind + 1) * 2;
    }

    // index of first element that equals T x
    // x.compare -
    // private int findIndex(T x, int p) {
    // return 0;
    // }

    // private void increaseSize() {

    // }

    // private void decreaseSize() {

    // }

    @Override
    public void printHB() {
        for (int i = 0; i < currSize; i++) {
            System.out.println("Key: " + items[i].getKey() + " " + "Value: " + items[i].getValue());
        }
    }

    @Override
    public int size() {
        return currSize;
    }

    public int capacity() {
        return capacity;
    }

    @Override
    public EntryBH<T> getEntry(int key) {
        if (currSize < 1) {
            System.out.println("Empty");
        } else {
            for (int i = 0; i < currSize; i++) {
                if (items[i].getKey() == key) {
                    int k = items[i].getKey();
                    T val = items[i].getValue();
                    return new EntryBH<T>(k, val);
                }
            }
        }
        return null;

    }

}

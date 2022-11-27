package dsa;

import dsa.priorityQueue.PriorityQueueArr;
import dsa.priorityQueue.PriorityQueueBH;

public class Main {

    public static void main(String[] args) {
        PriorityQueueBH<Integer> queueBH = new PriorityQueueBH<Integer>(10);
        PriorityQueueArr<String> queueArr = new PriorityQueueArr<String>(10);

        for (int i = 0; i < 10; i++) {
            queueArr.insert("333", i);
            queueBH.insert(10, i);
        }

        queueArr.printPQArr();
        System.out.println();
        queueBH.printPriorityQueue();
        System.out.println();

        queueArr.increase(queueArr.getEntry(4), 25);
        queueBH.increase(queueBH.getEntry(2), 14);

        queueArr.extractMax();
        queueBH.extractMax();

        queueArr.printPQArr();
        System.out.println();
        queueBH.printPriorityQueue();

    }
}

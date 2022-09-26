package fb_high_frequency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BoundedBlockingQueue {
    private Queue<Integer> queue;
    private int capacity;

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() >= capacity) {
                queue.wait();
            }
            queue.offer(element);
            queue.notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait();
            }
            int element = queue.poll();
            queue.notifyAll();

            return element;
        }
    }

    public int size() {
        return queue.size();
    }
}

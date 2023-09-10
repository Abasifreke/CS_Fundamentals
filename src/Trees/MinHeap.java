package Trees;

import java.util.Arrays;

public class MinHeap {

    private int[] heap;
    private int capacity;
    private int size;

    public MinHeap(int capacity) {
        this.heap = new int[capacity];
        this.capacity = capacity;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return (i * 2) + 1;
    }

    public int right(int i) {
        return (i * 2) + 2;
    }

    public void insert(int t) {
        if (size == capacity) {
            throw new IllegalStateException("Maximum capcity of heap reached");
        }

        int i = size;
        heap[i] = t;
        size++;

        // minify
        while (heap[i] < heap[parent(i)]) {
            // swap
            int temp = heap[parent(i)];
            heap[parent(i)] = heap[i];
            heap[i] = temp;
            i = parent(i);
        }
    }

    public int extractMin() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }

        int min = this.heap[0];
        this.heap[0] = this.heap[size - 1];
        this.heap[size - 1] = 0;
        this.size--;

        int i = 0;
        while (i < size) {
            if (heap[i] > heap[left(i)] && left(i) < size) {
                int temp = heap[left(i)];
                heap[left(i)] = heap[i];
                heap[i] = temp;
                i = left(i);
            } else if (heap[i] > heap[right(i)] && right(i) < size) {
                int temp = heap[right(i)];
                heap[right(i)] = heap[i];
                heap[i] = temp;
                i = right(i);
            } else {
                break;
            }

        }
        return min;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.heap);
    }

    public static void main(String args[]) {
        MinHeap heap = new MinHeap(5);
        heap.insert(4);
        System.out.println(heap);
        heap.insert(1);
        System.out.println(heap);
        heap.insert(7);
        System.out.println(heap);
        heap.insert(5);
        System.out.println(heap);
        heap.insert(2);
        System.out.println(heap);
        heap.extractMin();
        System.out.println(heap);

    }

}

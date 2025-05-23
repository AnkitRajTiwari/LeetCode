class MyCircularQueue {
    int[] data;
    int front = 0;  // Points to the first element
    int rear = -1;  // Points to the last element
    int size = 0;   // Tracks the number of elements

    public MyCircularQueue(int k) {
        data = new int[k];
    }

    public boolean enQueue(int value) {
        if (size == data.length) return false; // Queue is full
        rear = (rear + 1) % data.length;  // Move rear circularly
        data[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) return false; // Queue is empty
        front = (front + 1) % data.length; // Move front circularly
        size--;
        return true;
    }

    public int Front() {
        return size == 0 ? -1 : data[front]; // Return front element
    }

    public int Rear() {
        return size == 0 ? -1 : data[rear]; // Return rear element
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
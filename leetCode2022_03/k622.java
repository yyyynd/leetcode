package leetcode.leetCode2022_03;

public class k622 {
    int[] queue;
    int cap;
    int len;
    int head;
    int tail;

    public k622(int k) {
        this.queue = new int[k];
        this.cap = k;
        this.len = 0;
        this.head = 0;
        this.tail = 0;
    }

    public boolean enQueue(int value) {
        if (len == cap)
            return false;
        queue[tail] = value;
        len++;
        tail = (tail + 1) % cap;
        return true;
    }

    public boolean deQueue() {
        if (len == 0)
            return false;
        len--;
        head = (head + 1) % cap;
        return true;
    }

    public int Front() {
        if(len == 0)
            return -1;
        return queue[head];
    }

    public int Rear() {
        if (len == 0)
            return -1;
        return queue[tail == 0 ? cap - 1 : tail - 1];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == cap;
    }
}

package com.zcq.cn.queue;

/**
 * 环形队列通过取模来实现,可以循环利用元素空间
 */
public class AnnularQueueDemo {
    private int maxSize;    // 队列最大长度
    private int front;  // 队列头
    private int rear;   // 队列尾
    private int arrQueue[]; // 数组模拟队列

    // 创建环形队列构造器
    public AnnularQueueDemo(int arrMaxSize) {
        maxSize = arrMaxSize;
        arrQueue = new int[maxSize];  // 这里是否要加一？
        front = 0; // 指向环形队列头部，指向队列头
        rear = 0;  // 指向环形队列尾部，指向队列尾后一个位置，这个位置是一个预留空间，不能存储数据
    }

    // 判断队列是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 进入队列
    public void addQueue(int value) {
        if (isFull()) {
            throw new RuntimeException("队列已满! ");
        }
        arrQueue[rear] = value;
        rear = (rear + 1) % maxSize; // 队列尾后移

    }

    // 出队列
    public int popQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        int value = arrQueue[front];
        front = (front + 1) % maxSize;   // 队列头后移
        return value;
    }

    // 当前队列有效元素个数
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    // 打印队列
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arrQueue[%d]=%d\n", i % maxSize, arrQueue[i % maxSize]);
        }
    }

    // 查看队列头
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        return arrQueue[front];
    }
}

package com.zcq.cn.queue;

public class ArrayQueueDemo {

    private int maxSize;    // 队列最大长度
    private int front;  // 队列头
    private int rear;   // 队列尾
    private int arrQueue[]; // 数组模拟队列

    // 创建队列构造器
    public ArrayQueueDemo(int arrMaxSize) {
        maxSize = arrMaxSize;
        arrQueue = new int[maxSize];
        front = -1; // 指向队列头部，指向队列头前一个位置
        rear = -1;  // 指向队列尾部，指向队列尾
    }

    // 判断队列是否已满
    public boolean isFull() {
        return rear == maxSize - 1;
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
        rear++; // 队列尾后移
        arrQueue[rear] = value;
    }

    // 出队列
    public int popQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        front++;    // 队列头后移
        return arrQueue[front];
    }

    // 打印队列
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        for (int i = front; i < rear; i++) {
            System.out.printf("arrQueue[%d]: %d", i, arrQueue[i]);
        }
    }

    // 查看队列头
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        return arrQueue[front + 1];
    }
}

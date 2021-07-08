package com.zcq.cn.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleHeroNode h1 = new DoubleHeroNode(1, "蔡文姬", "奶妈");
        DoubleHeroNode h2 = new DoubleHeroNode(2, "孙悟空", "猴子");
        DoubleHeroNode h3 = new DoubleHeroNode(3, "韩信", "韩跳跳");
        DoubleHeroNode h4 = new DoubleHeroNode(4, "关羽", "绿帽子");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.show();
        doubleLinkedList.addNode(h4);
        doubleLinkedList.addNode(h2);
        doubleLinkedList.addNode(h3);
        doubleLinkedList.addNode(h1);
        doubleLinkedList.show();
        doubleLinkedList.update(new DoubleHeroNode(3, "小明", "赔钱虎"));
        doubleLinkedList.delte(2);
        doubleLinkedList.show();
    }
}

class DoubleLinkedList {
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

    public DoubleHeroNode getHead() {
        return head;
    }

    // 打印双向链表
    public void show() {
        if (head.next == null) {
            System.out.println("空链表");
        }
        DoubleHeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 添加节点
    public void addNode(DoubleHeroNode hNode) {
        DoubleHeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = hNode;
                hNode.pre = temp;
                break;
            }
            temp = temp.next;
        }
    }

    // 根据编号更新节点
    public void update(DoubleHeroNode hNode) {
        DoubleHeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("没有该节点！");
                break;
            }
            temp = temp.next;
            if (temp.no == hNode.no) {
                temp.name = hNode.name;
                temp.nickName = hNode.nickName;
                break;
            }
        }
    }

    // 根据编号删除节点
    public void delte(int hNo) {

        if (head.next == null) {
            System.out.println("空链表");
            return;
        }

        DoubleHeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("无耻节点！");
                break;
            }
            if (temp.no == hNo) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
                System.out.println("删除成功！");
                break;
            }
            temp = temp.next;
        }
    }

    // 按照顺序添加节点
    public void addNodeByOrder(DoubleHeroNode hNode) {
        DoubleHeroNode temp = head;
        while (true) {
            if (temp == null || temp.next == null) {
                break;
            }
            // if ()
        }
    }
}

/**
 * DoubleHeroNode,每个DoubleHeroNode有一个pre和一个next
 */
class DoubleHeroNode {
    public int no; // 节点编号
    public String name;    // 节点名字
    public String nickName;    // 节点昵称
    public DoubleHeroNode pre;
    public DoubleHeroNode next;   // 下一个节点

    public DoubleHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DoubleHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
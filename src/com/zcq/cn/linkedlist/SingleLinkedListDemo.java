package com.zcq.cn.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(1, "蔡文姬", "奶妈");
        HeroNode h2 = new HeroNode(2, "孙悟空", "猴子");
        HeroNode h3 = new HeroNode(3, "韩信", "韩跳跳");
        HeroNode h4 = new HeroNode(4, "关羽", "绿帽子");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.addNode(h1);
        singleLinkedList.addNode(h2);
        singleLinkedList.addNode(h3);
        singleLinkedList.addNode(h4);

//        singleLinkedList.show();
//        System.out.println("______________________");
//
//        singleLinkedList.reverseLinkedList();
//        singleLinkedList.show();

        System.out.println("______________________");
        //singleLinkedList.reversePrint();
//        HeroNode heroNode = singleLinkedList.DGReverseLinkedList(singleLinkedList.getHead());
//        System.out.println(heroNode);
    }
}

/**
 * 定义单链表来管理hero
 * 在链表里面容易犯的错，头节点和链表节点概念是不相同的，在操作时，应该先判断链表是否为空（即 head.next == null ?）,然后把头结点的next赋值给temp(即 temp = head.next)
 */
class SingleLinkedList {
    // 初始化头节点
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    // 添加节点
    public void addNode(HeroNode hNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = hNode;
                break;
            }
            temp = temp.next;
        }
    }

    // 获取倒数的第几个节点
    public HeroNode getNode(int index) {
        // 等于第length-index个节点
        HeroNode temp = head;
        int size = getLength();
        if (temp.next == null || size < index) {
            return null;
        }
        temp = head.next;

        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 链表反转
     */
    public void reverseLinkedList() {
        // 方法一：利用得到的倒数第index节点，来往新链表里添加
        // 方法二：直接反转
//        HeroNode temp = head;
//        if (temp.next == null || temp.next.next == null) {
//            return;
//        }
//        HeroNode pre = temp.next;
//        HeroNode cur = pre.next;
//        while (cur != null) {
//            pre.next = cur.next;
//            cur.next = temp.next;
//            temp.next = cur;
//            cur = pre.next;
//        }
        // 方法三：新建一个链表，顺序循环取出旧链表节点放到新链表前面
//        if (head.next == null || head.next.next == null) {
//            return;
//        }
//        // 定义一个辅助的指针（变量），帮助我们遍历原来的链表
//        HeroNode cur = head.next;
//        HeroNode next = null;   // 指向当前节点[cur]的下一个节点
//        HeroNode reverseHead = new HeroNode(0, "", "");
//        while (cur != null) {
//            next = cur.next;    // 暂时保存当前节点的下一个节点
//            cur.next = reverseHead.next;    // 将cur的下一个节点指向了新链表的最前端
//            reverseHead.next = cur; //
//            cur = next;
//        }
//        head.next = reverseHead.next;

        // 递归法
    }

    // 递归反转链表
//    public HeroNode DGReverseLinkedList(HeroNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        HeroNode newNode = DGReverseLinkedList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newNode;
//    }

    // 按照顺序添加节点
    public void addNodeByOder(HeroNode hNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > hNode.no) {
                break;
            } else if (temp.next.no == hNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("节点的编号已存在！");
        } else {
            hNode.next = temp.next;
            temp.next = hNode;
        }
    }

    // 根据编号更新节点
    public void update(HeroNode hNode) {
        HeroNode temp = head;
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
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                System.out.println("无耻节点！");
                break;
            }
            if (temp.next.no == hNo) {
                temp.next = temp.next.next;
                System.out.println("删除成功！");
                break;
            }
            temp = temp.next;
        }
    }

    // 获取链表的有效节点个数
    public int getLength() {
        int length = 0;
        HeroNode temp = head;

        if (temp.next == null) {
            return 0;
        }

        temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }


    // 打印链表
    public void show() {
        HeroNode temp = head;
        if (temp.next == null) {
            System.out.println("空链表");
        }

        temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 从尾到头打印
    public void reversePrint() {
        if (head.next == null) {
            return;
        }
        HeroNode cur = head.next;
        Stack<HeroNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}

/**
 * 定义HeroNode,每个HerNode对象就是一个节点
 */
class HeroNode {
    public int no; // 节点编号
    public String name;    // 节点名字
    public String nickName;    // 节点昵称
    public HeroNode next;   // 下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
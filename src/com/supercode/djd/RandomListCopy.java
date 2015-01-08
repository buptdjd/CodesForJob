package com.supercode.djd;

import javax.print.attribute.standard.RequestingUserName;

/**
 * Created by Lenovo on 2015/1/8.
 */

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

public class RandomListCopy {

    public RandomListNode copyNode(RandomListNode head){
        RandomListNode node = head;
        while(node!=null){
            RandomListNode cur = new RandomListNode(node.label);
            cur.next = node.next;
            node.next = cur;
            node = cur.next;
        }
        return head;
    }

    public RandomListNode copyRandom(RandomListNode head){
        RandomListNode node = head;
        while(node!=null){
            RandomListNode cur = node.next;
            if(node.random!=null){
                cur.random = node.random.next;
            }else{
                cur.random = null;
            }
            node = cur.next;
        }
        return head;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return head;
        }
        head = copyNode(head);
        head = copyRandom(head);
        RandomListNode head1 = head.next;
        RandomListNode node1 = head1;
        RandomListNode node = head;
        while(node!=null && node1!=null){
            node.next = node1.next;
            node = node1.next;
            if(node!=null){
                node1.next = node.next;
                node1 = node.next;
            }
        }
        return head1;
    }

    void print(RandomListNode head){
        RandomListNode node = head;
        while(node!=null){
            System.out.print(node.label + " ");
            node = node.next;
        }
        System.out.println();
    }

    void print1(RandomListNode head){
        RandomListNode node = head;
        while(node!=null){
            System.out.print(node.label + " ");
            if(node.random!=null){
                System.out.print(node.random.label + " ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]){
        RandomListCopy randomListCopy = new RandomListCopy();
        RandomListNode p1 = new RandomListNode(1);
        RandomListNode p2 = new RandomListNode(2);
        RandomListNode p3 = new RandomListNode(3);
        RandomListNode p4 = new RandomListNode(4);
        RandomListNode p5 = new RandomListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p1.random = p3;
        p2.random = p4;
        p3.random = p5;
        p5.random = p1;
        RandomListNode head = randomListCopy.copyRandomList(p1);
        randomListCopy.print(head);
        randomListCopy.print1(head);
    }
}

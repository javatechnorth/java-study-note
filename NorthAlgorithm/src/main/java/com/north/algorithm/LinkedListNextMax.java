package com.north.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
给定一个长度为n的链表head

 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。

 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。


输入：head = [2,1,5]
输出：[5,5,0]

输入：head = [2,7,4,3,5]
输出：[7,0,5,5,0]

 */
public class LinkedListNextMax {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(8,listNode5);
        ListNode listNode3 = new ListNode(4,listNode4);
        ListNode listNode2 = new ListNode(7,listNode3);
        ListNode listNode1 = new ListNode(2,listNode2);
        int[] ints = nextLargerNodes(listNode1);
        for (int i :ints){
            System.out.print(i);
        }
    }

    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        //链表元素存储到集合中
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        //栈中存储的是元素的下标，并且从栈底到栈顶元素在集合中对应的
        //值是从大到小的
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            while (!stack.empty() && list.get(stack.peek()) < list.get(i)) {
                //如果栈顶元素对应的值小于当前值，说明栈顶元素遇到了比他小的
                int index = stack.pop();
                res[index] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

package com.chad.leetcode.medium;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 */
class SwapNodesInPairs {

//    public ListNode swapPairs(ListNode head) {
//        if(head==null||head.next==null) return head;
//        ListNode nextNode = head.next;
//        head.next = swapPairs(nextNode.next);
//        nextNode.next = head;
//        return nextNode;
//    }

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        //还有两个元素的时候才继续交换
        while(cur.next!=null&&cur.next.next!=null){
            ListNode l1 = cur.next;
            ListNode l2 = cur.next.next;
            ListNode l3 = l2.next;
            l2.next = l1;
            l1.next = l3;
            cur.next = l2;
            cur = l1;//前进一位继续遍历
        }
        return dummy.next;
    }


        public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

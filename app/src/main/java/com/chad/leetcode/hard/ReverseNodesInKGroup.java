package com.chad.leetcode.hard;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode end=dummy;
        while(end.next!=null){
            //循环k次，找到需要翻转的链表的结尾,这里每次循环要判断end是否等于空,因为如果为空，end.next会报空指针异常。
            //dummy->1->2->3->4->5 若k为2，循环2次，end指向2
            for(int i = 0;i < k && end != null;i++){
                end=end.next;
            }
            //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
            if(end==null){
                break;
            }
            //先记录下end.next,方便后面链接链表
            ListNode next = end.next;
            //然后断开链表
            end.next = null;
            //记录下要翻转链表的头节点
            ListNode start = pre.next;
            //翻转链表,pre.next指向翻转后的链表。1->2 变成2->1。 dummy->2->1
            pre.next = reverse(start);
            //翻转后头节点变到最后。通过.next把断开的链表重新链接。
            start.next = next;
            //将pre换成下次要翻转的链表的头结点的上一个节点。即start
            pre = start;
            //翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。即start
            end = start;
        }
        return dummy.next;
    }

    //链表翻转
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null){
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

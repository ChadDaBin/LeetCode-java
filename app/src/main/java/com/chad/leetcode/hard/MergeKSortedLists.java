package com.chad.leetcode.hard;


/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        return helper(lists,0,lists.length-1);
    }

    private ListNode helper(ListNode[] lists,int l,int r){
        if(l>=r){
            return lists[l];
        }
        int mid = l + (r-l)/2;
        ListNode leftRoot = helper(lists,l,mid);
        ListNode rightRoot = helper(lists,mid+1,r);
        return mergeTwoLists(leftRoot,rightRoot);
    }

    private ListNode mergeTwoLists(ListNode l1,ListNode l2){
//        ListNode dummy = new ListNode(0);
//        ListNode cur = dummy;
//        while(l1!=null&&l2!=null){
//            if(l1.val<=l2.val){
//                cur.next = l1;
//                l1=l1.next;
//            }else{
//                cur.next = l2;
//                l2 = l2.next;
//            }
//            cur = cur.next;
//        }
//        cur.next = l1 != null ? l1:l2;
//        return dummy.next;
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

package com.lk.极客时间.算法.数组链表;

/**
 * Description: https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author likai
 * @date 2019-11-10 15:04
 */
public class 两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

    public ListNode swapPairsWithR(ListNode head) {
        // 基线条件
        if (head == null || head.next == null) {
            return head;
        }
        // 递归条件
        ListNode res = head.next;
        head.next = swapPairs(res.next);
        res.next = head;
        return res;
    }

}

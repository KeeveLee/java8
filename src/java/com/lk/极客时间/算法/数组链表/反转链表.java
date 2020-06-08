package com.lk.极客时间.算法.数组链表;



/**
 * Description: https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author likai
 * @date 2019-11-09 17:17
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head){

        ListNode pre = null;
        ListNode cur = head;
        while (null != cur){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }


        return pre;
    }
}

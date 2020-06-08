package com.lk.极客时间.算法.数组链表;

/**
 * Description:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likai
 * @date 2020-04-16 13:00
 */
public class 两数相加 {

    public static void main(String[] args){

        System.out.println(807%10);
        System.out.println(807/10);
        System.out.println(8&10);
        System.out.println(8/10);
        int a = -1;
        System.out.println("a"+ a);
    }

    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0;
        int resInt = 0;
        while (l1.next!=null || l2.next!=null){
            int pow = (int) Math.pow(10, a);
            if (l1.next == null){
                resInt += l2.val * pow;
            }else if (l2.next == null){
                resInt += l1.val * pow;
            }else {
                resInt += (l1.val + l2.val) * pow;
            }
            a++;
        }

        int b = resInt;
        while (b>0){
            b = resInt/10;
            int val = resInt%10;
            ListNode listNode = new ListNode(val);



        }


        return null;
    }
}

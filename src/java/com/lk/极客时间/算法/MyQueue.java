package com.lk.极客时间.算法;

import java.util.Stack;

/**
 * Description:
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 * @author likai
 * @date 2019-01-09 23:50
 */
public class MyQueue {

    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    /** Initialize your data structure here.*/
    public MyQueue() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!outStack.isEmpty()){
            inStack.push(outStack.pop());
        }
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (inStack.isEmpty() && outStack.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}

package com.supercode.djd;

import java.util.Stack;

/**
 * Created by Lenovo on 2015/1/7.
 */
public class MinStack {

    Stack<Integer> num = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int x) {
        num.push(x);
        if(min.size()==0){
            min.push(x);
        }else{
            int t = min.peek();
            min.push(t>x?x:t);
        }
    }

    public void pop() {
        num.pop();
        min.pop();
    }

    public int top() {
        return num.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String args[]){
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(2);
        stack.push(8);
        System.out.println(stack.getMin());

    }

}

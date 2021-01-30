package number202101.numberDay20210130;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> min = new Stack<>();

    public MinStack() {
        min.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        min.push(Math.min(min.peek(), x));
        stack.push(x);
    }

    public void pop(){
        stack.pop();
        min.pop();
    }


    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack =new MinStack();


    }



}

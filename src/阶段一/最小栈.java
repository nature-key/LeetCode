package 阶段一;

import java.util.Stack;

public class 最小栈 {

   private  Stack<Integer>  stack;

   private Stack<Integer> minStack;

    public 最小栈() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }

    public  void  push(Integer x){
        stack.push(x);
        if(minStack.isEmpty()||x<minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop(){
        if(stack.pop().equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int getMin(){
        minStack.peek();
    }

    public int top(){
        stack.peek();
    }
}

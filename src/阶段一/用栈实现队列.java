package 阶段一;

import java.util.Stack;

public class 用栈实现队列 {
    private static  final Stack<String> input=new Stack<>();
    private static  final Stack<String> output=new Stack<>();


    public static  void  push(String value){
        input.push(value);
    }


    public static boolean isEmpty(){
        return input.isEmpty()&&output.isEmpty();
    }

    public static String pop(){
        if(output.isEmpty()){
            swap();
        }
        return output.pop();
    }

    public static  String peek(){
        if (output.isEmpty()) {
            swap();
        }
        return output.peek();
    }


    private static void swap(){
        while (!input.isEmpty()){
            output.push(input.pop());
        }

    }

    public static void main(String[] args) {
        push("1");
        push("2");
        push("3");
        push("4");

        System.out.println(peek());
        System.out.println(pop());
        System.out.println(peek());



    }


}

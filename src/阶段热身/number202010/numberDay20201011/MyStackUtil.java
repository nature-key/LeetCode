package 阶段热身.number202010.numberDay20201011;

public class MyStackUtil {

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        for (int i = 0; i < 4; i++) {
            stack.push(String.valueOf(i));
        }

        stack.show();
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.show();




    }
}

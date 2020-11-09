package number202010.numberDay20201008;

public class StackUtil {


    public static void main(String[] args) {
//        ArrayStack stack =new ArrayStack<String>();
        ListStack<String> stack =new ListStack<>();
        for (int i = 0; i <4 ; i++) {
            stack.push(String.valueOf(i));
        }

        stack.show();

        System.out.println(stack.peek());
//
//        stack.show();
        System.out.println(stack.pop());
        stack.show();


    }
}

package number202010.numberDay20201011;

public class MyQueueUtil {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        for (int i = 0; i < 5; i++) {
            queue.push(String.valueOf(i));
        }
        queue.show();

        System.out.println(queue.peek());

        System.out.println(queue.pop());

        queue.show();

        System.out.println(queue.peek());

    }
}

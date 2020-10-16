package numberDay20201016;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaxSlidingWindow {


    public static int[] getMaxSlidingWindow(int[] num, int k) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[num.length - k + 1];

        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[deque.getLast()] < num[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peek() <= i - k) {
                deque.poll();
            }

            if (i + 1 >= k) {
                result[i + 1 - k] = num[deque.peek()];
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};

        int[] maxSlidingWindow = getMaxSlidingWindow1(nums, 3);
        for (int i : maxSlidingWindow) {
            System.out.print(i + " ");

        }

    }

    private static int[] getMaxSlidingWindow1(int[] num, int k) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[num.length - k + 1];

        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peek() <= i - k) {
                deque.poll();
            }
            if (i + 1 >= k) {
                result[i + 1 - k] = num[deque.peek()];
            }
        }
        return result;
    }


}

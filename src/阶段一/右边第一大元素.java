package 阶段一;

import 阶段热身.number202010.numberDay20201017.ValidAnagram;

import java.util.Stack;
import java.util.Vector;

public class 右边第一大元素 {

    /**
     * https://codeleading.com/article/6214732115/
     * @param vector
     * @return
     */
    public static Vector<Integer> findMaxElement(Vector<Integer> vector) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Vector<Integer> result = new Vector<>();

        for (int i = 1; i < vector.size(); i++) {
            while (!stack.isEmpty() && vector.get(i) > vector.get(stack.peek())) {
                result.add(vector.get(i));
                stack.pop();
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add(2);
        vector.add(3);
        vector.add(1);
        vector.add(5);
        vector.add(6);
        vector.add(0);
        vector.add(9);
        findMaxElement(vector).forEach(it->{
            System.out.println(it);
        });
    }

}

package 阶段一;

import java.util.Stack;

public class 柱状图中最大的矩阵 {


    private int maxArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(h * w, maxArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int h = height[stack.peek()];
            stack.pop();
            int w = stack.isEmpty() ? height.length : height.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * w);
        }
        return maxArea;

    }


}

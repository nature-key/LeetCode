package 阶段一;

public class 盛最多水的容器 {


    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; i++) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            maxArea = Math.max((j - i + 1) * minHeight, maxArea);
        }
        return maxArea;
    }


    public int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return maxArea;
    }
}

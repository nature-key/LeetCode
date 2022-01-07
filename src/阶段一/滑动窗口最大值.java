package 阶段一;

import java.util.Arrays;
import java.util.LinkedList;


//这个难
public class 滑动窗口最大值 {

    public static int[] maxSlidingWindow(int[] nums,int k){
        if (nums==null||nums.length<3) {
            return nums;
        }

        LinkedList<Integer> queue = new LinkedList<Integer>();
        int[] result =new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            //1判断队尾的数值是否小于新加入的值，则弹出队尾的值，直到满足为空，
            while (!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            //添加数组下表到队列
            queue.addLast(i);
            //看看是否在窗口范围内，如果不是则弹出对头
            if (queue.peek()<=i-k) {
                queue.poll();
            }
            //如果满足了窗口的大小，则把队头添加到结果中
            if(i+1>=k){
                result[i+1-k]=nums[queue.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums ={1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }

}

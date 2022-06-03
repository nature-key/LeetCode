package 阶段一;

public class 跳跃游戏 {


    public boolean canJump(int[] nums) {
        int enableSkip = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= enableSkip) {
                enableSkip = i;
            }
        }
        return enableSkip == 0;
    }

}

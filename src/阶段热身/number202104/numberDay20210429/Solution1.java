package 阶段热身.number202104.numberDay20210429;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1 {


    private int[][] merge(int[][] intervels) {

        Arrays.sort(intervels, Comparator.comparingInt(it -> it[0]));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervels.length; i++) {
            int[] currIntervel = intervels[i];
            if (list.isEmpty()) {
                list.add(currIntervel);
            } else {
                int[] ints = list.get(list.size() - 1);
                int anInt = ints[1];
                int i1 = currIntervel[0];
                if (anInt < i1) {
                    list.add(currIntervel);
                } else {
                    int max = Math.max(anInt, i1);
                    ints[1] = max;
                }
            }
        }
        return list.toArray(new int[list.size()][]);

    }


    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length + 1);
    }

    private int mergeSort(int[] nums, int l, int r) {

        if (l >= r) {
            return 0;
        }
        int mid = (l + r) >> 1;
        int cnt = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);

        for (int i = l, j = mid + 1; i <= mid; i++) {
            while (j <= r && nums[i] / 2 > nums[j]) j++;
            cnt += j - (mid + 1);
        }
        Arrays.sort(nums, l, r + 1);

        return cnt;
    }

    public int reversePairs1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return mergesort1(nums, 0, nums.length - 1);

    }

    private int mergesort1(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;

        }
        int mid = (l + r) >> 1;

        int count = mergesort1(nums, l, mid) + mergesort1(nums, mid + 1, r);

        int[] cache = new int[r - l + 1];

        int i = l, t = l, c = 0;
        for (int j = mid + 1; j <= r; j++, c++) {

            while (i <= mid && nums[i] / 2 <= nums[j]) i++;
            while (t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
            cache[c] = nums[j];
            count += mid - i + 1;
        }
        while (t <= mid) cache[c++] = nums[t++];

        System.arraycopy(cache, 0, nums, l, r - l + 1);

        return count;


    }


}

package number202101.numberDay20210125;

import java.util.*;

public class Solution {


    private static int[] getSum2(int[] num, int tartget) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], i);
        }

        for (int i = 0; i < num.length; i++) {
            int temp = tartget - num[i];
            if (map.containsKey(temp) && map.get(temp) != i) {
                result[0] = i;
                result[1] = map.get(temp);
                return result;
            }

        }
        return result;
    }

    private static List<List<Integer>> getSum3(int[] num) {
        int[] result = new int[3];
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i - 1] == num[i]) continue;
            for (int j = i + 1; j < num.length - 1; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) continue;
                for (int k = j + 1; k < num.length; k++) {
                    if (k < j + 1 && num[k] == num[k - 1]) continue;
                    if (num[i] + num[j] + num[k] == 0) {
                        res.add(Arrays.asList(num[i], num[j], num[k]));
//                        return result;
                    }
                }
            }
        }
        return res;

    }

    private static List<List<Integer>> getSumT3(int[] nums) {
        if (nums != null || nums.length <= 2) {
            Collections.emptyList();
        }
        Set<List<Integer>> result = new HashSet();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = 0 - nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < nums.length - 1; j++) {
                int v = target - nums[j];
                if (map.containsKey(v)) {
                    result.add(Arrays.asList(nums[i], nums[j], target));
                } else {
                    map.put(nums[j], nums[j]);
                }
            }

        }

        return new ArrayList<>(result);
    }


    private static List<List<Integer>> getSumThree(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int l = i + 1;
                int r = num.length - 1;
                int sum = 0 - num[i];
                while (l < r) {
                    if (num[l] + num[r] == sum) {
                        res.add(Arrays.asList(num[i], num[l], num[r]));
                        while (l < r && num[l] == num[l + 1]) {
                            l++;
                        }
                        while (l < r && num[r] == num[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (num[l] + num[r] > sum) {
                        r--;
                    } else {
                        l++;
                    }

                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
//        int[] a = {2, 7, 11, 15};
//        for (int i : getSum2(a, 9)) {
//
//            System.out.println(i);
//
//        }
//
//
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> sum3 = getSum3(nums);
        sum3.forEach(it -> {
            System.out.println(it);
        });

        System.out.println("=========");
        List<List<Integer>> sumThree = getSumThree(nums);
        sumThree.forEach(it -> {
            System.out.println(it);
        });
        System.out.println("--------");
        List<List<Integer>> sumT3 = getSumT3(nums);
        sumT3.forEach(it->{
            System.out.println(it);
        });



    }
}

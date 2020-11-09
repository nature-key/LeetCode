package number202010.numberDay20201031;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountMax {


    private static int countMax(int[] arr) {

        int n = arr.length / 2;
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > n) {
                return arr[i];
            }

        }

        return -1;
    }

    private static int getCountMax(int[] num) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i])) {
                Integer count = map.get(num[i]);
                map.put(num[i],++count);
            }else{
                map.put(num[i],1);
            }
        }
      return   map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

    }

    private static  int getMaxCount(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length/2];

    }


    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        int[] arr1 = {2, 2, 1, 1, 1, 2, 2};
        int[] arr2 = {1, 2, 3};
        System.out.println(countMax(arr1));
        System.out.println(getCountMax(arr1));
        System.out.println(getMaxCount(arr1));
    }


}

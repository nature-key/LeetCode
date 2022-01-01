package 阶段热身.number202101.numberDay20210121;

public class Solution {


    /**
     * 暴力法
     *
     * @param a -
     * @return -
     */
    private static int getmaxArea(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int area = (j - i) * Math.min(a[i], a[j]);
               max= Math.max(max, area);
            }
        }
        return max;
    }

    /**
     * 双指针
     *
     * @return
     */
    private static int getMaxAear(int[] a) {
        int max = 0;

        for (int i = 0, j = a.length - 1; i < j; ) {
            int minHight = a[i] < a[j] ? a[i++] : a[j--];
            int area = (j - i + 1) * minHight;
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        int []a={1,8,6,2,5,4,8,3,7};
        System.out.println(getmaxArea(a));
        System.out.println(getMaxAear(a));
    }

}

package 阶段热身.number202101.numberDay20210116;

public class Solution {


    private boolean isHWString(String s) {

        String filters = getFilters(s);
        String resStr = resversString(filters);
        return resStr.equalsIgnoreCase(filters);
    }

    private String resversString(String filters) {

        return  new StringBuffer(filters).reverse().toString();
    }

    private String getFilters(String s) {

        return s.replaceAll("[^A-Za-z0-9]","");
    }

    public static void main(String[] args) {
        Solution solution =new Solution();
        System.out.println(solution.isHWString("aba"));
    }

}

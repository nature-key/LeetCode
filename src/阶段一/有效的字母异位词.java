package 阶段一;

public class 有效的字母异位词 {


    /**
     * 1.首先字母都是ASCII中的连续26的数值，因此每一个字符-'a' 都会在0-25之间
     * 2.我们遍历一个字符串，把字符串放到一个集合中记录他的数量
     * 3.然后我们在遍历另外一个字符串，减去他在集合中的数字
     * 4.同时校验第二元素所在元素的值是否小于0,如果是，说明是，如果不是说明多个字符或少个字符
     * @param s
     * @param t
     * @return
     */
    private static boolean isValid(String s, String t) {

        int[] result = new int[26];

        for (char c : s.toCharArray()) {
            result[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            result[c - 'a'] -= 1;
            if(result[c-'a']<0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String t="rat";
        String s="tar";
        System.out.println(isValid(s, t));
    }

    public boolean isAragem(String str1,String str2){
        if (str1.length()!=str2.length()) {
            return false;
        }
        int [] count=new int[26];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)-'a']+=1;
            count[str2.charAt(i)-'a']-=1;
        }
        for (int i : count) {
            if (i!=0) {
                return false;
            }
        }
        return true;
    }

}

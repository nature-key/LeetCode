package 阶段一;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        gen(0, 0, n, "", ans);
        return ans;
    }


    private static void gen(int left, int right, int n, String result, List<String> ans) {
        if (left == n && right == n) {
            ans.add(result);
            return;
        }
        if (left < n) {
            gen(left + 1, right, n, result + "(", ans);
        }
        if (right < n && left > right) {
            gen(left, right + 1, n, result + ")", ans);
        }
    }

    public static void main(String[] args) {


        System.out.println(generateParenthesis(3));
    }

    private List<String> result=new ArrayList<>();
    public List<String> generatn(int n){
        genkuohao(0,0,n,"",result);
        return result;

    }

    public void  genkuohao(int left, int right, int n, String s,List result){
        if (left==n&&right==n) {
            result.add(s);
            return;
        }
        if(left<n){
            genkuohao(left+1,right,n,s+"(",result);
        }
        if(left>right&&right<n){
            genkuohao(left,right+1,n,s+")",result);
        }
    }


    public  List<String> gen(int n){
        genkuohao1(0,0,n,"",result);
        return result;
    }

    public  void  genkuohao1(int left ,int right,int n,String str,List<String> result){

        if(left==n&&right==n){
            result.add(str);
            return;
        }

        if(left<n){
            genkuohao1(left+1,right,n,str+"(",result);
        }
        if(right<n&&right<left){
            genkuohao1(left,right+1,n,str+"(",result);
        }

    }


}

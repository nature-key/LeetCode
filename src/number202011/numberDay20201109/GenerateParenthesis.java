package number202011.numberDay20201109;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {


    private static void generate(String sublist, List<String> list, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(sublist);
            return;
        }
        if (left>0) {
            generate(sublist+"(",list,left-1,right);
        }
        if(right>left){
            generate(sublist+")",list,left,right-1);
        }
    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        int n=2;
        generate("",list,n,n);
        System.out.println(list.toString());
    }

}

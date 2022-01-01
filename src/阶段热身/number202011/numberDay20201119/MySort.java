package 阶段热身.number202011.numberDay20201119;

public class MySort {



    private static  int  sort(int x){
        if(x==1||x==0){
            return x;
        }
        int l=0;
        int r=x;
        int rest=-1;
        while (l<=r){
           int mid= (l+r)/2;

           if(mid==x/mid){
             return  mid;
           }else if(mid>x/mid){
               r=mid-1;
           }else{
               l=mid+1;
               rest=mid;
           }
        }
        return rest;
    }

    private static  int sort1(int x){
        if (x==1) {
            return 1;
        }
        double x0=x;
        double c=x;
        while (true){
            double x1=(x0+c/x0)/2;
            if (Math.abs(x0-x1)<1e-7) {
                break;
            }
            x0=x1;
        }
        return (int)x0;
    }



    public static void main(String[] args) {
        System.out.println(sort(8));
        System.out.println(sort1(8));
    }


}

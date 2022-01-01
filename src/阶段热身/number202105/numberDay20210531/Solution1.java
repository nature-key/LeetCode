package 阶段热身.number202105.numberDay20210531;

public class Solution1 {

    private final static  int D=256;
    private final static  int Q=9997;
    public static  int rabinKarpSearch(String txt,String pat){
        int M= pat.length();
        int N = txt.length();
        int i,j;
        int patHash=0,txtHash=0;

        for ( i = 0; i < M; i++) {
            patHash=(D*patHash+pat.charAt(i))%Q;
            txtHash=(D*txtHash+txt.charAt(i))%Q;
        }
        int highestPow=1;
        for ( i = 0; i < M-1; i++) {
            highestPow=(highestPow*D)%Q;
        }
        for ( i = 0; i < N-M; i++) {
            if(patHash==txtHash){
                for ( j = 0; j < M; j++) {
                    if(txt.charAt(i+j)!=pat.charAt(j)){
                        break;
                    }
                    if(i==M){
                        return i;
                    }
                }
            }
            if(i<N-M){
                txtHash=(D*(txtHash-txt.charAt(i)*highestPow)+txt.charAt(i+M))%Q;
                if(txtHash<0){
                    txtHash+=Q;
                }
            }

        }

        return -1;

    }
}

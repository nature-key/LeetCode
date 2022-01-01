package 阶段热身.number202109.number20210925;

public class Soultion {


    public static void main(String[] args) {

        Soultion soultion = new Soultion();

//        soultion.printToMaxofNDigits(3);
        soultion.printMaxNumer(3);

    }

    private  void   printMaxNumer(int n){
        int maxValue =(int) Math.pow(10, n) - 1;
        for (int i = 1; i <= maxValue; i++) {
            System.out.print(i);
            System.out.println();
        }
    }


    public void printToMaxofNDigits(int n){
        if(n<=0){
            return;
        }
        char[] number = new char[n];
        printToMaxofNDigits(number,0);
    }


    private void printToMaxofNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumer(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            printToMaxofNDigits(number, digit + 1);
        }
    }

    private void printNumer(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0') {
            index++;
        }
        while (index < number.length) {
            System.out.print(number[index++]);
        }
        System.out.println();

    }

}

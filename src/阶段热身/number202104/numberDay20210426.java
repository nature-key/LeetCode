package 阶段热身.number202104;

public class numberDay20210426 {


    private int[] xuanzeSort(int[] array) {
        int length = array.length;
        int temp;
        int minIndex;
        for (int i = 0; i < length; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    minIndex = j;
                }
            }
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        return array;
    }

    private int[] insertSort(int[] array) {

        int length = array.length;
        int preindex;
        int current;
        for (int i = 1; i < length; i++) {
            preindex = i - 1;
            current = array[i];
            while (preindex >= 0 && current < array[preindex]) {
                array[preindex + 1] = array[preindex];
                preindex--;
            }
            array[preindex + 1] = current;

        }
        return array;
    }

    private int[] mpSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length; j++) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }


    private static void quickSort(int[] array, int begin, int end) {
        int pivot = parrtition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int parrtition(int[] array, int begin, int end) {
        int pivot = end;
        int couner = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[couner];
                array[couner] = array[i];
                array[i] = temp;
                couner++;
            }
        }
        int temp = array[couner];
        array[couner] = array[pivot];
        array[pivot] = temp;
        return couner;
    }

    private static void mergeSort(int[]  array, int begin, int end) {

        int mid = (begin + end) >> 1;
        mergeSort(array, begin, mid);
        mergeSort(array, mid + 1, end);
        merge(array, begin, mid, end);
    }

    private static void merge(int[] array, int begin, int mid, int end) {
        int[] temp = new int[end - begin + 1];
        int i = begin;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            temp[k++] = array[i] >= array[j] ? array[j++] : array[i++];
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= end) {
            temp[k++] = array[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            array[begin + p] = temp[p];
        }
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 76, 9};
        numberDay20210426 l = new numberDay20210426();
        int[] ints = l.mpSort(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }

}

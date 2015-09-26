package chapter07;

/**
 * Created by bean on 9/27/15.
 */
public class q9_3 {
    // 针对有序无重复证型数组，magixIndex最多只能有一个
    public static int findMagixIndex(int[] arr, int start, int end){
        if(end < start || start < 0 || end >= arr.length)
            return -1;

        int middle = (start + end) / 2;
        if(arr[middle] == middle){
            return middle;
        } else if (arr[middle] > middle){
            return findMagixIndex(arr, start, middle - 1);
        } else {
            return findMagixIndex(arr, middle + 1, end);
        }
    }

    // 针对有序可能重复数组，magixIndex可能有多个
    public static void printMagixIndex(int[] arr, int start, int end){
        if(end < start || start < 0 || end >= arr.length)
            return;

        int middle = (start + end) / 2;
        if(arr[middle] == middle){
            System.out.println("magic number found: " + middle);
            printMagixIndex(arr, start, middle - 1);
            printMagixIndex(arr, middle + 1, start);
        } else {
            int leftIndex = Math.min(middle - 1, arr[middle]);
            int rightIndex = Math.max(middle + 1, arr[middle]);

            printMagixIndex(arr, start, leftIndex);
            printMagixIndex(arr, rightIndex, end);
        }
    }

    public static void main(String[] args) {
        int a[] = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        int a2[] = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        System.out.println("magix index found: " + findMagixIndex(a, 0, a.length - 1));
        printMagixIndex(a2, 0, a2.length - 1);
    }
}

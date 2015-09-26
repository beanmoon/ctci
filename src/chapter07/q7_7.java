package chapter07;

/**
 * Created by bean on 9/26/15.
 */
public class q7_7 {
    public static void getMagicNumber(int index){
        int[] arr = new int[index];
        int pos3 = 0, pos5 = 0, pos7 = 0;

        arr[0] = 1;
        int i = 1;
        while(i < index){
            int nextValue = min(arr[pos3] * 3, arr[pos5] * 5, arr[pos7] * 7);
            arr[i++] = nextValue;
            while(arr[pos3] * 3 <= nextValue)
                pos3++;
            while(arr[pos5] * 5 <= nextValue)
                pos5++;
            while(arr[pos7] * 7 <= nextValue)
                pos7++;
        }

        for(int j = 0; j < index; j++){
            System.out.print(arr[j] + " ");
        }

    }

    public static int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        getMagicNumber(15);
    }
}

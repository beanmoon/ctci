package chapter07;

/**
 * Created by bean on 9/26/15.
 */
public class q9_1 {
    public static int max = 100;
    public int[] steps = new int[max];


    public int count(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;
        if(steps[n] != 0) return steps[n];

        steps[n] = count(n-1) + count(n-2) + count(n-3);
        return  steps[n];
    }

    public static void main(String[] args) {
        q9_1 q = new q9_1();
        System.out.println(q.count(10));
    }
}

package chapter07;

/**
 * Created by bean on 9/27/15.
 */
public class p9_8 {
    public static int makeChange(int n, int denom){
        int next_daemon = 0;
        switch (denom){
            case 25:
                next_daemon = 10;
                break;
            case 10:
                next_daemon = 5;
                break;
            case 5:
                next_daemon = 1;
                break;
            case 1:
                return 1;
        }

        int ways = 0;
        for(int i = 0; i * denom <= n; i++){
            ways += makeChange(n - i * denom, next_daemon);
        }

        return  ways;
    }


    public static void main(String[] args) {
        System.out.println(makeChange(100, 25));
    }
}

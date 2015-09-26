package chapter07;

/**
 * Created by bean on 9/26/15.
 */
public class q9_2 {
    public static int p(int x, int y){
        if(x == 0 || y == 0)
            return 1;
        return p(x-1, y) + p(x, y-1);
    }

    public static void main(String[] args) {
        System.out.println(p(2,3));
    }
}

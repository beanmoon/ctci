package chapter07;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bean on 9/26/15.
 */
public class q7_4 {
    public static int negative(int a){
        int neg = 0;
        int d = a > 0 ? -1 : 1;
        while(a != 0){
            neg += d;
            a += d;
        }

        return  neg;
    }

    public static int minus(int a, int b){
        return a + negative(b);
    }

    public static int multiply(int a, int b){
        int rst = 0;

        if(a < b)
            return multiply(b, a);

        List<Boolean> flags = new ArrayList<Boolean>();
        while(b > 0){
            if(b % 2 == 1)
                flags.add(true);
            else
                flags.add(false);
            b /= 2;
        }

        int exp = 0, count = 0;
        for(int i = 0; i < flags.size(); i++){
            if(exp == 0)
                exp = a;
            else {
                exp += exp;
                count++;
            }
            if(flags.get(i)){
                rst += exp;
                count++;
            }

        }
        System.out.println("There is " + count + " times of addition executed!");
        return  rst;
    }

    public static void main(String[] args) {
        System.out.println(multiply(8, 7));
    }
}

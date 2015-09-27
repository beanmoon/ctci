package chapter07;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bean on 9/27/15.
 */
public class q9_5 {
    public static List<ArrayList<Character>> permutation(List<Character> set, int k){
        List<ArrayList<Character>> rst = new ArrayList<ArrayList<Character>>();
        if(k == 0){
            ArrayList<Character> tmp = new ArrayList<Character>();
            tmp.add(set.get(0));
            rst.add(tmp);
        } else {
            List<ArrayList<Character>> pers = permutation(set, k - 1);
            char c = set.get(k);
            for(ArrayList<Character> per: pers){
                for(int i = 0; i <= per.size(); i++){
                    ArrayList<Character> tmp = new ArrayList<Character>(per);
                    tmp.add(i, c);
                    rst.add(tmp);
                }
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        List<Character> list = new ArrayList<Character>();
        for(int i = 0; i < 5; i++)
            list.add((char)('a' + i));

        List<ArrayList<Character>> pers = permutation(list, list.size() - 1);
        int count = 0;
        for(int i = 0; i < pers.size(); i++){
            ArrayList<Character> per = pers.get(i);
            for(Character c : per){
                System.out.print(c);
            }
            System.out.println();
            count++;
        }

        System.out.println("count = " + count);
    }
}

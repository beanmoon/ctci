package chapter07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bean on 9/27/15.
 */
public class q9_6 {
    public static Set<String> generateParens(int num){
        Set<String> set = new HashSet<String>();
        if(num == 0){
            set.add("");
        } else {
            Set<String> tmp = generateParens(num - 1);
            for(String str : tmp){
                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) == '('){
                        String s = insertParen(str, i);
                        set.add(s);
                    }
                }

                if(!set.contains("()" + str)){
                    set.add("()" + str);
                }
            }
        }

        return set;
    }

    public static String insertParen(String str, int i){
        String left = str.substring(0, i+1);
        String right = str.substring(i + 1, str.length());

        return left + "()" + right;
    }

    public static void addParen(ArrayList<String> list, int leftrem, int rightrem, char[] str, int count){
        if(leftrem < 0 || leftrem > rightrem) return;

        if(leftrem == 0 && rightrem == 0){
            String s = String.copyValueOf(str);
            list.add(s);
        } else {
            if(leftrem > 0){
                str[count] = '(';
                addParen(list, leftrem - 1, rightrem, str, count + 1);
            }

            if(rightrem > leftrem){
                str[count] = ')';
                addParen(list, leftrem, rightrem - 1, str, count + 1);
            }
        }
    }

    public static ArrayList<String> generatePerens(int count){
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, count, count, str, 0);
        return list;
    }

    public static void main(String[] args) {
        int count = 3;
        ArrayList<String> list = generatePerens(count);
        /*
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
        */


        Set<String> set = generateParens(3);
        for(String str: set){
            System.out.println(str);
        }
    }
}
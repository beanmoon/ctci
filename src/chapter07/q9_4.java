package chapter07;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by bean on 9/27/15.
 */
public class q9_4 {
    // 以递归方式实现获取子集
    public static List<ArrayList<Integer>> getSubset(List<Integer> set, int index){
        List<ArrayList<Integer>> rst = null;
        if(set.size() == index){
            rst = new ArrayList<ArrayList<Integer>>();
            rst.add(new ArrayList<Integer>());
        } else {
            rst = getSubset(set, index + 1);
            int item = set.get(index);
            List<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset : rst){
                ArrayList<Integer> tmp  = new ArrayList<Integer>();
                tmp.addAll(subset);
                tmp.add(item);
                moreSubsets.add(tmp);
            }
            rst.addAll(moreSubsets);
        }

        return rst;
    }

    // 以迭代方式实现获取子集
    public static List<ArrayList<Integer>> getSubset2(List<Integer> set, int index){
        List<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        rst.add(new ArrayList<Integer>());
        for(int i = 0; i < index; i++){
            int item = set.get(i);
            List<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> list: rst){
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.addAll(list);
                tmp.add(item);
                moreSubsets.add(tmp);
            }
            rst.addAll(moreSubsets);
        }

        return rst;
    }

    // 以数学组合方式实现获取子集
    public static List<ArrayList<Integer>> getSubset3(List<Integer> set, int index){
        List<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        int k = 1 << index;
        for(int i = 0; i < k; i++){
            rst.add(int2set(set, i));
        }
        return rst;
    }

    public static ArrayList<Integer> int2set(List<Integer> set, int k){
        ArrayList<Integer> rst =new ArrayList<Integer>();
        int i = 0;
        while(k > 0){
            int index = k & 1;
            if(index == 1){
                rst.add(set.get(i));
            }
            i++;
            k = k >> 1;
        }

        return rst;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 5; i++){
            list.add(i);
        }

        List<ArrayList<Integer>> subsets = getSubset3(list, 5);
        int count = 0;
        for(int i = 0; i < subsets.size(); i++){
            ArrayList<Integer> tmp = subsets.get(i);
            System.out.print("{");
            for(int j = 0; j < tmp.size(); j++){
                System.out.print(tmp.get(j) + " ");
            }
            System.out.println("}");
            count++;
        }
        System.out.println("count = " + count);
      }
}

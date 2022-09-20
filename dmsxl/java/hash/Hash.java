package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * hash表相关题
 * time：2022/9/18
 */
public class Hash {
    public static void main(String[] args) {

    }

    /**
     * q：有效的字母异位词，lc242
     * grade：easy
     * time：2022/9/18
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        // 方法一：哈希表
//        if(s.length()!=t.length()){
//            return false;
//        }
//        HashMap<String,Integer> map=new HashMap<>();
//        for(char c:s.toCharArray()){
//            if(!map.containsKey(String.valueOf(c))){
//                map.put(String.valueOf(c),1);
//            }else{
//                map.put(String.valueOf(c),map.get(String.valueOf(c))+1);
//            }
//        }
//
//        for(char c:t.toCharArray()){
//            if(!map.containsKey(String.valueOf(c))){
//                return false;
//            }
//            if(map.get(String.valueOf(c))==1){
//                map.remove(String.valueOf(c));
//            }else{
//                map.put(String.valueOf(c),map.get(String.valueOf(c))-1);
//            }
//        }
//        return true;

        // 方法二：数组
        if(s.length()!=t.length()){
            return false;
        }
        int[] arr=new int[26];
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }

        for(char c:t.toCharArray()){
            arr[c-'a']--;
        }
        for(int i:arr){
            if(i!=0){
                return false;
            }
        }
        return true;
    }

    /**
     * q：两个数组的交集
     * grade：easy
     * time：2022/9/18
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> resSet=new HashSet<>();
        for(int i:nums1){
            set.add(i);
        }

        for(int i:nums2){
            if(set.contains(i)){
                resSet.add(i);
            }
        }
        int[] res=new int[resSet.size()];
        int i=0;
        for (Integer num : resSet) {
            res[i++]=num;
        }
        return res;
    }

    /**
     * q：快乐数
     * grade：easy
     * time：2022/9/18
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        // 防止循环
        HashSet<Integer> set=new HashSet<>();
        while (n>1 && !set.contains(n)){
            set.add(n);
            int i=0;
            while (n!=0){
                i+=Math.pow(n,2);
                n/=10;
            }
            n=i;
        }
        return n==1?true:false;
    }
}

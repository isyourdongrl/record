import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().minOperations("abab"));
    }

    public int minOperations (String str) {
        // write code here
        char[] arr=str.toCharArray();
        HashMap<String,Integer> map=new HashMap<>();
        for(char a:arr){
            if(!map.containsKey(String.valueOf(a))){
                map.put(String.valueOf(a),1);
            }else{
                map.put(String.valueOf(a),map.get(String.valueOf(a))+1);
            }
        }



        int res=0;
        boolean flag=true;
        while (flag){
            flag=false;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue()>=2){
                    entry.setValue(entry.getValue()-1);
                    res+=1;
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue()>=2){
                    flag=true;
                }
            }
        }



//        int res=0;
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if(map.size()<=13){
//                res=res+entry.getValue()/2;
//            }
//
//        }
        return res;
    }



    HashMap<Integer, Character> map = new HashMap<>();
    public int minOperations1 (String str) {

        char c='a';

        int[] arr=new int[26];
        for(char a:str.toCharArray()){
            arr[a-'a']++;
        }

        for(int i=0;i<26;i++){
            map.put(i,c++);
        }

        int res=0;
        boolean flag=true;
        while (flag){
            flag=false;
            for(int i=0;i<arr.length;i++){
                if(arr[i]>=2){
                    arr[i]-=2;
                    res++;
                    arr[method(arr)-'a']++;
                }
            }

            for(int i=0;i<arr.length;i++){
                if(arr[i]>=2){
                    flag=true;
                }
            }
        }
        return res;

    }

    char method(int[] arr){
        char a='a';
        boolean flag=true;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                return map.get(i);
            }
            if(arr[i]==1 && flag){
                a=map.get(i);
                flag=false;
            }
        }
        if(flag){
            return map.get(1);
        }
        return a;
    }


    public TreeNode dfs(int[] pre,int[] in){
        if(pre.length==0 || in.length==0){
            return null;
        }

        TreeNode root=new TreeNode(pre[0]);
        for(int i=0;i<in.length;i++){
            if(in[i]==pre[0]){
                root.left=dfs(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,i+1,in.length));
                root.right=dfs(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return root;
    }


}

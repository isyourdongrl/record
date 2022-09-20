
import tree.TreeNode;

import java.util.*;

/**
 * 有时候见到会写一下
 */
public class free {


    public static void main(String[] args) {
        // hne-pre:ag_hh_sms_action_storage
        List<String> hne=new ArrayList<>();
        hne.add("ag_glut_action_storage");
        hne.add("ag_coupon_action_storage");
        hne.add("ag_common_action_storage");
        hne.add("ag_retry");
        hne.add("ag_glut_retry");
        hne.add("ag_real_time_storage");
        hne.add("ag_real_time_retry_storage");
        hne.add("ag_dmc_action_storage");
        hne.add("ag_groupmsg_action_storage");
        hne.add("ag_priority_high_action_storage");
        hne.add("ag_brand_coupon_action_storage");
        hne.add("ag_hh_push_action_storage");
        hne.add("ag_hh_sms_action_storage");

        List<String> hnb=new ArrayList<>();
        hnb.add("ag_retry");
        hnb.add("ag_hh_sms_action_storage");
        hnb.add("ag_real_time_storage");
        hnb.add("ag_dmc_action_storage");
        hnb.add("ag_groupmsg_action_storage");
        hnb.add("ag_hh_push_action_storage");
        hnb.add("ag_brand_coupon_action_storage");
        hnb.add("ag_priority_high_action_storage");
        hnb.add("ag_real_time_retry_storage");
        hnb.add("ag_glut_retry");
        hnb.add("ag_common_action_storage");
        hnb.add("ag_coupon_action_storage");
        hnb.add("ag_glut_action_storage");


        List<String> res=new ArrayList<>();
        for(String s:hne){
            if(!hnb.contains(s)){
                res.add(s);
            }
        }

        for (String s:res){
            System.out.println(s);
        }

    }






    /**
     * 判断入栈序列和出栈序列是否对应  剑指offer31
     * @param pushed 入栈序列
     * @param popped 出栈序列
     * @return
     */
    public static boolean validateStackSequences(int[] pushed,int[] popped){
        if(pushed.length!=popped.length){
            return false;
        }

        Stack<Integer> stack=new Stack<>();
        int j=0;
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(j<popped.length){
                if(!stack.isEmpty() && stack.peek()==popped[j]){
                    stack.pop();
                    j++;
                }else{
                    break;
                }
            }

        }
        return stack.isEmpty()?true:false;
    }

    /**
     * q：二叉树的前序遍历 lc144
     * grade：mid
     * time：2022/9/7
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return null;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            // 拿出这个Node
            TreeNode node=stack.pop();
            res.add(node.val);
            // 先装右节点，后装左节点
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return res;
    }

    /**
     * q：二叉树的层次遍历 lc102
     * grade：mid
     * time：2022/9/6
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            // 获取queue此时容量
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                // 拿出这层的Node
                TreeNode node=queue.poll();
                list.add(node.val);
                // 将这个节点的左右子节点放入queue中
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }


    /**
     * q：爬楼梯 lc10
     * grade：easy
     * time：2022/9/7
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    /**
     * q：二叉树中的最大路径和 lc124
     * grade：diff
     * time：2022/9/7
     * @param root
     * @return
     */
    int ret=0;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return ret;
    }

    private int getMax(TreeNode r) {
        if(r == null) return 0;
        int left = Math.max(0, getMax(r.left)); // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int right = Math.max(0, getMax(r.right));
        ret = Math.max(ret, r.val + left + right); // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        return Math.max(left, right) + r.val;
    }


    /**
     * 01背包示例
     * @param arr
     * @param capacity
     * @return
     */
    public int method(int[] arr,int capacity){

        int[][] dp=new int[arr.length][capacity+1];
        for(int i=1;i<capacity+1;i++){
            if(i<arr[0]){
                dp[0][i]=arr[0];
            }
        }


        for(int i=0;i<arr.length;i++){
            for(int j=1;j<=capacity;j++){
                if(j<arr[i]){
                    // 当前背包容量不够物体的重量
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-arr[i]]+arr[i]);
                }
            }
        }

        return dp[arr.length-1][capacity];
    }

    /**
     * q:删除数组内的重复元素，O(N)时间复杂度
     * @return
     */
    public int[] deleteRepeat(int[] arr){
        int left=0;
        int right=1;
        while (right<arr.length){
            if(arr[right]!=arr[right]){
                right++;
            }
            left++;
        }
        return arr;
    }

    /**
     * q：有一个非空的乱序数组，其中有若干个0，请将所有的0全部移到数组末尾，同花顺笔试
     * time：2022/9/19
     * @param arr
     */
    public void method(int[] arr){
        int r=arr.length;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                arr[i]=arr[i]^arr[r];
                arr[r]=arr[i]^arr[r];
                arr[i]=arr[i]^arr[r];
                r--;
            }
        }
        return;
    }
}

/**
 * hnb：10.88.128.16:8000
 * 10.88.128.16:8000
 * http://10.88.128.16:8000/
 * http://10.88.128.16:8000/g
 * 
 * 
 * 
 *      ag_glut_action_storage
 *      ag_coupon_action_storage
 *      ag_common_action_storage
 *      ag_glut_retry
 *      ag_real_time_retry_storage
 *      ag_priority_high_action_storage
 *      ag_brand_coupon_action_storage
 * ag_hh_push_action_storage
 */




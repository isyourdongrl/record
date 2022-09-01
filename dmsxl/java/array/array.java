package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class array {

    public static void main(String[] args) throws Exception{
        System.out.println(new array().generateMatrix(3));
    }
    /**
     * q:二分查找 lc704
     * grade：easy
     * time：2022/8/22 15:18
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }


    /**
     * q：原地移除指定元素 lc27
     * grade：easy
     * time：2022/8/22 15:19
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    /**
     * q：有序数组的平方，lc977
     * grade：easy
     * time：2022/8/22 20:41
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        // 要从后面向前输入，最前面和最后面才有可能是最大的
        int k = nums.length - 1;
        while (l <= r) {
            if (nums[r] * nums[r] > nums[l] * nums[l]) {
                arr[k--] = nums[r] * nums[r];
                r--;
            } else {
                arr[k--] = nums[l] * nums[l];
                l++;
            }
        }
        return arr;
    }


    /**
     * q：长度最小的子数组，lc209
     * grade：mid
     * time：2022/8/4 15：26
     * @param target
     * @param nums
     * @return
     */
    // eg：2,3,1,2,4,3     7
    public int minSubArrayLen(int target, int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }

        int l=0;
        int min=nums.length+1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=target && l<nums.length){
                min=Math.min(min,i-l+1);
                sum-=nums[l++];
            }
        }
        return min==nums.length+1?0:min;
    }


    /**
     * q：螺旋矩阵二，lc59
     * grade：mid
     * time：2022/8/24 15：26
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        // 值
        int val=0;
        int top=0;
        int down=n-1;
        int left=0;
        int right=n-1;
        int[][] res=new int[n][n];
        while(val<n*n){
            // 上面
            for(int i=left;i<=right;i++){
                res[top][i]=++val;
            }
            // 右面
            for(int i=top+1;i<=down;i++){
                res[i][right]=++val;
            }
            // 下面
            for(int i=right-1;i>=left;i--){
                res[down][i]=++val;
            }
            // 左面
            for(int i=down-1;i>top;i--){
                res[i][left]=++val;
            }
            top++;
            down--;
            left++;
            right--;
        }
        return res;
    }
}

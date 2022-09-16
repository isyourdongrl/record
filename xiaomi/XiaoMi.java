import list.ListNode;
import tree.TreeNode;

import java.io.Console;
import java.util.*;

public class XiaoMi {
    public static int Number = 0;

    public XiaoMi() {
        Number++;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 3, 1, 42, 2};
        new XiaoMi().quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    /**
     * q：二叉树的层序遍历，lc102，小米安卓一面
     * grade：mid
     * time：2022/9/12
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 获取这层的节点数量
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }


    /**
     * q：最大子数组和，lc53，小米安卓二面
     * grade：mid
     * time：2022/9/12
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // nums为空
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // nums长度为1
        if (nums.length == 1) {
            return nums[0];
        }

        int i = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while (i < nums.length) {
            // 若sum<0，则sum重新开始计算
            if (sum < 0) {
                sum = 0;
            } else {
                sum += nums[i++];
                max = Math.max(max, sum);
            }
        }
        return max;
    }


    /**
     * q：环形链表，lc141，小米安卓一面
     * grade：easy
     * time：2022/9/12
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
//        // 哈希表
//        if(head==null || head.next==null){
//            return false;
//        }
//        HashSet<ListNode> set=new HashSet<>();
//        while (head!=null){
//            if (!set.contains(head)){
//                set.add(head);
//                head=head.next;
//            }else{
//                return true;
//            }
//        }
//        return false;

        // 快慢指针
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    /**
     * q：二叉树的中序遍历(非递归)，lc94，小米安卓二面
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root.left;
        stack.push(root);
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                res.add(node.val);
                cur = node.right;
            }
        }
        return res;
    }

    /**
     * q：重排链表，剑指offer二26，小米安卓java开发一面
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 找到中点
        ListNode slow = head;
        ListNode fast = head;
        // 中点
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转链表
        ListNode lastHead = reverse(pre.next);
        pre.next = null;
        // 合并链表
        merge(head, lastHead);
    }

    // 反转
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        head = head.next;
        pre.next = null;
        while (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head.next = pre;
        return head;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while (head1 != null && head2 != null) {
            node.next = head1;
            node = node.next;
            head1 = head1.next;
            node.next = head2;
            node = node.next;
            head2 = head2.next;
        }

        while (head1 != null) {
            node.next = head1;
            node = node.next;
            head1 = head1.next;
        }

        while (head2 != null) {
            node.next = head2;
            node = node.next;
            head2 = head2.next;
        }
        return dummy.next;
    }


    /**
     * q：牛客59，矩阵的最小路径路径和，小米安卓可接受java二面
     *
     * @param matrix
     * @return
     */
    public int minPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        // 第一层
        for (int i = 1; i < matrix.length; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        // 第一列
        for (int i = 1; i < matrix[0].length; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[matrix.length - 1][matrix[0].length - 1];
    }


    /**
     * q：最小覆盖子串，lc76，小米安卓可接收java二面
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        return "";
    }

    /**
     * q：找数组中第一次只出现一次的数，无lc原题，小米安卓一面
     * @param arr
     * @return
     */
    public int firstNum(int[] arr){
        if(arr==null || arr.length==0){
            return -1;
        }
        if(arr.length==1){
            return arr[0];
        }

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.put(i,map.get(i)+1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * q：二叉树的深度，剑指offer55，小米安卓一面
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        // 结束条件
        if(root==null){
            return 0;
        }

        // 获取左子树的深度
        int left=maxDepth(root.left);
        // 获取右子树的深度
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;
    }

    /**
     * q：加一个字符后判断字符串是否能够构造为回文串，牛客付费题目，小米安卓一面
     * @param str
     * @return
     */
    public boolean addCharPalindrome(String str){
        if(str==null || str.length()==0){
            return true;
        }

        char[] arr=str.toCharArray();
        int i;
        int j;
        for(i=0,j=arr.length-1;i<=j;i++,j++) {
            if (arr[i] != arr[j]) {
                break;
            }
        }
        // 若原本就是回文串，则可以构造成回文串
        if(i>j){
            return true;
        }
        // 若原先不是回文串，则给原本的回文串减一个字符，判断是否为回文串
        if(isPalindrome(i,j-1,arr) || isPalindrome(i+1,j,arr)){
            return true;
        }
        return false;
    }

    public boolean isPalindrome(int i,int j,char[] arr){
        while (i<=j){
            if(arr[i]!=arr[j]){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    /**
     * q：判断相交链表，lc160，小米安卓二面
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }

        // 方法一：使用map
//        HashSet<ListNode> set=new HashSet<>();
//        while (headA!=null){
//            set.add(headA);
//            headA=headA.next;
//        }
//
//        while (headB!=null){
//            if(set.contains(headB)){
//                return headB;
//            }
//        }
//        return null;

        // 方法二
        ListNode hA=headA;
        ListNode hB=headB;
        while (hA!=hB){
            hA=hA==null?headB:hA.next;
            hB=hB==null?headA:headB.next;
        }
        return hA;
    }

    /**
     * q：判断数字是否回文，牛客56，小米安卓实习二面
     * @param x
     * @return
     */
    public boolean isPalindrome (int x) {
        String str=String.valueOf(x);
        if(str.length()==1){
            return true;
        }

        int i=0;
        int j=str.length()-1;
        while (i<=j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * q：链表指定位置反转，lc92，小米安卓二面
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null){
            return head;
        }

        // 设置虚拟头节点
        ListNode dummy=new ListNode();
        dummy.next=head;

        // 找到left的pre
        ListNode superior=dummy;
        for(int i=0;i<left-1;i++){
            superior=superior.next;
        }

        // 反转链表
        ListNode pre=null;
        ListNode cur=superior.next;
        for(int i=0;i<=right-left;i++){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }

        // 将super.next指向最后一个
        superior.next.next=cur;
        superior.next=pre;

        return dummy.next;
    }





    /**
     * 快排算法
     *
     * @param arr   数组名称
     * @param left  数组最初始的时候，最左边的下标，初始为0
     * @param right 数组最初始的时候，最右边的下标，初始为arr.length-1
     */
    public static void quickSort(int[] arr, int left, int right) {

        //是递归结束的条件，当传来的数组长度小于等于1的时候，就没必要排序了，直接返回
        if (arr == null || arr.length <= 1 || left >= right) {
            return;
        }

        int l = left;//从左边开始
        int r = right;//从右边开始
        int key = arr[left];//key始终是数组最左边的数字

        //当l和r不相同的时候
        //若l和r相同，那么说明第一次快排已经完成
        while (l != r) {
            //先从右边开始判断是否比key大
            //右边大于等于key的可以进来，直到右边小于key的时候听下，得到此时的下标
            while (arr[r] >= key & l < r) {
                r--;
            }
            //找到右边的之后，再从左边开始找，找到大于key的下标
            while (arr[l] <= key & l < r) {
                l++;
            }
            //此时已经找到了右边小于key的小标和左边大于key的下标
            //进行交换
            if (l < r) {
                arr[l] = arr[l] ^ arr[r];
                arr[r] = arr[l] ^ arr[r];
                arr[l] = arr[l] ^ arr[r];
            }
        }
        //进行到这说明左指针和右指针已经重合，此时应该将指针的数字和key进行交换
        //这块的arr[left]是数组最边的数组，也就是key
        arr[left] = arr[l];
        arr[l] = key;
        //进行到这说明第一次快排已经完成
        //可以直到key其实将数组分成了两半，左边是比key都小的，右边是比key都大的
        //那么继续可以使用快排思想，将剩下的两半进行快排
        quickSort(arr, left, l - 1);
        quickSort(arr, r + 1, right);
    }


}

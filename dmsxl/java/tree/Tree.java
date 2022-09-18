package tree;


import java.util.*;

public class Tree {

    public static void main(String[] args) {

    }

    /**
     * q：二叉树的前序遍历 lc144
     * grade：easy
     * time：2022/9/11
     * @param root
     * @return
     */
//    List<Integer> res=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        // 递归写法
//        if(root==null){
//            return res;
//        }
//
//        res.add(root.val);
//        preorderTraversal(root.left);
//        preorderTraversal(root.right);
//        return res;

        // 非递归写法
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            res.add(node.val);
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
     * q：二叉树的中序遍历 lc94
     * grade：easy
     * time：2022/9/11
     * @param root
     * @return
     */
//    List<Integer> res=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归
//        if(root==null){
//            return res;
//        }
//        inorderTraversal(root.left);
//        res.add(root.val);
//        inorderTraversal(root.right);
//        return res;

        // 非递归
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        TreeNode cur=root.left;
        while (cur!=null || !stack.isEmpty()){
            // 只要有左子树，就向左子树走
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                // 无左子树，拿跟节点
                TreeNode node=stack.pop();
                res.add(node.val);
                // 指向右子树
                cur=node.right;
            }
        }
        return res;
    }


    /**
     * q：二叉树的后续遍历
     * grade：easy
     * time：2022/9/11
     * @param root
     * @return
     */
//    List<Integer> res=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        // 递归
//        if(root==null){
//            return res;
//        }
//        postorderTraversal(root.left);
//        postorderTraversal(root.right);
//        res.add(root.val);
//        return res;

        // 非递归
        if(root==null){
            return res;
        }
        // 后序：左->右->根
        //      根->右->左
        // 和前序差不多
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            res.add(node.val);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    /**
     *q：N叉树的前序遍历
     * grade：easy
     * time：2022/9/11
     * @param root
     * @return
     */
//    List<Integer> res=new ArrayList<>();
    public List<Integer> preorder(Node root) {
        // 递归
        if(root==null){
            return res;
        }
        res.add(root.val);
        for (Node node:root.children){
            preorder(node);
        }
        return res;
        // 非递归
//        if(root==null){
//            return res;
//        }
//        Stack<Node> stack=new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()){
//            Node node=stack.pop();
//            res.add(node.val);
//            if(node.children!=null){
//                List<Node> list=node.children;
//                for(int i=list.size()-1;i>=0;i--){
//                    stack.push(list.get(i));
//                }
//            }
//        }
//        return res;
    }

    /**
     * q：N叉树的后序遍历
     * grade：easy
     * time：2022/9/11
     * @param root
     * @return
     */
//    List<Integer> res=new ArrayList<>();
    public List<Integer> postorder(Node root) {
        // 递归
//        if(root==null){
//            return res;
//        }
//        for(Node node:root.children){
//            postorder(node);
//        }
//        res.add(root.val);
//        return res;

        // 非递归
        if(root==null){
            return res;
        }
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node=stack.pop();
            res.add(node.val);
            for (Node childNode:node.children){
                stack.push(childNode);
            }
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * q：翻转二叉树
     * grade：easy
     * time：2022/9/11
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return root;
        }

        TreeNode node=root.left;
        root.left=root.right;
        root.right=node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * q：在每个树行中找最大值
     * grade：mid
     * time：2022/9/11
     * @param root
     * @return
     */
    List<Integer> res=new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root==null){
            return res;
        }
        // 使用层序遍历即可
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    // 注意：用例中有0，-2147483647，2147483647
                    // 两个相减会超出int的范围
                    if(o2>o1){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            });
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                priorityQueue.offer(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(priorityQueue.peek());
        }
        return res;
    }

    /**
     * q：二叉树的最大深度
     * grade：easy
     * time：2022/9/11
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        // 分别获取左树的深度和右树的深度
//        if(root==null){
//            return 0;
//        }
//        int left=maxDepth(root.left)+1;
//        int right=maxDepth(root.right)+1;
//        return Math.max(left,right);

        // 直接一步完
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }

    /**
     * q:二叉树的最小深度
     * grade：easy
     * time：2022/9/11
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=minDepth(root.left)+1;
        int right=minDepth(root.right)+1;
        // 注意：有些二叉树为链式结构，所以需要判断是否为1，若为1则返回另外一个高度
        if(left==1 || right==1){
            return left==1?right:left;
        }
        return Math.min(left,right);
    }

    /**
     * q：完全二叉树的节点个数
     * grade：mid
     * time：2022/9/11
     * 递归思路：将大问题拆解为相同的小问题，对这个小问题进行操作
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        // root节点的左子树节点总数
        int left=countNodes(root.left);
        // root节点右子树节点总数
        int right=countNodes(root.right);
        // root节点的总数
        int res=left+right+1;
        return res;
    }

    /**
     * q：平衡二叉树
     * grade：easy
     * time：2022/9/11
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        // 结束条件：若为null，则返回true
        if(root==null){
            return true;
        }
        return getHeight(root)==-1?false:true;
    }

    public int getHeight(TreeNode root){
        // 递归结束条件
        if(root==null){
            return 0;
        }

        // 本层处理逻辑
        // 分别获取左子树和右子树的高度
        int left=getHeight(root.left);
        int right=getHeight(root.right);

        // 返回值
        // 若左子树或者右子树不平衡
        if(left==-1 || right==-1){
            return -1;
        }
        // 左子树的高度与右子树高度相差大于1
        if(Math.abs(left-right)>1){
            return -1;
        }
        // 返回树的高度
        return 1+Math.max(left,right);
    }
}


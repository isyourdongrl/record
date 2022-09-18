import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 贝壳相关面经算法题
 */
public class BeiKe {


    /**
     * q：二叉树中和为某一值的路径，lc剑指offer34，贝壳安卓一面
     * grade:mid
     * time:2022/9/17
     * @param root
     * @param target
     * @return
     */
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        method(root,target,new ArrayList<>());
        return res;
    }

    public void method(TreeNode root,int target,List<Integer> collector){
        // 结束条件
        if(root==null){
            return;
        }

        target-=root.val;
        collector.add(root.val);
        if(target==0 && root.left==null && root.right==null){
            // 如果满足上面条件，说明这条链路已经满足题目要求
            res.add(new ArrayList<>(collector));
        }else{
            // 若没有满足，则继续递归
            method(root.left,target,collector);
            method(root.right,target,collector);
        }

        // 若满足条件了，则去掉最后一个节点，重新看右边的链路是否满足条件
        collector.remove(collector.size()-1);
    }
}

import java.util.Stack;

/**
 * 有时候见到会写一下
 */
public class free {

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
}

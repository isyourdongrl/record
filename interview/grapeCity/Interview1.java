/**
 * 场景题，写能够实现五子棋的类
 */
public class Interview1 {

}


// 棋盘
class QiPan{

    private int size;
    // 初始化为0，1为白棋，2为黑棋
    private int[][] arr;

    private Node[][] arr1;

    public QiPan(){}


    // 初始化棋盘
    public QiPan(int size){
        this.size=size;
        arr=new int[size][size];
    }

    public static boolean set(QiZi qizi,int x,int y){
        if(qizi instanceof Black){
            // 给棋盘set
        }else {

        }
        return true;
    }


    public static boolean isSuccess(){
        // 逻辑
        return true;
    }
}


// 棋子
 interface QiZi{
    // 这个位置是否有棋子
    boolean get(int x,int y);

    // 下棋
    boolean set(int x,int y);
}



// 黑棋
class Black implements QiZi{

    @Override
    public boolean get(int x, int y) {
        return false;
    }

    @Override
    public boolean set(int x, int y) {
        QiPan.set(this,x,y);
        return false;
    }
}


// 白棋
class White implements QiZi{

    @Override
    public boolean get(int x, int y) {
        return false;
    }

    @Override
    public boolean set(int x, int y) {
        return false;
    }
}


class Node{
    String name;
    // true 红方，false 另一方
    boolean isRed;
}








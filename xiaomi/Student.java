import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 内部类、匿名内部类、静态内部类的区别
 */
public class Student {

    String name;
    int age;
    char sex;
    static String classRoom;

    public String getName(){
        return this.name;
    }

    public static String getClassRoom(){
        return classRoom;
    }

    /**
     * 内部类
     * 1：内部类可以直接使用外部类的成员变量
     * 2：内部类可以直接使用外部类的成员方法
     * 3：内部类不可以创建静态变量和方法
     */
    class Node{
        public void method(){
            // 内部类可以直接使用外部类的成员变量
            int len=name.length();
            // 内部类可以直接使用外部类的成员方法
            String name=getName();
        }
    }

    /**
     * 静态内部类
     * 1：静态内部类可以直接使用外部类的静态成员变量
     * 2：静态内部类可以直接使用外部类的静态成员方法
     * 3：静态内部类不可以直接使用外部类的非静态成员变量和方法
     */
    static class Node1{
        // 静态内部类可以有静态方法
        public static void method(){
            // 静态内部类可以直接使用外部类的静态变量
            int len=classRoom.length();
            // 静态内部类可以直接使用外部类的静态方法
            String classRoom=getClassRoom();
        }
    }


    PriorityQueue<Student> queue=new PriorityQueue<>(new Comparator<Student>() {
        /**
         * 匿名内部类，实现某个接口/某个抽象类，而不用定义子类
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Student o1, Student o2) {
            return 0;
        }
    });
}

public class DoubleCheck {

    // 加上volatile，防止指令重排
    volatile DoubleCheck instance;

    private DoubleCheck(){}

    /**
     * 获取单例
     * @return
     */
    public DoubleCheck getInstance(){
        // 第一个if，若instance不为空，直接return
        if(instance==null){
            // 加锁，防止多线程进来之后，创建多个实例
            synchronized (this){
                // 再次判断，当高并发时，多个线程都在第14行进来了，然后第一个线程进入syn代码块，创建实例
                // 其他的线程就不能再次创建实例，这个是创建单例根本
                if(instance==null){
                    instance=new DoubleCheck();
                }
            }
        }
        return instance;
    }

}
